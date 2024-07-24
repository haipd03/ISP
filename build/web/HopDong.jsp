<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
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
        <title>Forms | Tailwind Admin</title>
        <script>
            function confirmDelete(event, url) {
                if (confirm("Bạn có chắc muốn xóa hợp đồng này không?")) {
                    window.location.href = url;
                } else {
                    event.preventDefault();
                }
            }
        </script>

        <style>
            .container {
                background-color: white; /* Màu đỏ nhạt hơn */
                padding: 10px;
                display: flex;
                flex-wrap: wrap; /* Nếu muốn các phần tử xuống dòng khi hết chỗ */
            }
            .item {
                color: #f03c3c;
                font-size: 1em;
                font-weight: bold;
                margin-right: 10px; /* Khoảng cách giữa các phần tử */
            }
        </style>
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
                    <!--/Sidebar-->

                    <!-- Underline form -->
                    <div class="mb-2 md:mx-2 lg:mx-2 border-solid border-gray-200 rounded border shadow-sm w-full md:w-1/2 lg:w-4/5">

                        <form method="post" action="searchhopdong" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="hovaten" style="margin-right: 10px;">HỌ VÀ TÊN:</label>
                                <input type="text" id="hovaten" name="hovaten" placeholder="Nhập họ và tên" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="sokhachthue" style="margin-right: 10px;">SỐ KHÁCH THUÊ:</label>
                                <input type="text" id="sokhachthue" name="sokhachthue" placeholder="Nhập SỐ KHÁCH THUÊ" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="ngaythue" style="margin-right: 10px;">NGÀY THUÊ:</label>
                                <input type="date" id="ngaythue" name="ngaythue" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="ngaytra" style="margin-right: 10px;">NGÀY TRẢ:</label>
                                <input type="date" id="ngaytra" name="ngaytra" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                            </div>
                            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-left: 10px;">Tìm kiếm</button>


                        </form>

                        <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b font-bold">
                            Hợp Đồng
                        </div>
                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>

<!--                        <div class="container">
                            <c:if test="${not empty list11}">
                                <div class="item">
                                    Lưu ý các hợp đồng sắp hết hạn có mã:
                                    <c:forEach items="${list11}" var="a" varStatus="status">
                                        <c:if test="${a.hopDongID != null}">
                                            ${a.hopDongID}<c:if test="${status.last}"> </c:if>
                                            <c:if test="${!status.last}">, </c:if>  Thay dấu ';' bằng dấu ',' nếu không muốn có dấu phân cách nào khác 
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>-->

                        <div class="p-3">
                            <form action="listhopdong" method="post">
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Mã Hợp Đồng</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Mã Khách</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Mã Phòng</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tiền Cọc</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Ngày Thuê</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Ngày Trả</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Số Khách Thuê Phòng</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Ghi Chú</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">CCCD</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Số Điện Thoại</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Họ Và Tên Đại Diện Phòng</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tình Trạng</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tùy Chọn</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listK}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hopDongID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khachID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.phongID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.tienCoc}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ngayThue}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ngayTra}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.soKhachThue}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ghiChu}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.CCCD}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDT}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hoVaTen}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <c:choose>
                                                            <c:when test="${o.tinhTrang == 0}">
                                                                Không còn Thuê
                                                            </c:when>
                                                            <c:when test="${o.tinhTrang == 1}">
                                                                Đang Thuê
                                                            </c:when>
                                                        </c:choose>
                                                    </td>

                                                </tr>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${listK1}" var="o">
                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hopDongID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khachID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.phongID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.tienCoc}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ngayThue}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ngayTra}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.soKhachThue}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.ghiChu}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.CCCD}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDT}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hoVaTen}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <c:choose>
                                                            <c:when test="${o.tinhTrang == 0}">
                                                                Không còn Thuê
                                                            </c:when>
                                                            <c:when test="${o.tinhTrang == 1}">
                                                                Đang Thuê
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                    <c:if test="${o.tinhTrang == 1}">
                                                        <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                            <form action='loadhopdong' method='post' style='display: inline;'>
                                                            </form>

                                                            <form action='loadhopdong' method='post' style='display: inline;'>
                                                                <input type='hidden' name='lhdid' value='${o.hopDongID}' />
                                                                <input type='hidden' name='lpid' value='${o.phongID}' />
                                                                <button type='submit' class='text-indigo-600 hover:text-indigo-900'>Sửa</button>
                                                            </form>
                                                            <a href='#' class="text-red-600 hover:text-red-900 ml-2" onclick="confirmDelete(event, 'deletehopdong?hdid=${o.hopDongID}')">Xóa</a>

                                                        </td>
                                                    </c:if>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                            <c:if test="${sessionScope.acc.role == 0}">
                                <div class="flex justify-between mt-4">
                                    <c:if test="${currentPage > 1}">
                                        <a href="listhopdong?page=${currentPage - 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Quay về</a>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages}">
                                        <a href="listhopdong?page=${currentPage + 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tiếp</a>
                                    </c:if>
                                </div>
                            </c:if>

                            <c:if test="${sessionScope.acc.role == 1}">
                                <div class="flex justify-between mt-4">
                                    <c:if test="${currentPage > 1}">
                                        <a href="listhopdong?page=${currentPage - 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Quay về</a>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages1}">
                                        <a href="listhopdong?page=${currentPage + 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tiếp</a>
                                    </c:if>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <!--/Underline form-->
                <!--/Main-->
            </div>
            <!--Footer-->
             <footer class="bg-grey-darkest text-white p-2">
<!--                    <div class="flex flex-1 mx-auto">&copy; My Design</div>-->
                </footer>
            <!--/footer-->
        </div>

    </div>

    <script src="./main.js"></script>

</body>

</html>
