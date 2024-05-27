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
                <jsp:include page="menu1.jsp" />
                <!--/Header-->

                <div class="flex flex-1">
                    <!--Sidebar-->
                    <jsp:include page="menu2.jsp" />
                    <!--/Sidebar-->
                    <!--Main-->
                    <main class="bg-white-300 flex-1 p-3 overflow-hidden">

                        <div class="flex flex-col">
                            <c:if test="${sessionScope.acc.role == 0}">


                                <form class="searchform cf flex justify-center items-center mt-8 mb-8" action="search" method="post">
                                    <input id="roomNumberInput" name="txt" type="text" placeholder="Nhập số phòng" class="w-full md:w-3/4 lg:w-1/2 p-2 border border-gray-600 rounded-l-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-r-lg focus:outline-none focus:ring-2 focus:ring-blue-500" type="submit">
                                        Search
                                    </button>
                                </form>


                                <!-- Stats Row Starts Here -->

                                <div class="flex flex-3 flex-col md:flex-row lg:flex-row mx-2">
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

                            </c:if>

                            <table border="0">
                                <tbody>
                                    <tr>

                                        <td><h1>List </h1></td>
                                        <td><div class="flex justify-end">
                                                <form action="nhapaddphong" method="post">
                                                    <button type="submit"  class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded"">ADD</button>
                                                </form>
                                            </div>
                                        </td>
                                    </tr>                                
                                </tbody>
                            </table>

                            <div class="flex flex-1 flex-wrap mx-2 p-1 mt-2 mx-auto lg:mx-2 md:mx-2" style="gap: 10px">
                                <c:forEach items="${lp}" var="o">
                                    <c:if test="${sessionScope.acc.role == 0}">
                                        <div class="rounded rounded-t-lg overflow-hidden shadow my-3" style="width: calc((100% / 3) - 10px)">
                                            <div class="text-center px-3 pb-6 pt-2">
                                                <h3 class="text-black text-sm bold font-sans">
                                                    <form action="loadphong" method="get">
                                                        <input type="hidden" name="soPhong" value="${o.soPhong}" />
                                                        <button type="submit" formtarget="_blank">
                                                            Loại Phòng: ${o.loaiPhong} - Số Phòng: ${o.soPhong}
                                                        </button>
                                                    </form></a></h3>
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
                                                    <a href="listthietbi?id=${o.phongID}" class="button-link">Thiết bị</a>
                                                </div>
                                                <c:if test="${o.phongConTrong == 0}">
                                                    <a  href="listNguoiThue?lntid=${o.phongID}">
                                                        Người Thuê
                                                    </a>
                                                </c:if>
                                            </div>
                                            <c:if test="${o.phongConTrong == 1}">
                                                <table border="0">
                                                    <tbody>
                                                        <tr>
                                                            <td><div class="flex justify-end">
                                                                    <form action="addhopdong" method="post">
                                                                        <button type="submit"  class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded"">Thêm Hợp Đồng</button>
                                                                    </form>
                                                                </div>
                                                            </td>
                                                        </tr>                                
                                                    </tbody>
                                                </table>
                                            </c:if>
                                        </div>
                                    </c:if>
                                </c:forEach> 


                                <c:forEach items="${lp1}" var="p">
                                    <c:if test="${sessionScope.acc.role == 1}">


                                        <div class="rounded rounded-t-lg overflow-hidden shadow my-3" style="width: calc((100% / 3) - 10px)">
                                            <div class="text-center px-3 pb-6 pt-2">
                                                <h3 class="text-black text-sm bold font-sans"><form action="loadphong" method="get">
                                                        <input type="hidden" name="soPhong" value="${p.soPhong}" />
                                                        <button type="submit" formtarget="_blank">
                                                            Loại Phòng: ${p.loaiPhong} - Số Phòng: ${p.soPhong}
                                                        </button>
                                                    </form></h3>
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

                                                    <a href="listthietbi?id=${p.phongID}" class="button-link">Thiết bị</a>
                                                </div>
                                                <c:if test="${p.phongConTrong == 0}">
                                                    <a  href="listNguoiThue?lntid=${p.phongID}">
                                                        Người Thuê
                                                    </a>
                                                </c:if>

                                            </div>
                                        </div>

                                    </c:if>
                                </c:forEach>


                                <!--/Profile Tabs-->
                            </div>
                        </div>
                    </main>
                    <!--/Main-->
                </div>
                <!--Footer-->
                <footer class="bg-grey-darkest text-white p-2">
                    <div class="flex flex-1 mx-auto">&copy; My Design</div>
                    <div class="flex flex-1 mx-auto">Distributed by:  <a href="https://themewagon.com/" target=" _blank">Themewagon</a></div>
                </footer>
                <!--/footer-->

            </div>

        </div>
        <script src="./main.js"></script>
    </body>

</html>