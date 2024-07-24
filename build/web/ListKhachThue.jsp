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
                if (confirm("Bạn có chắc muốn xóa Khách Thuê này không?")) {
                    window.location.href = url;
                } else {
                    event.preventDefault();
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
                    <!--Main-->
                    <main class="bg-gray-100 flex-1 p-6 overflow-hidden">
                        <c:if test="${sessionScope.acc.role == 1}">
                            <table border="0">
                                <tbody>
                                    <tr>
                                        <c:if test="${(empty listHopDong1 && sokhach1 == 0) || (sokhach < listHopDong1.soKhachThue && sokhach > 0) }">
                                            <td>
                                                <div class="flex justify-end">
                                                    <form action="nhapaddkhachthue?naktpid=${phongID}" method="post">
                                                        <button type="submit" class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded">Thêm Khách Thuê</button>
                                                    </form>
                                                </div>
                                            </td>
                                        </c:if>

                                        <c:set var="phongDaCoHopDong" value="false" />

                                        <c:forEach var="hopDong" items="${listHopDong}">
                                            <c:if test="${hopDong.tinhTrang == 1 && hopDong.phongID == phongID}">
                                                <c:set var="phongDaCoHopDong" value="true" />
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${!phongDaCoHopDong}">
                                            <td>
                                                <div class="flex justify-end">
                                                    <form action="nhapaddhopdong?nahdpid=${phongID}" method="post">
                                                        <button type="submit" class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded">Thêm Hợp Đồng</button>
                                                    </form>
                                                </div>
                                            </td>
                                        </c:if>

                                        <c:if test="${!(empty listHopDong1 || (sokhach > 0)) && phongDaCoHopDong}">
                                            <td>
                                                <div class="flex justify-end">
                                                    <form action="loadhopdong?lhdid=${listHopDong1.hopDongID}&lpid=${phongID}" method="post">
                                                        <button class="bg-red-500 hover:bg-red-800 text-white font-bold py-2 px-4 rounded">Kết thúc Hợp Đồng</button>
                                                    </form>
                                                </div>
                                            </td>
                                        </c:if>

                                    </tr>    
                                </tbody>
                            </table>
                        </c:if>

                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                        <div class="flex flex-col space-y-4">
                            <c:forEach items="${listNguoiThue}" var="o">
                                <c:if test="${o.tinhTrang != 0}">
                                    <!-- Card Section Starts Here -->
                                    <div class="flex flex-col md:flex-row lg:flex-row mx-2">
                                        <!-- Card -->
                                        <div class="mb-4 bg-white border border-gray-200 rounded-lg shadow-lg w-full md:w-1/2 lg:w-1/2">
                                            <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                                                Danh Sách Khách Hàng
                                            </div>
                                            <div class="p-4">
                                                <p class="text-gray-700"><strong>Mã khách:</strong> ${o.khachID}</p>
                                                <p class="text-gray-700"><strong>Tên Khách:</strong> ${o.hoVaTen}</p>
                                                <p class="text-gray-700"><strong>CCCD:</strong> ${o.CCCD}</p>
                                                <p class="text-gray-700"><strong>SDT:</strong> ${o.SDT}</p>
                                                <p class="text-gray-700"><strong>Quê Quán:</strong> ${o.queQuan}</p>
                                                <p class="text-gray-700"><strong>Tên Người Thân:</strong> ${o.tenNguoiThan}</p>
                                                <p class="text-gray-700"><strong>SDT Người Thân:</strong> ${o.SDTNguoiThan}</p>
                                                <p class="text-gray-700"><strong>Quan Hệ Với Người Thân:</strong> ${o.quanHeVoiNguoiThan}</p>
                                                <p class="text-gray-700"><strong>Mã Phòng:</strong> ${o.phongID}</p>
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
                                                <c:if test="${sessionScope.acc.role == 1}">
                                                    <div class="mt-4">
                                                        <a href='#' class="bg-red-500 hover:bg-red-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200" 
                                                           onclick="confirmDelete(event, 'deletekhachthue?ktid=${o.khachID}')">Xóa
                                                        </a>  
                                                        <a class="inline-block bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200"
                                                           href="listEdit?lntt=${o.khachID}">Sửa
                                                        </a>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </main>
                    <!-- Underline form -->

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