<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.DichVuChung"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- CSS -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Danh sách dịch vụ chung</title>
    </head>
    <body>
        <!-- Container -->
        <div class="mx-auto bg-grey-lightest">
            <!-- Screen -->
            <div class="min-h-screen flex flex-col">
                <!-- Header Section Starts Here -->
                <jsp:include page="menu1.jsp" />
                <!-- /Header -->

                <div class="flex flex-1">
                    <!-- Sidebar -->
                    <jsp:include page="menu2.jsp" />
                    <!-- Main content -->
                    <div class="p-4">

                        <form method="post" action="searchdichvuchung" style="margin-bottom: 20px;">
                            <div style="display: flex; gap: 15px; flex-wrap: wrap; align-items: flex-end;">
                                <div style="display: flex; flex-direction: column;">
                                    <label for="khu" style="margin-bottom: 5px;">Mã Khu:</label>
                                    <select id="khu" name="khuID" style="border: 1px solid black; width: 120px;" class="py-2 px-3 rounded">
                                        <option value="" disabled selected hidden>Chọn Khu</option>
                                        <c:forEach items="${khu}" var="khu">
                                            <option value="${khu.khuID}">${khu.khuID}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="dichVuChungName" style="margin-bottom: 5px;">Tên dịch vụ chung:</label>
                                    <input type="text" id="dichVuChungName" name="dichVuChungName" placeholder="Nhập tên dịch vụ chung" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="ten" style="margin-bottom: 5px;">Tên công nhân:</label>
                                    <input type="text" id="ten" name="ten" placeholder="Nhập tên" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="sdt" style="margin-bottom: 5px;">Số điện thoại:</label>
                                    <input type="text" id="sdt" name="sdt" placeholder="Nhập số điện thoại" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="tuNgay" style="margin-bottom: 5px;">Từ ngày:</label>
                                    <input type="date" id="tuNgay" name="tuNgay" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="denNgay" style="margin-bottom: 5px;">Đến ngày:</label>
                                    <input type="date" id="denNgay" name="denNgay" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>

                                <div style="display: flex; flex-direction: column;">
                                    <label for="tinhTrang" style="margin-bottom: 5px;">Tình trạng:</label>
                                    <select id="tinhTrang" name="tinhTrang" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                                        <option value="" disabled selected hidden>Chọn tình trạng</option>
                                        <option value="Chưa làm">Chưa làm</option>
                                        <option value="Đang làm">Đang làm</option>
                                        <option value="Đã hoàn thành">Đã hoàn thành</option>
                                    </select>
                                </div>

                                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-top: 20px;">Tìm kiếm</button>
                            </div>
                        </form>

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

                        <h4 class="text-lg font-semibold mb-2 flex justify-between items-center">
                            Danh sách dịch vụ chung:
                            <c:if test="${sessionScope.acc.role == 0}">
                                <a href="insertdichvuchung">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm dịch vụ chung</button>
                                </a>
                            </c:if>
                        </h4>
                        <div class="overflow-x-auto mt-4">
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2 text-center">Mã dịch vụ chung</th>
                                        <th class="px-4 py-2 text-center">Mã Khu</th>
                                        <th class="px-4 py-2 text-center">Tên dịch vụ chung</th>
                                        <th class="px-4 py-2 text-center">Tên công nhân</th>
                                        <th class="px-4 py-2 text-center">Số điện thoại</th>
                                        <th class="px-4 py-2 text-center">Giá tiền</th>
                                        <th class="px-4 py-2 text-center">Từ ngày</th>
                                        <th class="px-4 py-2 text-center">Đến ngày</th>
                                        <th class="px-4 py-2 text-center">Tình trạng</th>
                                        <th class="px-4 py-2 text-center">Ghi chú</th>
                                            <c:if test="${sessionScope.acc.role == 0}">
                                            <th class="px-4 py-2 text-center">Thao tác</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ldvc}" var="o">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2 text-center">${o.dichVuChungID}</td>
                                            <td class="px-4 py-2 text-center">${o.khuID}</td>
                                            <td class="px-4 py-2 text-center">${o.dichVuChungName}</td>
                                            <td class="px-4 py-2 text-center">${o.ten}</td>
                                            <td class="px-4 py-2 text-center">${o.sdt}</td>
                                            <td class="px-4 py-2 text-center">${o.gia}</td>
                                            <td class="px-4 py-2 text-center">${o.tuNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.denNgay}</td>
                                            <td class="px-4 py-2 text-center">${o.tinhTrang}</td>
                                            <td class="px-4 py-2 text-center">${o.ghiChu}</td>


                                            <c:if test="${sessionScope.acc.role == 0}">
                                                <c:choose>
                                                    <c:when test="${o.tinhTrang == 'Đang làm'}">
                                                        <td class="px-4 py-2">
                                                            <form id="editForm" action="editdichvuchung?id=${o.dichVuChungID}" method="post">
                                                                <input type="hidden" name="dichVuChungID" value="${o.dichVuChungID}">
                                                                <button type="submit" class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Sửa</button>
                                                            </form>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${o.tinhTrang == 'Chưa làm'}">
                                                        <td class="px-4 py-2">
                                                            <div class="flex space-x-4">
                                                                <form id="editForm" action="editdichvuchung?id=${o.dichVuChungID}" method="post">
                                                                    <input type="hidden" name="dichVuChungID" value="${o.dichVuChungID}">
                                                                    <button type="submit" class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Sửa</button>
                                                                </form>
                                                                <a href="${pageContext.request.contextPath}/deletedichvuchung?id=${o.dichVuChungID}" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded transition-colors duration-200" onclick="return confirm('Bạn có chắc chắn muốn xóa dịch vụ chung này không?');">Xóa</a>
                                                            </div>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${o.tinhTrang == 'Đã hoàn thành'}">
                                                        <td class="px-4 py-2"></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td class="px-4 py-2"></td>
                                                    </c:otherwise>
                                                </c:choose>
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
