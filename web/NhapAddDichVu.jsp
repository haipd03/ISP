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
                <jsp:include page="menu1.jsp" />
                <!--/Header-->

                <div class="flex flex-1">
                    <!--Sidebar-->
                    <jsp:include page="menu2.jsp" />
                    <!--/Sidebar-->

                    <!-- Underline form -->
                    <div class="mb-4 mx-auto border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-1/3">
                        <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg w-full ">
                            Thêm Dịch Vụ (Hóa đơn)
                        </div>
                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                        <div class="p-6 bg-white">
                            <form action="adddichvuandnhapaddhdondetail" method="get">
                                <div class="space-y-4">
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Mã Dịch Vụ:</label>
                                        <input type="text" name="DichVuID" value="${nextDichVuID}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Số Phòng ID:</label>
                                        <input type="text" name="PhongID" value="${lp1[0].phongID}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Tên Dịch Vụ:</label>
                                        <input type="text" name="Name" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Giá Tiền:</label>
                                        <input type="text" name="GiaTien" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Từ Ngày:</label>
                                        <input type="date" name="TuNgay" value="${lp2.tuNgay}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Đến Ngày:</label>
                                        <input type="date" name="DenNgay" value="${lp2.denNgay}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Chỉ Số Cũ:</label>
                                        <input type="text" name="ChiSoCu" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Chỉ Số Mới:</label>
                                        <input type="text" name="ChiSoMoi" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-2/5 text-gray-700 font-semibold">Ảnh:</label>
                                        <input type="text" name="UrlAnh"  class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <input type="hidden" name="id" value="${lp3}">
                                </div>
                                <div class="mt-6 flex justify-end">
                                    <input type="submit" value="Tiếp Tục" class="bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600 transition-colors duration-200">
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--/Underline form-->
                    <!--/Main-->                                
                </div>
                <!--Footer-->
                 <footer class="bg-grey-darkest text-white p-2">
<!--                    <div class="flex flex-1 mx-auto">&copy; My Design</div>-->
                </footer>
                <!--/footer-->
            </div>
        </div>
        <script src="./main.js"></script>
    </body>
</html>