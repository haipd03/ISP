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
    </head>

    <body>
        <!--Container -->
        <div class="mx-auto bg-grey-lightest">
            <!--Screen-->
            <div class="min-h-screen flex flex-col">
                <!--Header Section Starts Here-->
                <header class="bg-nav">
                    <div class="flex justify-between">
                        <div class="p-1 mx-3 inline-flex items-center">
                            <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                            <h1 class="text-white p-2">Logo</h1>
                        </div>
                        <div class="p-1 flex flex-row items-center">
                            <img onclick="profileToggle()" class="inline-block h-8 w-8 rounded-full" src="https://avatars0.githubusercontent.com/u/4323180?s=460&v=4" alt="">
                            <a href="#" onclick="profileToggle()" class="text-white p-2 no-underline hidden md:block lg:block">Adam Wathan</a>
                            <div id="ProfileDropDown" class="rounded hidden shadow-md bg-white absolute pin-t mt-12 mr-1 pin-r">
                                <ul class="list-reset">
                                    <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">My account</a></li>
                                    <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Notifications</a></li>
                                    <li><hr class="border-t mx-2 border-grey-ligght"></li>
                                    <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </header>
                <!--/Header-->

                <div class="flex flex-1">
                    <!--Sidebar-->
                    <aside id="sidebar" class="bg-side-nav w-1/2 md:w-1/6 lg:w-1/6 border-r border-side-nav hidden md:block lg:block">
                        <div class="flex">

                        </div>
                        <ul class="list-reset flex flex-col">
                            <li class=" w-full h-full py-3 px-2 border-b border-light-border ">
                                <a href="index.html"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fas fa-tachometer-alt float-left mx-2"></i>
                                    Dashboard
                                    <span><i class="fas fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-light-border bg-white">
                                <a href="forms.html"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fab fa-wpforms float-left mx-2"></i>
                                    Forms
                                    <span><i class="fa fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-light-border">
                                <a href="buttons.html"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fas fa-grip-horizontal float-left mx-2"></i>
                                    Buttons
                                    <span><i class="fa fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-light-border">
                                <a href="tables.html"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fas fa-table float-left mx-2"></i>
                                    Tables
                                    <span><i class="fa fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-light-border">
                                <a href="ui.html"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fab fa-uikit float-left mx-2"></i>
                                    Ui components
                                    <span><i class="fa fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-300-border">
                                <a href="modals.html" class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fas fa-square-full float-left mx-2"></i>
                                    Modals
                                    <span><i class="fa fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2">
                                <a href="#"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="far fa-file float-left mx-2"></i>
                                    Pages
                                    <span><i class="fa fa-angle-down float-right"></i></span>
                                </a>
                                <ul class="list-reset -mx-2 bg-white-medium-dark">
                                    <li class="border-t mt-2 border-light-border w-full h-full px-2 py-3">
                                        <a href="login.html"
                                           class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                            Login Page
                                            <span><i class="fa fa-angle-right float-right"></i></span>
                                        </a>
                                    </li>
                                    <li class="border-t border-light-border w-full h-full px-2 py-3">
                                        <a href="register.html"
                                           class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                            Register Page
                                            <span><i class="fa fa-angle-right float-right"></i></span>
                                        </a>
                                    </li>
                                    <li class="border-t border-light-border w-full h-full px-2 py-3">
                                        <a href="404.html"
                                           class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                            404 Page
                                            <span><i class="fa fa-angle-right float-right"></i></span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>

                    </aside>
                    <!--/Sidebar-->

                    <!-- Underline form -->
                    <div class="mb-2 md:mx-2 lg:mx-2 border-solid border-gray-200 rounded border shadow-sm w-full md:w-1/2 lg:w-1/3">
                        <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b font-bold">
                            Khu
                        </div>
                        <div class="p-3">
                            <form action="editKhachThue" method="post">
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">KhuID</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Name</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">AccountID</th>
                                            <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Số Phòng</th>
                                                <c:if test="${sessionScope.acc.accountID == 1}">
                                                <th class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">Tùy Chọn</th>
                                                </c:if>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listK}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 1}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khuID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.name}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.accountID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">50</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">
                                                        <a href='add?type=0&id=${st.id}' class="text-indigo-600 hover:text-indigo-900">Update</a>
                                                        <a href='deletekhu?kid=${o.khuID}' class="text-red-600 hover:text-red-900 ml-2">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${listK1}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 2}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khuID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.name}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.accountID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">50</td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${listK2}" var="o">
                                            <c:if test="${sessionScope.acc.accountID == 3}">
                                                <tr class="bg-white border-b">
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.khuID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.name}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">${o.accountID}</td>
                                                    <td class="px-5 py-5 border-b border-gray-200 text-sm">50</td>
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
                                        <input type="text" name="khuID" value="${listNguoiThue1.khachID}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-gray-400">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Tên Khu</label>
                                        <input type="text" name="name" value="${listNguoiThue1.hoVaTen}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-gray-400">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">AccountID</label>
                                        <input type="text" name="accountID" value="${listNguoiThue1.CCCD}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-gray-400">
                                    </div>
                                </div>
                                <div class="mt-4">
                                    <input type="submit" value="Add" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700">
                                </div>
                            </form>
                        </div>
                    </div>

                    <script>
                        function showAddKhuForm() {
                            var addKhuForm = document.getElementById("addKhuForm");
                            if (addKhuForm.style.display === "none" || addKhuForm.style.display === "") {
                                addKhuForm.style.display = "block";
                            } else {
                                addKhuForm.style.display = "none";
                            }
                        }
                    </script>


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