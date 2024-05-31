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
                if (confirm("Bạn có chắc muốn xóa khu này không?")) {
                    window.location.href = url;
                } else {
                    event.preventDefault();
                }
            }
        </script>
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
                        <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b font-bold">
                            Chi Tiết Khách Thuê
                        </div>
                        <div class="p-3">
                            <form action="listchitietkhachthue" method="post">
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Khách ID</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Họ Và Tên</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">CCCD</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Số Điện Thoại</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Quê Quán</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tên Người Thân</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Số Điện Thoại Người Thân</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Quan Hệ Với Người Thân</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Phòng ID</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tình Trạng</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listK}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khachID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hoVaTen}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.CCCD}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDT}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.queQuan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.tenNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDTNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.quanHeVoiNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.phongID}</td>
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
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khachID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hoVaTen}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.CCCD}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDT}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.queQuan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.tenNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.SDTNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.quanHeVoiNguoiThan}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.phongID}</td>
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
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
                <!--/Underline form-->
                <!--/Main-->
            </div>
            <!--Footer-->
            <footer class="bg-grey-darkest text-white p-2">
                <div class="flex flex-1 mx-auto">&copy; My Design</div>
            </footer>
            <!--/footer-->
        </div>

    </div>

    <script src="./main.js"></script>

</body>

</html>
