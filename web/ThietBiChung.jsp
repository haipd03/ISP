<%-- 
    Document   : ThietBiChung
    Created on : Jul 1, 2024, 12:27:00 AM
    Author     : Ngoc Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ThietBiChung"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

                    <div class="flex-1 p-4">
                        <!-- Form tìm kiếm -->
                        <div class="flex-1 p-4">
                            <!-- Form tìm kiếm -->
                            <form method="get" action="searchthietbichung" class="flex flex-wrap items-center gap-2">
                                <div class="flex items-center flex-grow">
                                    <label for="ten" class="w-28 text-right mr-2">Tên thiết bị chung:</label>
                                    <input type="text" id="ten" name="ten" placeholder="Nhập tên" class="border border-black flex-1 py-2 px-3 rounded">
                                </div>
                                <div class="flex items-center flex-grow">
                                    <label for="soLuong" class="w-28 text-right mr-2">Số lượng:</label>
                                    <input type="text" id="soLuong" name="soLuong" placeholder="Nhập số lượng" class="border border-black flex-1 py-2 px-3 rounded">
                                </div>
                                <div class="flex items-center flex-grow">
                                    <label for="tinhTrang" class="w-28  mr-2">Tình trạng:</label>
                                    <input type="text" id="tinhTrang" name="tinhTrang" placeholder="Nhập tình trạng" class="border border-black flex-1 py-2 px-3 rounded">
                                </div>
                                <div class="flex items-center flex-grow">
                                    <label for="gia" class="w-28  mr-2">Giá:</label>
                                    <input type="text" id="gia" name="gia" placeholder="Nhập giá" class="border border-black flex-1 py-2 px-3 rounded">
                                </div>
                                <div class="flex items-center flex-grow">
                                    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ml-auto">Tìm kiếm</button>
                                </div>
                            </form>
                        </div>
                          <c:if test="${not empty error}">
                            <span style="color: red; font-size: 1.2em; font-weight: bold;">${error}</span>
                        </c:if>
                        <h4 class="text-lg font-semibold mb-2 flex justify-between items-center">Danh sách thiết bị chung:
                            <c:if test="${sessionScope.acc.role == 0}">
                                <a href="insertthietbichung">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-3 rounded">Thêm thiết bị chung</button>
                                </a>
                            </c:if>
                        </h4>
                        <div class="overflow-x-auto ">
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2 text-center">Mã thiết bị chung</th>
                                        <th class="px-4 py-2 text-center">Mã khu</th>
                                        <th class="px-4 py-2 ">Tên</th>
                                        <th class="px-4 py-2 text-center">Số lượng</th>
                                        <th class="px-4 py-2 ">Tình trạng</th>
                                        <th class="px-4 py-2 ">Giá</th>
                                            <c:if test="${sessionScope.acc.role == 0}">
                                            <th class="px-4 py-2 text-center">Thao tác</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ltbc}" var="o">
                                        <tr class="transition-colors hover:bg-gray-100">
                                            <td class="px-4 py-2 text-center">${o.thietBiChungID}</td>
                                            <td class="px-4 py-2 text-center">${o.khuID}</td>
                                            <td class="px-4 py-2 ">${o.ten}</td>
                                            <td class="px-4 py-2 text-center">${o.soLuong}</td>
                                            <td class="px-4 py-2 ">${o.tinhTrang}</td>
<!--                                            <td class="px-4 py-2 ">${o.gia}</td>-->
                                            <td class="px-4 py-2">
                                                <fmt:formatNumber value="${o.gia}" pattern="#,##0 đồng" />
                                            </td>
                                            <c:if test="${sessionScope.acc.role == 0}">
                                                <c:choose>
                                                    <c:when test="${o.tinhTrang == 'Đang sửa'}">
                                                        <td class="px-4 py-2">
                                                            <form id="editForm" action="loadthietbichung?id=${o.thietBiChungID}" method="post">
                                                                <input type="hidden" name="thietBiChungID" value="${o.thietBiChungID}">
                                                                <button type="submit" class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Sửa</button>
                                                            </form>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${o.tinhTrang == 'Tốt'}">
                                                        <td class="px-4 py-2 ">
                                                            <div class="flex space-x-4">
                                                                <form id="editForm" action="loadthietbichung?id=${o.thietBiChungID}" method="post">
                                                                    <input type="hidden" name="thietBiChungID" value="${o.thietBiChungID}">
                                                                    <button type="submit" class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Sửa</button>
                                                                </form>
                                                                <a href="${pageContext.request.contextPath}/deletethietbichung?id=${o.thietBiChungID}" 
                                                                   class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded transition-colors duration-200" 
                                                                   onclick="return confirm('Bạn có chắc chắn muốn xóa dịch vụ này không?');">Xóa</a>
                                                            </div>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${o.tinhTrang == 'Vô hiệu hóa'}">
                                                        <td class="px-4 py-2 "></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td class="px-4 py-2 "></td>
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

