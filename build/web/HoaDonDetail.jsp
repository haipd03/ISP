
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.HoaDon" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Css -->
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet" href="./dist/all.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
    <title>Tables | Tailwind Admin</title>
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
                <!-- Thêm phần hiển thị hóa đon chi tiết -->
                <div class="flex-1 p-4">

                    <form class="searchform cf flex justify-center items-center mt-2 mb-2" action="" method="post">
                        <input id="roomNumberInput" name="txt" type="text" placeholder="Nhập ID" class="w-full md:w-3/4 lg:w-1/2 p-2 border border-gray-600 rounded-l-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                        <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-r-lg focus:outline-none focus:ring-2 focus:ring-blue-500" type="submit">
                            Search
                        </button>
                    </form>

                    <h4 class="text-lg font-semibold mb-2">Danh sách hóa đơn chi tiết:</h4>
                    <div class="overflow-x-auto">
                        <table class="table-auto w-full border-collapse">
                            <thead>
                                <tr class="bg-gray-200 text-gray-800">
                                    <th class="px-2 py-2 text-center">HoaDonChiTietID</th>
                                    <th class="px-2 py-2 text-center">HoaDonID</th>
                                    <th class="px-2 py-2 text-center">TuNgay</th>
                                    <th class="px-2 py-2 text-center">DenNgay</th>
                                    <th class="px-2 py-2 text-center">TongSoDien</th>
                                    <th class="px-2 py-2 text-center">TongSoNuoc</th>
                                    <th class="px-2 py-2 text-center">HeSo</th>
                                    <th class="px-2 py-2 text-center">ThanhTien</th>
                                    <th class="px-2 py-2 text-center">DichVuID</th>
                                    <th class="px-2 py-2 text-center">Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${lhdd}" var="o"> 
                                    <tr class="transition-colors hover:bg-gray-100">
                                        <td class="px-2 py-2 text-center">${o.hoaDonDetailID}</td>
                                        <td class="px-2 py-2 text-center">${o.hoaDonID}</td>
                                        <td class="px-2 py-2 text-center">${o.tuNgay}</td>
                                        <td class="px-2 py-2 text-center">${o.denNgay}</td>
                                        <td class="px-2 py-2 text-center">${o.tongSoDien}</td>
                                        <td class="px-2 py-2 text-center">${o.tongSoNuoc}</td>
                                        <td class="px-2 py-2 text-center">${o.heSo}</td>
                                        <td class="px-2 py-2 text-center">${o.thanhTien}</td>
                                        <td class="px-2 py-2 text-center">${o.dichVuID}</td>
                                        <td class="px-2 py-2 text-center">
                                            <a href="loadhoadondetail?id=${o.hoaDonDetailID}" class="text-blue-500 hover:text-blue-700 mr-2">Sửa</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="mt-4">
                        <a href="">
                            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Thêm hóa đơn chi tiết</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <script src="./main.js"></script>
</body>
</html>