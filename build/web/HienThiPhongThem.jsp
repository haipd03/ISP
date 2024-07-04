<%-- 
Document   : HienThiThongTinPhong
Created on : May 19, 2024, 9:15:39 PM
Author     : Admin
--%>

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
        <title>HienThiPhong</title>
        <script>
            function confirmDelete() {
                return confirm("Bạn có chắc chắn muốn xóa phòng này?");
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
                    <!--Main-->
                    <main class="bg-gray-100 flex-1 p-6 overflow-hidden ">
                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                        <div class="flex flex-col space-y-4" >
                            <c:forEach items="${danhSachPhong}" var="phong">
                                <!-- Card Section Starts Here -->
                                <div class="flex flex-col md:flex-row lg:flex-row mx-2">
                                    <!-- Card -->
                                    <div class="mb-4 bg-white border border-gray-200 rounded-lg shadow-lg w-full md:w-1/2 lg:w-1/3">

                                        <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                                            Thông Tin Phòng
                                        </div>
                                        <div class="p-4">
                                            <p class="text-gray-700"><strong>Phòng ID:</strong> ${phong.phongID}</p>
                                            <p class="text-gray-700"><strong>Số Phòng:</strong> ${phong.soPhong}</p>
                                            <p class="text-gray-700"><strong>Khu ID:</strong> ${phong.khuID}</p>
                                            <p class="text-gray-700"><strong>Loại phòng:</strong> ${phong.loaiPhong}</p>
                                            <p class="text-gray-700"><strong>Phòng:</strong>  
                                                <c:if test="${phong.phongConTrong eq 1}">
                                                    <span>Trống</span><br>
                                                </c:if>
                                                <c:if test="${phong.phongConTrong eq 0}">
                                                    <span>Có khách thuê</span><br>
                                                </c:if>
                                            </p>
                                            <p class="text-gray-700"><strong>Ghi Chú:</strong> ${phong.ghiChu}</p>
                                            <p class="text-gray-700"><strong>Giá:</strong> ${phong.gia}</p>
                                            <div class="mt-4 flex space-x-2">
                                                <c:if test="${sessionScope.acc.role == 0}">
                                                    <c:if test="${phong.phongConTrong eq 1}">
                                                        <form action="deletePhong" method="get" style="display: inline;" onsubmit="return confirmDelete();">
                                                            <input type="hidden" name="phongID" value="${phong.phongID}">
                                                            <button type="submit" class="bg-red-500 hover:bg-red-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Xóa</button>
                                                        </form>
                                                    </c:if>
                                                </c:if>
                                                <form id="editForm" action="nhapeditphong" method="post">
                                                    <input type="hidden" name="phongID" value="${phong.phongID}">
                                                    <button type="submit" class="bg-purple-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200">Sửa</button>
                                                </form>                                            <a class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200" href="/quanlytro/listphong">Trang chủ</a>
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


