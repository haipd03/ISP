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
            function confirmUpdate() {
                return confirm("Bạn có chắc chắn muốn thay đổi thông tin hợp đồng này không?");
            }

            document.addEventListener('DOMContentLoaded', function () {
                var tinhTrangSelect = document.getElementById('TinhTrang');
                var tinhTrangHidden = document.getElementById('TinhTrangHidden');
                // Set the hidden input value when the page loads
                tinhTrangHidden.value = tinhTrangSelect.value;
                // Update the hidden input value when the dropdown changes
                tinhTrangSelect.addEventListener('change', function () {
                    tinhTrangHidden.value = this.value;
                });
            });

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

                    <!-- Underline form -->
                    <div class="mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-1/3">
                        <c:if test="${not empty errorMessage}">
                            <div class="bg-red-500 text-white p-3 rounded-lg mb-4">
                                ${errorMessage}
                            </div>
                        </c:if>
                        <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                            Sửa Hợp Đồng
                        </div>
                        <div class="p-6 bg-white">
                            <form id="editHopDongForm" action="edithopdong" method="post">
                                <div class="space-y-4">
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Hợp Đồng ID:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="HopDongID" value="${listhd.hopDongID}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly >
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Khách ID:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="KhachID" value="${listhd.khachID}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Mã Phòng:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="PhongID" value="${listhd.phongID}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Tiền Cọc:</label>
                                        <input type="text" name="TienCoc" value="${listhd.tienCoc}" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Ngày Thuê:</label>
                                        <input type="date" name="NgayThue" value="${listhd.ngayThue}" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Ngày Trả:</label>
                                        <input type="date" name="NgayTra" value="${listhd.ngayTra}" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Số Khách Thuê Phòng:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 "  name="SoKhachThue" value="${listhd.soKhachThue}" readonly class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Ghi Chú:</label>
                                        <input type="text" name="GhiChu" value="${listhd.ghiChu}" required class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">CCCD:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="CCCD" value="${listhd.CCCD}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Số Điện Thoại:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="SDT" value="${listhd.SDT}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Họ Và Tên Đại Diện Phòng:</label>
                                        <input type="text" style="background-color: gray;opacity: 0.7 " name="HoVaTen" value="${listhd.hoVaTen}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600" readonly>
                                    </div>
                                    <div class="flex items-center">
                                        <label class="w-1/3 text-gray-700 font-semibold">Tình Trạng:</label>
                                        <select name="TinhTrang" id="TinhTrang" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600"
                                                <c:if test="${not empty errorMessage}">disabled</c:if>>
                                            <option value="1" ${listhd.tinhTrang == 1 ? 'selected' : ''}>Đang Thuê</option>
                                            <option value="0" ${listhd.tinhTrang == 0 ? 'selected' : ''}>Không còn Thuê</option>
                                        </select>
                                        <input type="hidden" name="TinhTrangHidden" id="TinhTrangHidden" value="${listhd.tinhTrang}">
                                    </div>
                                </div>
                                <div class="mt-6 flex justify-end">
                                    <input type="submit" value="Sửa" onclick="return confirmUpdate()" class="bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600 transition-colors duration-200">
                                    <a href="listhopdong" class="bg-red-500 hover:bg-red-800 text-white font-bold py-2 px-4 rounded">
                                        Quay về
                                    </a>
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