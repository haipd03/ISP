<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="keywords" content="tailwind,tailwindcss,tailwind css,css,starter template,free template,admin templates, admin template, admin dashboard, free tailwind templates, tailwind example">
        <!-- Css -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Dashboard | Tailwind Admin</title>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                document.getElementById('khuDropdownButton').addEventListener('click', function () {
                    document.getElementById('khuDropdownMenu').classList.toggle('hidden');
                });
                document.getElementById('loaiPhongDropdownButton').addEventListener('click', function () {
                    document.getElementById('loaiPhongDropdownMenu').classList.toggle('hidden');
                });
                document.getElementById('giaDropdownButton').addEventListener('click', function () {
                    document.getElementById('giaDropdownMenu').classList.toggle('hidden');
                });
                document.getElementById('tinhTrangDropdownButton').addEventListener('click', function () {
                    document.getElementById('tinhTrangDropdownMenu').classList.toggle('hidden');
                });
            });
        </script>
    </head>

    <body>
        <!--Container -->
        <div class="mx-auto bg-grey-400">
            <!--Screen-->
            <div class="min-h-screen flex flex-col">
                <!--Header Section Starts Here-->
                <header class="bg-nav">
                    <div class="flex justify-between">
                        <div class="p-1 mx-3 inline-flex items-center">
                            <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                            <h1 class="text-white p-2">MENU</h1>
                        </div>
                        <div class="p-1 flex flex-row items-center">


                            <a  onclick="profileToggle()" class="text-white p-2 no-underline hidden md:block lg:block">Hello ${sessionScope.acc.taiKhoan}</a>
                            <div id="ProfileDropDown" class="rounded hidden shadow-md bg-white top-0 right-0 absolute pin-t mt-12 mr-1 pin-r">
                                <ul class="list-reset">
                                    <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">My account</a></li>
                                    <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Notifications</a></li>
                                    <li><hr class="border-t mx-2 border-grey-ligght"></li>
                                    <li><a href="logout" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </header>
                <!--/Header-->

                <div class="flex flex-1">
                    <!--Sidebar-->
                    <aside id="sidebar" class="bg-side-nav w-1/2 md:w-1/6 lg:w-1/6 border-r border-side-nav hidden md:block lg:block">

                        <ul class="list-reset flex flex-col">
                            <li class=" w-full h-full py-3 px-2 border-b border-light-border bg-white">
                                <a href="index.jsp"
                                   class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                    <i class="fas fa-tachometer-alt float-left mx-2"></i>
                                    Room
                                    <span><i class="fas fa-angle-right float-right"></i></span>
                                </a>
                            </li>
                            <li class="w-full h-full py-3 px-2 border-b border-light-border">
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
                    <main class="bg-white-300 flex-1 p-3 overflow-hidden">

                        <div class="flex flex-col">

                            <form class="searchform cf flex justify-center items-center mt-4 mb-4" action="search" method="post">
                                <input id="roomNumberInput" name="txt" type="text" placeholder="Tim kiem so phong nao?" class="w-full md:w-3/4 lg:w-1/2 p-2 border border-gray-600 rounded-l-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-r-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                    Search
                                </button>
                            </form>

                            <!-- Stats Row Starts Here -->

                            <div class="flex flex-1 flex-col md:flex-row lg:flex-row mx-2">
                                <!-- KHU Button with Dropdown -->
                                <div class="shadow-lg bg-red-vibrant border-l-8 hover:bg-red-vibrant-dark border-red-vibrant-dark mb-2 p-2 md:w-1/4 mx-2 relative">
                                    <div class="p-4 flex flex-col items-center justify-center">
                                        <button class="no-underline text-white text-2xl focus:outline-none" id="khuDropdownButton">
                                            KHU
                                        </button>
                                    </div>
                                    <div id="khuDropdownMenu" class="hidden absolute bg-red-vibrant-dark text-white right-0 mt-2 py-2 w-48 border border-red-vibrant-dark">
                                        <c:forEach items="${lk}" var="c">
                                            <li>
                                                <a class="px-4 py-2 hover:bg-red-vibrant" href="categorykhu?ck=${c.khuID}">
                                                    <span class="text-dark" style="width: 130px;">${c.name}</span>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </div>
                                </div>

                                <!-- LOẠI PHÒNG Button with Dropdown -->
                                <div class="shadow bg-info border-l-8 hover:bg-info-dark border-info-dark mb-2 p-2 md:w-1/4 mx-2 relative">
                                    <div class="p-4 flex flex-col items-center justify-center">
                                        <button class="no-underline text-white text-2xl focus:outline-none" id="loaiPhongDropdownButton">
                                            LOẠI PHÒNG
                                        </button>
                                    </div>
                                    <div id="loaiPhongDropdownMenu" class="hidden absolute bg-info-dark text-white right-0 mt-2 py-2 w-48 border border-red-vibrant-dark">
                                        <c:forEach items="${bp}" var="a">
                                            <li>
                                                <a class="px-4 py-2 hover:bg-info" href="categoryloaiphong?bl=${a.loaiPhong}">
                                                    <span class="text-dark" style="width: 130px;">${a.loaiPhong}</span>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </div>
                                </div>

                                <!-- GIÁ Button with Dropdown -->
                                <div class="shadow bg-warning border-l-8 hover:bg-warning-dark border-warning-dark mb-2 p-2 md:w-1/4 mx-2 relative">
                                    <div class="p-4 flex flex-col items-center justify-center">
                                        <button class="no-underline text-white text-2xl focus:outline-none" id="giaDropdownButton">
                                            GIÁ
                                        </button>
                                    </div>                         
                                    <div id="giaDropdownMenu" class="hidden absolute bg-warning-dark text-white right-0 mt-2 py-2 w-48 border border-red-vibrant-dark">
                                        <c:forEach items="${ba}" var="c">
                                            <li>
                                                <a class="px-4 py-2 hover:bg-warning" href="categorygia?bg=${c.gia}">
                                                    <span class="text-dark" style="width: 130px;">${c.gia}</span>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </div>
                                </div>

                                <!-- TÌNH TRẠNG Button with Dropdown -->
                                <div class="shadow bg-success border-l-8 hover:bg-success-dark border-success-dark mb-2 p-2 md:w-1/4 mx-2 relative">
                                    <div class="p-4 flex flex-col items-center justify-center">
                                        <button class="no-underline text-white text-2xl focus:outline-none" id="tinhTrangDropdownButton">
                                            TÌNH TRẠNG
                                        </button>
                                    </div>
                                    <div id="tinhTrangDropdownMenu" class="hidden absolute bg-success-dark text-white right-0 mt-2 py-2 w-48 border border-red-vibrant-dark">
                                        <c:forEach items="${btt}" var="c">
                                            <li>
                                                <a class="px-4 py-2 hover:bg-success" href="categorytinhtrang?bt=${c.phongConTrong}">
                                                    <c:if test="${c.phongConTrong == 0}">
                                                        <span class="text-dark" style="width: 130px;">Có khách</span>
                                                    </c:if>
                                                    <c:if test="${c.phongConTrong == 1}">
                                                        <span class="text-dark" style="width: 130px;">Trống</span>
                                                    </c:if>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            <!-- Default List -->
                            <h1>List </h1>
                            <div class="flex flex-1 flex-wrap mx-2 p-1 mt-2 mx-auto lg:mx-2 md:mx-2" style="gap: 10px">
                                <c:forEach items="${lp}" var="o">
                                    <c:if test="${sessionScope.acc.accountID == 1}">
                                        <div class="rounded rounded-t-lg overflow-hidden shadow my-3" style="width: calc((100% / 3) - 10px)">
                                            <div class="text-center px-3 pb-6 pt-2">
                                                <h3 class="text-black text-sm bold font-sans">Loại Phòng: ${o.loaiPhong} - Số Phòng: ${o.soPhong}</h3>
                                                <p class="mt-2 font-sans font-light text-grey-700">Giá ${o.gia}</p>
                                                <p class="mt-2 font-sans font-light text-grey-700">
                                                    Tình trạng: 
                                                    <c:choose>
                                                        <c:when test="${o.phongConTrong == 0}">
                                                            Có khách
                                                        </c:when>
                                                        <c:when test="${o.phongConTrong == 1}">
                                                            Trống
                                                        </c:when>
                                                        <c:otherwise>
                                                            Unknown
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>
                                            </div>
                                            <div class="flex justify-center pb-3 text-grey-dark">
                                                <div class="text-center mr-3 border-r pr-3">
                                                    <span>Thiết bị</span>
                                                </div>
                                                <c:if test="${o.phongConTrong == 0}">
                                                    <div class="text-center mr-3 border-r pr-3">
                                                        <span>Người Thuê</span>
                                                    </div>
                                                </c:if>
                                                <div class="text-center">
                                                    <span>Xóa</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach> 

                                <c:forEach items="${lp1}" var="p">
                                    <c:if test="${sessionScope.acc.accountID == 2}">
                                        <div class="rounded rounded-t-lg overflow-hidden shadow my-3" style="width: calc((100% / 3) - 10px)">
                                            <div class="text-center px-3 pb-6 pt-2">
                                                <h3 class="text-black text-sm bold font-sans">Loại Phòng: ${p.loaiPhong} - Số Phòng: ${p.soPhong}</h3>
                                                <p class="mt-2 font-sans font-light text-grey-700">Giá ${p.gia}</p>
                                                <p class="mt-2 font-sans font-light text-grey-700">
                                                    Tình trạng: 
                                                    <c:choose>
                                                        <c:when test="${p.phongConTrong == 0}">
                                                            Có khách
                                                        </c:when>
                                                        <c:when test="${p.phongConTrong == 1}">
                                                            Trống
                                                        </c:when>
                                                        <c:otherwise>
                                                            Unknown
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>
                                            </div>
                                            <div class="flex justify-center pb-3 text-grey-dark">
                                                <div class="text-center mr-3 border-r pr-3">
                                                    <span>Thiết bị</span>
                                                </div>
                                                <c:if test="${p.phongConTrong == 0}">
                                                    <div class="text-center mr-3 border-r pr-3">
                                                        <span>Người Thuê</span>
                                                    </div>
                                                </c:if>
                                                <div class="text-center">
                                                    <span>Xóa</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>

                                <c:forEach items="${lp2}" var="o">
                                    <c:if test="${sessionScope.acc.accountID == 3}">

                                        <div class="rounded rounded-t-lg overflow-hidden shadow my-3" style="width: calc((100% / 3) - 10px)">
                                            <div class="text-center px-3 pb-6 pt-2">
                                                <h3 class="text-black text-sm bold font-sans">Loại Phòng: ${o.loaiPhong} - Số Phòng: ${o.soPhong}</h3>
                                                <p class="mt-2 font-sans font-light text-grey-700">Giá ${o.gia}</p>
                                                <p class="mt-2 font-sans font-light text-grey-700">
                                                    Tình trạng: 
                                                    <c:choose>
                                                        <c:when test="${o.phongConTrong == 0}">
                                                            Có khách
                                                        </c:when>
                                                        <c:when test="${o.phongConTrong == 1}">
                                                            Trống
                                                        </c:when>
                                                        <c:otherwise>
                                                            Unknown
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>
                                            </div>
                                            <div class="flex justify-center pb-3 text-grey-dark">
                                                <div class="text-center mr-3 border-r pr-3">
                                                    <span>Thiết bị</span>
                                                </div>
                                                <c:if test="${o.phongConTrong == 0}">
                                                    <div class="text-center mr-3 border-r pr-3">
                                                        <span>Người Thuê</span>
                                                    </div>
                                                </c:if>
                                                <div class="text-center">
                                                    <span>Xóa</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>

                        </body>
                        </html>