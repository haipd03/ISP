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
                if (confirm("Bạn có chắc muốn xóa tài khoản này không?")) {
                    window.location.href = url;
                } else {
                    event.preventDefault();
                }
            }

            document.getElementById("backButton").onclick = function () {
                window.location.href = "listaccount";
            };
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
                    <div class="mb-2 md:mx-2 lg:mx-2 border-solid border-gray-200 rounded border shadow-sm w-full md:w-1/2 lg:w-2/3">
                        <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b font-bold">
                            Danh sách tài khoản
                        </div>
                        <div class="p-3">
                            <c:if test="${not empty error}">
                                <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                            </c:if>
                            <% if (request.getAttribute("errorMessage") != null) { %>
                            <div class="error" style="color: red;">
                                <%= request.getAttribute("errorMessage") %>
                            </div>
                            <% } %>
                            <form action="listaccount" method="post">
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Mã tài khoản</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tài khoản</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Mật khẩu</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Vai trò</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Họ và tên</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Email</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">CCCD</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Địa chỉ</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tùy Chọn</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listA}" var="o">
                                            <tr class="bg-white border-b">
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.accountID}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.taiKhoan}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.password}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.role}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.hoVaTen}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.email}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.CCCD}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.diaChi}</td>
                                                <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                    <a href='loadaccount?aid=${o.accountID}' class="text-indigo-600 hover:text-indigo-900">Sửa</a>
                                                    <a href='#' class="text-red-600 hover:text-red-900 ml-2" onclick="confirmDelete(event, 'deleteacc?aid=${o.accountID}')">Xóa</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                            <div class="mb-2 md:mx-2 lg:mx-2">

                                 <a href="nhapaddaccount" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700">Thêm tài khoản mới</a>

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
