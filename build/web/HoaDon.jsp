<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.HoaDon" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Css -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Danh sách thông tin hóa đơn</title>
    </head>
    <body>
        <!--Container -->
        <div class="mx-auto bg-grey-lightest">
            <!--Screen-->
            <div class="min-h-screen flex flex-col">
                <!--Header Section Starts Here-->
                <jsp:include page="menu1.jsp" />
                <!--/Header-->
                <div class="flex flex-1">
                    <!--Sidebar-->
                    <jsp:include page="menu2.jsp" />
                    <!-- Thêm phần hiển thị danh sách thiết bị -->
                    <div class="p-4">

                        <!-- Form tìm kiếm -->
                        <form method="post" action="searchhoadon" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="soPhong" style="margin-right: 10px;">Số phòng :</label>
                                <input type="text" id="soPhong" name="soPhong" placeholder="Nhập số phòng" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="tinhTrangThanhToan" style="margin-right: 10px;">Trạng thái:</label>
                                <input type="text" id="tinhTrangThanhToan" name="tinhTrangThanhToan" placeholder="Nhập tên dịch vụ" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="tuNgay" style="margin-right: 10px;">Từ ngày:</label>
                                <input type="date" id="tuNgay" name="tuNgay" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="denNgay" style="margin-right: 10px;">Đến ngày:</label>
                                <input type="date" id="denNgay" name="denNgay" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                            </div>
                            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-left: 10px;">Tìm kiếm</button>
                        </form>

                        <c:if test="${not empty error}">
                            <span style="color: red; font-size: 1.2em; font-weight: bold;">${error}</span>
                        </c:if>


                        <h4 class="text-lg font-semibold mb-2">Danh sách thông tin hóa đơn:</h4>
                        <div class="overflow-x-auto">

                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2">Mã hóa đơn</th>
                                        <th class="px-4 py-2">Mã hợp đồng</th>
                                        <th class="px-4 py-2">Số phòng</th>
                                        <th class="px-4 py-2">Ngày thanh toán</th>
                                        <th class="px-4 py-2">Tình trạng</th>
                                        <th class="px-4 py-2">Từ ngày</th>
                                        <th class="px-4 py-2">Đến ngày</th>
                                        <th class="px-4 py-2">Tổng tiền</th>
                                        <th class="px-4 py-2">Thông tin </th>
                                            <c:if test="${sessionScope.acc.role == 1}">
                                            <th class="px-4 py-2">Thao tác</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lhd}" var="o">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2">${o.hoaDon.hoaDonID}</td>
                                            <td class="px-4 py-2">${o.hoaDon.hopDongID}</td>
                                            <td class="px-4 py-2">${o.soPhong}</td>
                                            <td class="px-4 py-2">${o.hoaDon.ngayThanhToan}</td>
                                            <td class="px-4 py-2">${o.hoaDon.tinhTrangThanhToan}</td>
                                            <td class="px-4 py-2">${o.hoaDon.tuNgay}</td>
                                            <td class="px-4 py-2">${o.hoaDon.denNgay}</td>
                                            <td class="px-4 py-2">${o.hoaDon.tongTien}</td>

                                            <td class="px-4 py-2">
                                                <a href="listhoadondetail?id=${o.hoaDon.hoaDonID}" class="text-blue-500 hover:text-red-700">Chi tiết</a>

                                                <c:if test="${o.hoaDon.tinhTrangThanhToan == 'Đã thanh toán'}">
                                                    <a href="generatePDFhoadon?id=${o.hoaDon.hoaDonID}" class="text-red-500 hover:text-blue-700 mr-2">Xuất file PDF</a>
                                                </c:if> 
                                            </td>

                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <c:if test="${o.hoaDon.tinhTrangThanhToan == 'Chưa Thanh Toán'}">

                                                    <td class="px-4 py-2">
                                                        <form action="deletehoadon" method="post" style="display: inline;" onsubmit="return confirm('Bạn có chắc chắn muốn xóa hóa đơn này không?');">
                                                            <input type="hidden" name="id" value="${o.hoaDon.hoaDonID}" />
                                                            <button type="submit" class="text-red-500 hover:text-red-700">Xóa</button>
                                                        </form>
                                                    </td>
                                                </c:if> 
                                            </c:if> 
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table><br>
                            <c:if test="${sessionScope.acc.role == 0}">
                                <div class="flex justify-between mt-4">
                                    <c:if test="${currentPage > 1}">
                                        <a href="listhoadon?page=${currentPage - 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Quay về</a>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages}">
                                        <a href="listhoadon?page=${currentPage + 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tiếp</a>
                                    </c:if>
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.acc.role == 1}">
                                <div class="flex justify-between mt-4">
                                    <c:if test="${currentPage > 1}">
                                        <a href="listhoadon?page=${currentPage - 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Quay về</a>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages1}">
                                        <a href="listhoadon?page=${currentPage + 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tiếp</a>
                                    </c:if>
                                </div>
                            </c:if>  
                        </div>
                    </div>
                </div>
            </div>
            <script src="./main.js"></script>
        </div>
    </body>
</html>
