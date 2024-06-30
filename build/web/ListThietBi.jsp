<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Danh sách yêu cầu</title>
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

                    <div class="p-4">

                        <c:if test="${not empty error}">
                            <span style="color: red; font-size: 1.2em; font-weight: bold;">${error}</span>
                        </c:if>
                        <h4 class="text-lg font-semibold mb-2">Danh Sách Thiết Bị</h4>
                        <div class="overflow-x-auto">
                            <form method="post" action="ListAllThietBi" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                                <c:if test="${sessionScope.acc.role == 0}">
                                    <div class="flex" style="display: flex; align-items: center;">
                                        <label for="accountID" style="margin-right: 10px;">Quản Lý:</label>
                                        <select id="accountID" name="accountID" style="border: 1px solid black; width: 105px;" class="py-2 px-3 rounded">
                                            <option value="">Quản Lý</option>
                                            <c:forEach items="${listK3}" var="a">
                                                <c:if test="${a.accountID != sessionScope.acc.accountID}">

                                                    <option value="${a.accountID}">${a.hoVaTen}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="flex" style="display: flex; align-items: center;">
                                        <label for="khuID" style="margin-right: 10px;">Khu: </label>
                                        <select id="khuID" name="khuID" style="border: 1px solid black; width: 80px;" class="py-2 px-3 rounded">
                                            <option value="">Khu</option> 
                                            <c:forEach items="${listK}" var="khu">
                                                <option value="${khu.khuID}">${khu.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </c:if>
                                <%--<c:if test="${sessionScope.acc.role == 1}">--%>
                                    <!--<input type="hidden" name="accountID" value="${sessionScope.acc.accountID}">-->
                                <%--</c:if>--%>
                                <div class="flex" style="display: flex; align-items: center;">
                                    <label for="soPhong" style="margin-right: 10px;">Số Phòng: </label>
                                    <input type="soPhong" id="soPhong" name="soPhong" placeholder="Nhập Số phòng" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>
                                <div class="flex" style="display: flex; align-items: center;">
                                    <label for="name" style="margin-right: 10px;">Tên Thiết Bị: </label>
                                    <input type="name" id="name" name="name" placeholder="Nhập tên thiết bị" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                </div>
                                <div class="flex" style="display: flex; align-items: center;">
                                    <label for="tinhTrang" style="margin-right: 10px;">Tình Trạng </label>
                                    <input type="tinhTrang" id="tinhTrang" name="tinhTrang" placeholder="Tình trạng" style="border: 1px solid black; width: 120px;" class="py-2 px-3 rounded">
                                </div>
                                <div class="flex" style="display: flex; align-items: center;">
                                    <label for="gia" style="margin-right: 10px;">Giá </label>
                                    <input type="gia" id="gia" name="gia" placeholder="Nhập giá" style="border: 1px solid black; width: 100px;" class="py-2 px-3 rounded">
                                </div>
                                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-left: 10px;">Tìm kiếm</button>
                            </form>
                            <h4 class="text-lg font-semibold mb-2">Danh Sách Thiết Bị Theo Yêu Cầu:</h4>
                            <table class="table-auto w-full border-collapse">
                                <thead>
                                    <tr class="bg-gray-200 text-gray-800">
                                        <th class="px-4 py-2">Khu</th>
                                        <th class="px-4 py-2">Số Phòng</th>
                                        <th class="px-4 py-2">Mã Thiết Bị</th>
                                        <th class="px-4 py-2">Tên Thiết Bị</th>
                                        <th class="px-4 py-2">Số Lượng</th>
                                        <th class="px-4 py-2">Tình Trạng</th>
                                        <th class="px-4 py-2">Giá </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ltb}" var="l">
                                        <c:forEach items="${listP}" var="p">
                                            <c:if test="${l.phongID == p.phongID}">
                                                <c:forEach items="${listK}" var="k">
                                                    <c:if test="${k.khuID == p.khuID}">
                                                        <c:choose>
                                                            <c:when test="${sessionScope.acc.role == 0 || (sessionScope.acc.role == 1 && k.accountID == sessionScope.acc.accountID)}">
                                                                <tr class="transition-colors hover:bg-gray-100">
                                                                    <td class="px-4 py-2">${k.name}</td>
                                                                    <td class="px-4 py-2">${p.soPhong}</td>
                                                                    <td class="px-4 py-2">${l.thietBiID}</td>
                                                                    <td class="px-4 py-2">${l.name}</td>
                                                                    <td class="px-4 py-2">${l.soLuong}</td>
                                                                    <td class="px-4 py-2">${l.tinhTrang}</td>
                                                                    <td class="px-4 py-2">
                                                                        <fmt:formatNumber value="${l.gia}" pattern="#,##0 đồng" />
                                                                    </td>
                                                                </tr>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </tbody>
                            </table>
                            
                                                        <c:if test="${sessionScope.acc.accountID == 1}">
                                <div class="flex justify-between mt-4">
                                    <c:if test="${currentPage > 1}">
                                        <a href="ListAllThietBi?page=${currentPage - 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Quay về</a>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages}">
                                        <a href="ListAllThietBi?page=${currentPage + 1}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Tiếp</a>
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
