<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.DichVu"%>
<%@page import="java.util.*"%>
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
                        <form method="post" action="searchdichvubysophong" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="soPhong" style="margin-right: 10px;">Số phòng ID:</label>
                                <input type="text" id="phongID" name="phongID" placeholder="Nhập số phòng" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                            </div>
                            <div class="flex" style="display: flex; align-items: center;">
                                <label for="name" style="margin-right: 10px;">Tên dịch vụ:</label>
                                <input type="text" id="name" name="name" placeholder="Nhập tên dịch vụ" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
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

                            <% if (request.getAttribute("success") != null) { %>
                            <div style="color: blue; font-size: 1.2em; font-weight: bold;">
                                <%= request.getAttribute("success") %>
                            </div>
                            <% } %>

                            <% if (session.getAttribute("success") != null) { %>
                            <div style="color: blue; font-size: 1.2em; font-weight: bold;">
                                <%= session.getAttribute("success") %>
                            </div>
                            <% 
                                session.removeAttribute("success");
                            } %>

                            <c:if test="${not empty error}">
                                <span style="color: red; font-size: 1.2em; font-weight: bold;">${error}</span>
                            </c:if>

                        </form>



                        <h4 class="text-lg font-semibold mb-2 flex justify-between items-center">Danh sách dịch vụ:
                            <c:if test="${sessionScope.acc.role == 1}">
                                <a href="insertdichvu">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm dịch vụ</button>
                                </a>
                            </c:if>
                        </h4>
                        <div class="overflow-x-auto mt-4">
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2 text-center">Mã dịch vụ</th>
                                        <th class="px-4 py-2 text-center">Số phòng ID</th>
                                        <th class="px-4 py-2 text-center">Tên</th>
                                        <th class="px-4 py-2 text-center">Giá tiền</th>
                                        <th class="px-4 py-2 text-center">Từ ngày</th>
                                        <th class="px-4 py-2 text-center">Đến ngày</th>
                                        <th class="px-4 py-2 text-center">Chỉ số cũ</th>
                                        <th class="px-4 py-2 text-center">Chỉ số mới</th>
                                            <c:if test="${sessionScope.acc.role == 1}">
                                            <th class="px-4 py-2 text-center">Thao tác</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ldv}" var="o">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2 text-center">${o.dichVuID}</td>
                                            <td class="px-4 py-2 text-center">${o.phongID}</td>
                                            <td class="px-4 py-2 text-center">${o.name}</td>
                                            <td class="px-4 py-2 text-center">${o.giaTien}</td>
                                            <td class="px-4 py-2 text-center">${o.tuNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.denNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.chiSoCu}</td>
                                            <td class="px-4 py-2 text-center">${o.chiSoMoi}</td>
                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <td class="px-4 py-2">
                                                    <a href="editdichvu?id=${o.dichVuID}" class="text-blue-500 hover:text-blue-700 mr-2">Sửa</a>
                                                    <a href="${pageContext.request.contextPath}/deletedichvu?id=${o.dichVuID}" class="text-red-500 hover:text-red-700" onclick="return confirm('Bạn có chắc chắn muốn xóa dịch vụ này không?');">Xóa</a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table><br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./main.js"></script>
    </body>
</html>
