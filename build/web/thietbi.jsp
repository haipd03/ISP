<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
<%@page import = "model.ThietBi" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Css -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Tables | Tailwind Admin</title>
        <script>
            function confirmDelete(event, url) {
                if (confirm("Bạn có chắc muốn xóa thiết bị này không?")) {
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
                    <!-- Thêm phần hiển thị danh sách thiết bị -->
                    <div class="p-4">
                        <h4 class="text-lg font-semibold mb-2">Danh sách thiết bị:</h4>
                        <div class="overflow-x-auto">
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2">Thiết bị ID</th>
                                        <th class="px-4 py-2">Phòng ID</th>
                                        <th class="px-4 py-2">Tên thiết bị</th>
                                        <th class="px-4 py-2">Số lượng</th>
                                        <th class="px-4 py-2">Tình trạng</th>
                                        <th class="px-4 py-2">Giá</th>
                                        <th class="px-4 py-2">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ltb}" var="thietBi">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2">${thietBi.thietBiID}</td>
                                            <td class="px-4 py-2">${thietBi.phongID}</td>
                                            <td class="px-4 py-2">${thietBi.name}</td>
                                            <td class="px-4 py-2">${thietBi.soLuong}</td>
                                            <td class="px-4 py-2">${thietBi.tinhTrang}</td>
                                            <td class="px-4 py-2">${thietBi.gia}</td>
                                            <td class="px-4 py-2">
                                                <a href="editthietbi?tbid=${thietBi.thietBiID}" class="text-blue-500 hover:text-blue-700 mr-2">Sửa</a>
                                                <a href="#" class="text-red-500 hover:text-red-700" onclick="confirmDelete(event, 'deletethietbi?tbid=${thietBi.thietBiID}')">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table><br>
                            <c:if test="${not empty error}">
                                <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                            </c:if>
                            <div class="mt-4">
                                <a href="inserttb?ib=${phongID}">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm thiết bị</button>
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <script src="./main.js"></script>
    </body>
</html>
