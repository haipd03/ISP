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
                    <!--Main-->
                    <main class="bg-gray-100 flex-1 p-6 overflow-hidden">
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>
                                        <div class="flex justify-end">
                                            <form action="nhapaddhopdong" method="post">
                                                <button type="submit"  class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded">Thêm Khách Thuê</button>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="flex justify-end">
                                            <form action="nhapaddhopdong" method="post">
                                                <button type="submit"  class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded">Thêm Hợp Đồng</button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>    
                            </tbody>
                        </table>
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
                                            <p class="text-gray-700"><strong>Tình Trạng:</strong>
                                                <c:choose>
                                                    <c:when test="${o.tinhTrang == 1}">
                                                        Đang Thuê
                                                    </c:when>
                                                    <c:otherwise>
                                                        Không còn Thuê
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
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