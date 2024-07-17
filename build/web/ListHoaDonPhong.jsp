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
                        <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                        <div class="flex flex-row space-x-4">
                            <!-- Card Section Starts Here -->
                            <div class="flex flex-col md:flex-row lg:flex-row mx-2 w-full md:w-1/2 lg:w-1/2">
                                <!-- Card -->
                                <div class="mb-4 bg-white border border-gray-200 rounded-lg shadow-lg w-full">
                                    <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                                        Thông Tin của hóa đơn từng phòng
                                    </div>
                                    <div class="p-4">
                                        <p class="text-gray-700"><strong>Mã Hóa Đơn:</strong> ${listhdon.hoaDonID}</p>
                                        <p class="text-gray-700"><strong>Mã Hợp Đồng:</strong> ${listhdon.hopDongID}</p>
                                        <p class="text-gray-700"><strong>Ngày Thanh Toán:</strong> ${listhdon.ngayThanhToan}</p>
                                        <p class="text-gray-700"><strong>Tình Trạng Thanh Toán:</strong> ${listhdon.tinhTrangThanhToan}</p>
                                        <p class="text-gray-700"><strong>Từ Ngày:</strong> ${listhdon.tuNgay}</p>
                                        <p class="text-gray-700"><strong>Đến Ngày:</strong> ${listhdon.denNgay}</p>
                                        <p class="text-gray-700"><strong>Tổng Tiền:</strong> ${listhdon.tongTien}</p>
                                        <c:if test="${sessionScope.acc.role == 1}">
                                            <div class="mt-4">
                                                <a class="inline-block bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded transition-colors duration-200"
                                                   href="nhapaddhoadonphong?id=${phongid}">Thêm Hóa Đơn Mới
                                                </a>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                            <div class="flex flex-col md:flex-row lg:flex-row mx-2 w-full md:w-1/2 lg:w-1/2">
                                <!-- Card -->
                                <div class="mb-4 bg-white border border-gray-200 rounded-lg shadow-lg w-full">
                                    <div class="bg-purple-600 text-white px-4 py-3 rounded-t-lg">
                                        Các dịch vụ của hóa đơn
                                    </div>
                                    <div class="p-4">
                                        <table class="table-auto w-full border-collapse">
                                            <thead>
                                                <tr class="bg-gray-200 text-gray-800">
                                                    <th class="px-4 py-2 text-center">Mã dịch vụ</th>
                                                    <th class="px-4 py-2 text-center">Tên</th>
                                                    <th class="px-4 py-2 text-center">Giá tiền</th>
                                                    <th class="px-4 py-2 text-center">Chỉ số cũ</th>
                                                    <th class="px-4 py-2 text-center">Chỉ số mới</th>
                                                    <th class="px-4 py-2 text-center">Thành Tiền</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listdv}" var="o">
                                                    <tr class="transition-colors hover:bg-gray-100">
                                                        <td class="px-4 py-2 text-center">${o.dichVuID}</td>
                                                        <td class="px-4 py-2 text-center">${o.name}</td>
                                                        <td class="px-4 py-2 text-center">${o.giaTien}</td>
                                                        <td class="px-4 py-2 text-center">${o.chiSoCu}</td>
                                                        <td class="px-4 py-2 text-center">${o.chiSoMoi}</td>
                                                        <td class="px-4 py-2 text-center">
                                                            <c:forEach items="${hdd}" var="p">
                                                                <c:if test="${p.dichVuID == o.dichVuID}">
                                                                    ${p.thanhTien}
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
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