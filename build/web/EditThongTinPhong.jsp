
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
        <script>
            function confirmUpdate() {
                return confirm("Bạn có chắc chắn muốn update phòng này?");
            }
        </script>
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

                        <c:if test="${not empty errorMessage}">
                            <div class="bg-red-500 text-white p-3 rounded-lg mb-4">
                                ${errorMessage}
                            </div>
                        </c:if>
                        <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg w-full ">

                            Sửa Thông Tin Phòng
                        </div>
                        <div class="p-6 bg-white">
                            <form action="editPhong" method="post" onsubmit="return confirmUpdate()">
                                <div class="space-y-4">
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Mã Phòng:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="phongID" value="${p.phongID}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Số Phòng:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="soPhong" value="${p.soPhong}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Mã Khu:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="khuID" value="${p.khuID}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Loại Phòng:</label>
                                        <select name="loaiPhong" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                            <c:forEach items="${lp1}" var="o1">
                                                <option value="${o1.loaiPhong}" <c:if test="${p.loaiPhong eq o1.loaiPhong}">selected</c:if>>${o1.loaiPhong}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Phòng:</label>
                                        <select name="phongConTrong" id="phongConTrong" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600"
                                                <c:if test="${not canChangeStatus}">disabled</c:if>>
                                            <option value="1" <c:if test="${p.phongConTrong eq 1}">selected</c:if>>Trống</option>
                                            <option value="0" <c:if test="${p.phongConTrong eq 0}">selected</c:if>>Có khách thuê</option>
                                            </select>
                                        </div>


                                    <c:choose>
                                        <c:when test="${p.phongConTrong eq 1}">
                                            <div class="flex items-center">
                                                <label class="w-1/3 text-gray-700 font-semibold">Ghi Chú:</label>
                                                <select name="ghiChu" id="ghiChu" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                                    <option value="Bảo trì" <c:if test="${p.ghiChu eq 'Bảo trì'}">selected</c:if>>Bảo trì</option>
                                                    <option value="Tốt" <c:if test="${p.ghiChu eq 'Tốt'}">selected</c:if>>Tốt</option>
                                                    <option value="Vô hiệu hóa" <c:if test="${p.ghiChu eq 'Vô hiệu hóa'}">selected</c:if>>Vô hiệu hóa</option>
                                                    </select>
                                                </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="flex items-center">
                                                <label class="w-1/3 text-gray-700 font-semibold">Ghi Chú:</label>
                                                <input type="text" style="background-color: gray;opacity: 0.7 " name="ghiChu" value="Tốt" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:if test="${sessionScope.acc.role == 0}">
                                        <div class="flex items-center">
                                            <label class="w-1/3 text-gray-700 font-semibold">Giá:</label>
                                            <input type="text" name="gia" value="${p.gia}" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                        </div>
                                    </c:if>

                                    <c:if test="${sessionScope.acc.role == 1}">
                                        <div class="flex items-center">
                                            <label class="w-1/3 text-gray-700 font-semibold">Giá:</label>
                                            <input type="text" style="background-color: gray;opacity: 0.7 " name="gia" value="${p.gia}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                        </div>
                                    </c:if>

                                    <p style="color: red">${message}</p>
                                </div>
                                <div class="mt-6 flex justify-end">
                                    <input type="submit" value="Sửa" class="bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600 transition-colors duration-200">
                                </div>

                            </form>
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


