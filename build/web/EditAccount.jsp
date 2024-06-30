<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Accounts" %>
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
                <div class="mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-4/5">
                    <div class="bg-gray-600 text-white px-4 py-3 rounded-t-lg">
                        Sửa Tài Khoản
                    </div>
                    <div class="p-6 bg-white">
                        
                        <c:if test="${not empty errorMessage}">
                            <div class="bg-red-500 text-white p-2 mb-4 rounded">
                                ${errorMessage}
                            </div>
                        </c:if>
                        <form action="editaccount" method="post">
                            <div class="space-y-4">
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Mã tài khoản</label>
                                    <input type="text" name="AccountID" readonly value="${listA.accountID}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Tài khoản</label>
                                    <input type="text" name="TaiKhoan" value="${listA.taiKhoan}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Mật khẩu</label>
                                    <input type="text" name="Password" value="${listA.password}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Role</label>
                                    <input type="text" name="Role" value="${listA.role}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Họ và tên</label>
                                    <input type="text" name="HoVaTen" value="${listA.hoVaTen}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Email</label>
                                    <input type="text" name="Email" value="${listA.email}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">CCCD</label>
                                    <input type="text" name="CCCD" value="${listA.CCCD}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                                <div class="flex items-center">
                                    <label class="w-1/3 text-gray-700 font-semibold">Địa chỉ</label>
                                    <input type="text" name="DiaChi" value="${listA.diaChi}" class="w-2/3 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600">
                                </div>
                            </div>
                            <div class="mt-6 flex justify-end">
                                <input type="submit" value="Sửa" class="bg-purple-500 hover:bg-purple-400 text-white font-bold py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-600 transition-colors duration-200">
                                <a href="listaccount" class="bg-red-500 hover:bg-red-800 text-white font-bold py-2 px-4 rounded">
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
                <div class="flex flex-1 mx-auto">&copy; My Design</div>
            </footer>
            <!--/footer-->
        </div>
    </div>
    <script src="./main.js"></script>
</body>

</html>
