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
                    <!--Main-->
                    <main class="bg-gray-100 flex-1 p-6 overflow-hidden">
                        <div class="flex flex-col space-y-4">
                            <c:forEach items="${listNguoiThue}" var="o">
                                <!-- Card Section Starts Here -->
                                <div class="flex flex-col md:flex-row lg:flex-row mx-2">
                                    <!-- Card -->
                                    <div class="mb-4 bg-white border border-gray-200 rounded-lg shadow-lg w-full md:w-1/2 lg:w-1/2">
                                        <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                                            Danh Sách Khách Hàng
                                        </div>
                                        <div class="p-4">
                                            <p class="text-gray-700"><strong>ID Khách:</strong> ${o.khachID}</p>
                                            <p class="text-gray-700"><strong>Tên Khách:</strong> ${o.hoVaTen}</p>
                                            <p class="text-gray-700"><strong>CCCD:</strong> ${o.CCCD}</p>
                                            <p class="text-gray-700"><strong>SDT:</strong> ${o.SDT}</p>
                                            <p class="text-gray-700"><strong>Quê Quán:</strong> ${o.queQuan}</p>
                                            <p class="text-gray-700"><strong>Tên Người Thân:</strong> ${o.tenNguoiThan}</p>
                                            <p class="text-gray-700"><strong>SDT Người Thân:</strong> ${o.SDTNguoiThan}</p>
                                            <p class="text-gray-700"><strong>Quan Hệ Với Người Thân:</strong> ${o.quanHeVoiNguoiThan}</p>
                                            <p class="text-gray-700"><strong>ID Phòng:</strong> ${o.phongID}</p>
                                            <div class="mt-4">
                                                <a class="inline-block bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200"
                                                   href="listEdit?lntt=${o.khachID}">Update
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /Card -->
                                </div>
                                <!-- /Card Section Ends Here -->
                            </c:forEach>
                        </div>
                    </main>


                    <!-- Underline form -->

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