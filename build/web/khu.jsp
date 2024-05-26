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

            function showAddKhuForm() {
                var addKhuForm = document.getElementById("addKhuForm");
                if (addKhuForm.style.display === "none" || addKhuForm.style.display === "") {
                    addKhuForm.style.display = "block";
                } else {
                    addKhuForm.style.display = "none";
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
                    <div class="mb-2 md:mx-2 lg:mx-2 border-solid border-gray-200 rounded border shadow-sm w-full md:w-1/2 lg:w-2/3">
                        <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b font-bold">
                            Khu
                        </div>
                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                        <div class="p-3">
                            <form action="khu" method="post">
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">KhuID</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Name</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tên Quản Lý</th>
                                                <c:if test="${sessionScope.acc.accountID == 1}">
                                                <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tùy Chọn</th>
                                                </c:if>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listK}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        ${o.khuID}
                                                        <input type="hidden" name="khuID" value="${o.khuID}">
                                                    </td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.name}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <c:forEach items="${listK3}" var="a">
                                                            <c:if test="${a.accountID == o.accountID}">
                                                                ${a.hoVaTen}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <a href='loadkhu?lkid=${o.khuID}' class="text-indigo-600 hover:text-indigo-900">Update</a>
                                                        <a href='#' class="text-red-600 hover:text-red-900 ml-2" onclick="confirmDelete(event, 'deletekhu?kid=${o.khuID}')">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${listK1}" var="o">
                                            <c:if test="${sessionScope.acc.role == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khuID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.name}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <c:forEach items="${listK3}" var="a">
                                                            <c:if test="${a.accountID == o.accountID}">
                                                                ${a.hoVaTen}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                            <c:if test="${sessionScope.acc.accountID == 1}">
                                <div class="mb-2 md:mx-2 lg:mx-2">
                                    <button onclick="showAddKhuForm()" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700">Thêm khu mới</button>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div id="addKhuForm" class="hidden mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg max-w-lg">
                        <div class="bg-gray-400 text-black px-4 py-3 rounded-t-lg">
                            Thêm Khu
                        </div>
                        <div class="p-6 bg-white">
                            <form action="addkhu" method="post">
                                <div class="space-y-4">
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">ID Khu</label>
                                        <input type="text" name="khuID" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-gray-400">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Tên Khu</label>
                                        <input type="text" name="name" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-gray-400">
                                    </div>
                                    <label class="w-1/3 text-gray-700 font-semibold">Tên Quản Lý</label>
                                    <select name="accountID" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listK3}" var="o">
                                            <c:if test="${o.accountID ne 1}">
                                                <option value="${o.accountID}">${o.hoVaTen}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mt-4">
                                    <input type="submit" value="Add" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700">
                                </div>
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
