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
                            <!-- Stats Row Starts Here -->
                            <div class="flex flex-1 flex-col md:flex-row lg:flex-row mx-2">
                                <div class="shadow-lg bg-red-vibrant border-l-8 hover:bg-red-vibrant-dark border-red-vibrant-dark mb-2 p-2 md:w-1/4 mx-2">
                                    <div class="p-4 flex flex-col">
                                        <a href="#" class="no-underline text-white text-2xl">
                                            $244
                                        </a>
                                        <a href="#" class="no-underline text-white text-lg">
                                            Total Sales
                                        </a>
                                    </div>
                                </div>

                                <div class="shadow bg-info border-l-8 hover:bg-info-dark border-info-dark mb-2 p-2 md:w-1/4 mx-2">
                                    <div class="p-4 flex flex-col">
                                        <a href="#" class="no-underline text-white text-2xl">
                                            $199.4
                                        </a>
                                        <a href="#" class="no-underline text-white text-lg">
                                            Total Cost
                                        </a>
                                    </div>
                                </div>

                                <div class="shadow bg-warning border-l-8 hover:bg-warning-dark border-warning-dark mb-2 p-2 md:w-1/4 mx-2">
                                    <div class="p-4 flex flex-col">
                                        <a href="#" class="no-underline text-white text-2xl">
                                            900
                                        </a>
                                        <a href="#" class="no-underline text-white text-lg">
                                            Total Users
                                        </a>
                                    </div>
                                </div>

                                <div class="shadow bg-success border-l-8 hover:bg-success-dark border-success-dark mb-2 p-2 md:w-1/4 mx-2">
                                    <div class="p-4 flex flex-col">
                                        <a href="#" class="no-underline text-white text-2xl">
                                            500
                                        </a>
                                        <a href="#" class="no-underline text-white text-lg">
                                            Total Products
                                        </a>
                                    </div>
                                </div>
                            </div>


                            <h1>List </h1>
                            <div class="flex flex-1 flex-wrap mx-2 p-1 mt-2 mx-auto lg:mx-2 md:mx-2" style="gap: 10px">
                                <c:forEach items="${lp}" var="o">
                                    <c:if test="${sessionScope.acc.role == 0}">
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
                                                    <a class="text-center mr-3 border-r pr-3" href="listNguoiThue?lntid=${o.phongID}">
                                                        Người Thuê
                                                    </a>
                                                </c:if>
                                                <div class="text-center">
                                                    <span>Xóa</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach> 

                                
                                    <c:forEach items="${lp1}" var="p">
                                    <c:if test="${sessionScope.acc.role == 1}">
                                        
                                            
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
                                                <c:if test="${o.phongConTrong == 0}">
                                                    <a class="text-center mr-3 border-r pr-3" href="listNguoiThue?lntid=${o.phongID}">
                                                        Người Thuê
                                                    </a>
                                                </c:if>
                                                <div class="text-center">
                                                    <span>Xóa</span>
                                                </div>
                                            </div>
                                        </div>
                                                
                                    </c:if>
                                </c:forEach>
                 

                                <!--/Profile Tabs-->
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