
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.HoaDon" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Css -->
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet" href="./dist/all.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
    <title>Tables | Tailwind Admin</title>
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
                <!-- Thêm phần hiển thị hóa đon chi tiết -->
                <div class="flex-1 p-4">



                    <h4 class="text-lg font-semibold mb-2">Danh sách thông tin hóa đơn chi tiết:</h4>
                    <c:if test="${not empty error}">
                        <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                    </c:if>
                    <div class="overflow-x-auto">
                        <table class="table-auto w-full border-collapse">
                            <thead>
                                <tr class="bg-gray-200 text-gray-800">
                                    <th class="px-2 py-2 text-center">Mã hóa đơn chi tiết</th>
                                    <th class="px-2 py-2 text-center">Mã hóa đơn</th>
                                    <th class="px-2 py-2 text-center">Từ ngày</th>
                                    <th class="px-2 py-2 text-center">Đến ngày</th>
                                    <th class="px-2 py-2 text-center">Tổng số</th>
                                    <th class="px-2 py-2 text-center">Hệ số</th>
                                    <th class="px-2 py-2 text-center">Thành tiền</th>
                                    <th class="px-2 py-2 text-center">Dịch vụ</th>
                                        <c:if test="${sessionScope.acc.role == 1}">
                                        <th class="px-2 py-2 text-center">Thao tác</th>
                                        </c:if>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${lhdd}" var="o"> 
                                    <tr class="transition-colors hover:bg-gray-100">
                                        <td class="px-2 py-2 text-center">${o.hoaDonDetailID}</td>
                                        <td class="px-2 py-2 text-center">${o.hoaDonID}</td>
                                        <td class="px-2 py-2 text-center">${o.tuNgay}</td>
                                        <td class="px-2 py-2 text-center">${o.denNgay}</td>
                                        <td class="px-2 py-2 text-center">${o.tongSo}</td>
                                        <td class="px-2 py-2 text-center">${o.heSo}</td>
                                        <td class="px-4 py-2 text-center">
                                                <fmt:formatNumber value="${o.thanhTien}" pattern="#,##0 đồng" />
                                            </td>
                                        <td class="px-2 py-2 text-center">${o.dichVuID}</td>
                                        <c:if test="${hd.tinhTrangThanhToan != 'Đã thanh toán'}">
                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <td class="px-2 py-2 text-center">
                                                    <form action="loadhoadondetail" method="post" style="display: inline;">
                                                        <input type="hidden" name="id" value="${o.hoaDonDetailID}" />
                                                        <button type="submit" class="text-blue-500 hover:text-blue-700 mr-2">Sửa</button>
                                                    </form>
                                                    <form action="deletehoadondetail" method="post" style="display: inline;" onsubmit="return confirm('Bạn có chắc chắn muốn xóa chi tiết hóa đơn này không?');">
                                                        <input type="hidden" name="id" value="${o.hoaDonDetailID}" />
                                                        <button type="submit" class="text-red-500 hover:text-blue-700 mr-2">Xóa</button>
                                                    </form>
                                                </td>

                                            </c:if>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <c:if test="${hd.tinhTrangThanhToan != 'Đã thanh toán'}">
                        <c:if test="${sessionScope.acc.role == 1}">
                            <div class="mt-4">
                                <a href="inserthoadondetail?id=${hdid1}">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm hóa đơn chi tiết</button>
                                </a>
                            </div>
                        </c:if> 
                    </c:if> 
                </div>
            </div>
        </div>
        <script src="./main.js"></script>
</body>
</html>
