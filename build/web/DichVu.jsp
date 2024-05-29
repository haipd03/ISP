<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.DichVu" %>
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
        <title>Danh sách dịch vụ</title>
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
                    <!-- Thêm phần hiển thị danh sách dịch vụ -->
                    <div class="p-4">
                        <!-- Form tìm kiếm -->
                         <form method="post" action="searchdichvubysophong">
                            <label for="soPhong">Tìm kiếm theo số phòng:</label>
                            <input type="text" id="soPhong" name="soPhong" placeholder="Nhập số phòng">
                            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tìm kiếm</button>
                        </form>
                        <h4 class="text-lg font-semibold mb-2 flex justify-between items-center">Danh sách dịch vụ:
                            <a href="insertdichvu">
                                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm dịch vụ</button>
                            </a>
                        </h4>
                        <div class="overflow-x-auto mt-4">
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2">DichVuID</th>
                                        <th class="px-4 py-2">SoPhong</th>
                                        <th class="px-4 py-2">Name</th>
                                        <th class="px-4 py-2">GiaTien</th>
                                        <th class="px-4 py-2">TuNgay</th>
                                        <th class="px-4 py-2">DenNgay</th>
                                        <th class="px-4 py-2">ChiSoCu</th>
                                        <th class="px-4 py-2">ChiSoMoi</th>
                                        <th class="px-4 py-2">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ldv}" var="o">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2 text-center">${o.dichVuID}</td>
                                            <td class="px-4 py-2 text-center">${o.soPhong}</td>
                                            <td class="px-4 py-2 text-center">${o.name}</td>
                                            <td class="px-4 py-2 text-center">${o.giaTien}</td>
                                            <td class="px-4 py-2 text-center">${o.tuNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.denNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.chiSoCu}</td>
                                            <td class="px-4 py-2 text-center">${o.chiSoMoi}</td>
                                            <td class="px-4 py-2">
                                                <a href="editdichvu?id=${o.dichVuID}" class="text-blue-500 hover:text-blue-700 mr-2">Sửa</a>
                                               <a href="deletedichvu?id=${o.dichVuID}" class="text-red-500 hover:text-red-700" onclick="return confirm('Bạn có chắc chắn muốn xóa dịch vụ này không?');">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table><br>
                            <c:if test="${not empty error}">
                                <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <script src="./main.js"></script>
    </body>
</html>
