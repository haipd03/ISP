<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <!--Main-->
                    <h1><p style="color: green;">${Message}</p></h1>
                    <main class="bg-white-500 flex-1 p-6 overflow-hidden rounded-lg">
                        <div class="flex flex-col">
                            <!-- Card Section Starts Here -->
                            <div class="flex flex-1 flex-col md:flex-row lg:flex-row mx-2">
                                <!--Email Request Form-->
                                <div class="mb-4 border-solid border-gray-300 border shadow-lg w-full md:w-3/4 lg:w-1/2 mx-auto rounded-lg">
                                    <div class="bg-gray-700 px-4 py-3 border-solid border-gray-300 border-b text-white rounded-t-lg">
                                        Yêu Cầu Đã Gửi
                                    </div>
                                    <div class="p-4 bg-white rounded-b-lg">
                                        <p style="color: #1f9d55;">${Message1}</p>
                                        <div class="mb-6">
                                            <label class="block text-gray-700 font-regular mb-1">
                                                Người Nhận
                                            </label>
                                            <c:set var="receiverName" value="" />
                                            <c:forEach items="${listK3}" var="a">
                                                <c:if test="${a.accountID eq accountNhan}">
                                                    <c:set var="receiverName" value="${a.hoVaTen}" />
                                                </c:if>
                                            </c:forEach>

                                            <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                   name="accountNhan" type="text" value="${receiverName}" readonly>
                                        </div>
                                        <div class="mb-6">
                                            <label class="block text-gray-700 font-regular mb-1">
                                                Tiêu Đề
                                            </label>
                                            <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                   name="title" type="text" value="${title}"readonly>
                                        </div>
                                        <div class="mb-6">
                                            <label class="block text-gray-700 font-regular mb-1" for="requestText">
                                                Nội Dung Yêu Cầu
                                            </label>
                                            <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                      name="requestText" rows="10"readonly >${requestText}</textarea>
                                        </div>
                                        <div class="mb-6">
                                            <c:if test="${phanHoi != 'null'}">
                                                <label class="block text-gray-700 font-regular mb-1" for="phanHoi" >
                                                    Phản Hồi
                                                </label>
                                                <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                          name="phanHoi" rows="10"readonly >${phanHoi}</textarea>
                                            </c:if>  

                                        </div>
                                        <div class="mb-6">
                                            <label class="block text-gray-700 font-regular mb-1" for="tinhTrang">
                                                Tình Trạng
                                            </label>
                                            <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                   name="tinhTrang" type="text" value=" ${tinhTrang == 1 ? 'Đã làm' : 'Chưa làm'}"readonly>
                                        </div>
                                        <div class="flex justify-between">
                                            <button class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                    type="button" onclick="window.history.back()">
                                                Quay về
                                            </button>
                                            <button class="shadow bg-gray-700 hover:bg-gray-600 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                    type="button" onclick="window.location.href = 'ListRequest?action=gui'">
                                                Danh sách
                                            </button>
                                        </div>

                                    </div>
                                </div>
                                <!--/Email Request Form-->
                            </div>
                            <!-- /Card Section Ends Here -->
                        </div>
                    </main>
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
