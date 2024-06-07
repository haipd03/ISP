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
        <!-- Css -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Danh sách yêu cầu</title>
        <script>
            function confirmDelete(event, url) {
                if (confirm("Bạn có chắc muốn xóa tin nhắn này?")) {
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

                    <div class="p-4">

                        <c:if test="${not empty error}">
                            <span style="color: red; font-size: 1.2em; font-weight: bold;">${error}</span>
                        </c:if>
                        <h4 class="text-lg font-semibold mb-2">Danh sách yêu cầu:</h4>
                        <div class="overflow-x-auto">
                            <div class="mb-4">
                                <form method="get">
                                    <button type="submit" name="action" value="soan" formaction="NhapRequest" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Soạn Yêu Cầu</button>
                                    <button type="submit" name="action" value="nhan" formaction="ListRequest" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">Nhận</button>
                                    <button type="submit" name="action" value="gui" formaction="ListRequest?action=gui" class="bg-orange-500 hover:bg-orange-700 text-white font-bold py-2 px-4 rounded">Gửi</button>
                                </form>

                            </div>
                            <h1><p style="color: green;">${message1}</p></h1>
                                <c:choose>
                                    <c:when test="${empty param.action or param.action == 'nhan'}">
                                    <form method="get" action="SearchRequest" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="accountID" style="margin-right: 10px;">Người gửi:</label>
                                            <select id="accountID" name="accountID" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                                <c:forEach items="${listK3}" var="a">
                                                    <c:if test="${a.accountID != sessionScope.acc.accountID}">
                                                        <c:if test="${sessionScope.acc.role == 1}">
                                                            <c:if test="${a.role == 0}">
                                                                <option value="${a.accountID}">${a.hoVaTen}</option>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${sessionScope.acc.role == 0}">
                                                            <option value="${a.accountID}">${a.hoVaTen}</option>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div> 

                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="title" style="margin-right: 10px;">Tiêu đề:</label>
                                            <input type="text" id="title" name="title" placeholder="Tiêu đề" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                        </div>

                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="submittedAt" style="margin-right: 10px;">Thời gian</label>
                                            <input type="date" id="submittedAt" name="submittedAt" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                                        </div>

                                        <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-left: 10px;">Tìm kiếm</button>


                                    </form>
                                    <table class="table-auto w-full border-collapse">
                                        <thead>
                                            <tr class="bg-gray-200 text-gray-800">
                                                <th class="px-4 py-2">RequestID</th>
                                                <th class="px-4 py-2">Người Gửi</th>
                                                <th class="px-4 py-2">Tiêu Đề</th>
                                                <th class="px-4 py-2">Thời Gian</th>
                                                <th class="px-4 py-2">Tình Trạng</th>
                                                <th class="px-4 py-2">Thao Tác </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requests}" var="r">
                                                <tr class="transition-colors hover:bg-gray-100">
                                                    <td class="px-4 py-2">${r.requestID}</td>
                                                    <td class="px-4 py-2">
                                                        <c:forEach items="${listK3}" var="a">
                                                            <c:if test="${a.accountID == r.accountID}">
                                                                ${a.hoVaTen}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td class="px-4 py-2">${r.title}</td>
                                                    <td class="px-4 py-2">
                                                        <fmt:formatDate value="${r.submittedAt}" pattern="HH:mm - dd/MM/yyyy"/>
                                                    </td>

                                                    <td class="px-4 py-2">${r.tinhTrang}</td>
                                                    <td class="px-4 py-2">
                                                        <a href="LoadRequest?id=${r.requestID}" class="text-blue-500 hover:text-blue-700 mr-2">Chi tiết</a>
                                                        <a href="DeleteRequest?id=${r.requestID}" class="text-red-500 hover:text-red-700" onclick="confirmDelete(event, this.href)">Xóa</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:when>

                            </c:choose>

                            <!-- Form Soạn Yêu Cầu -->
                            <c:choose>
                                <c:when test="${param.action == 'gui'}">
                                    <form method="post" action="SearchRequest" style="display: flex; flex-wrap: wrap; gap: 15px; align-items: center; margin-bottom: 20px;">
                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="accountNhan" style="margin-right: 10px;">Người Nhận:</label>
                                            <select id="accountNhan" name="accountNhan" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                                <c:forEach items="${listK3}" var="a">
                                                    <c:if test="${a.accountID != sessionScope.acc.accountID}">
                                                        <c:if test="${sessionScope.acc.role == 1}">
                                                            <c:if test="${a.role == 0}">
                                                                <option value="${a.accountID}">${a.hoVaTen}</option>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${sessionScope.acc.role == 0}">
                                                            <option value="${a.accountID}">${a.hoVaTen}</option>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div> 

                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="title" style="margin-right: 10px;">Tiêu đề:</label>
                                            <input type="text" id="title" name="title" placeholder="Tiêu đề" style="border: 1px solid black; width: 150px;" class="py-2 px-3 rounded">
                                        </div>

                                        <div class="flex" style="display: flex; align-items: center;">
                                            <label for="submittedAt" style="margin-right: 10px;">Thời gian</label>
                                            <input type="date" id="submittedAt" name="submittedAt" style="border: 1px solid black; width: 180px;" class="py-2 px-3 rounded">
                                        </div>

                                        <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" style="margin-left: 10px;">Tìm kiếm</button>


                                    </form>
                                    <table class="table-auto w-full border-collapse">
                                        <thead>
                                            <tr class="bg-gray-200 text-gray-800">
                                                <th class="px-4 py-2">RequestID</th>
                                                <th class="px-4 py-2">Người Nhận</th>
                                                <th class="px-4 py-2">Tiêu Đề</th>
                                                <th class="px-4 py-2">Thời Gian</th>
                                                <th class="px-4 py-2">Tình Trạng</th>
                                                <th class="px-4 py-2">Thao Tác </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${gui}" var="g">
                                                <tr class="transition-colors hover:bg-gray-100">
                                                    <td class="px-4 py-2">${g.requestID}</td>
                                                    <td class="px-4 py-2">
                                                        <c:forEach items="${listK3}" var="a">
                                                            <c:if test="${a.accountID == g.accountNhan}">
                                                                ${a.hoVaTen}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td class="px-4 py-2">${g.title}</td>
                                                    <td class="px-4 py-2">
                                                        <fmt:formatDate value="${g.submittedAt}" pattern="HH:mm - dd/MM/yyyy"/>
                                                    </td>
                                                    <td class="px-4 py-2">${g.tinhTrang}</td>
                                                    <td class="px-4 py-2">
                                                        <a href="ReadRequestGui?id=${g.requestID}" class="text-blue-500 hover:text-blue-700 mr-2">Chi tiết</a>
                                                        <a href="DeleteRequest?id=${g.requestID}" class="text-red-500 hover:text-red-700" onclick="confirmDelete(event, this.href)">Xóa</a>
                                                    </td>
                                                </c:forEach>
                                        </tbody>
                                    </table>
                                </c:when>

                            </c:choose>

                        </div>
                    </div>
                </div>
            </div>
            <script src="./main.js"></script>
        </div>
    </body>
</html>
