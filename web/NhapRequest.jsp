<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Request" %>
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
            function confirmSend(event, url) {
                if (confirm("Bạn có chắc muốn gửi tin nhắn này không?")) {
                    window.location.href = url;
                } else {
                    event.preventDefault();
                }
            }
            function validateForm() {
                var accountNhan = document.forms["myForm"]["accountNhan"].value;
                var title = document.forms["myForm"]["title"].value;
                var requestText = document.forms["myForm"]["requestText"].value;

                if (accountNhan == "" || title == "" || requestText == "") {
                    alert("Vui lòng điền đầy đủ thông tin.");
                    return false;
                }
                return true;
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

                    <main class="bg-white-500 flex-1 p-6 overflow-hidden rounded-lg">
                        <div class="flex flex-col">
                            <!-- Card Section Starts Here -->
                            <div class="flex flex-1 flex-col md:flex-row lg:flex-row mx-2">
                                <!--Email Request Form-->
                                <div class="mb-4 border-solid border-gray-300 border shadow-lg w-full md:w-3/4 lg:w-1/2 mx-auto rounded-lg">
                                    <div class="bg-gray-700 px-4 py-3 border-solid border-gray-300 border-b text-white rounded-t-lg">
                                        Gửi Yêu Cầu
                                    </div>
                                    <div class="p-4 bg-white rounded-b-lg">
                                        <form class="w-full" action="ReadRequest" method="post" name="myForm" onsubmit="return validateForm()">
                                            <input type="hidden" name="accountID" value="${sessionScope.acc.accountID}" />
                                            <div class="mb-6">
                                                <label class="block text-gray-700 font-regular mb-1">
                                                    Người Nhận
                                                </label> 
                                                <select class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                        name="accountNhan">
                                                    <c:forEach items="${listK3}" var="a">
                                                        <c:if test="${a.accountID != sessionScope.acc.accountID}">
                                                            <c:if test="${sessionScope.acc.role == 1}">
                                                                <c:if test="${a.role == 0}">
                                                            <option value="${a.accountID}">${a.hoVaTen}</option>
                                                               </c:if>
                                                            </c:if>
                                                            <c:if test="${sessionScope.acc.role == 0}">
                                                            <option value="${a.accountID}">${a.hoVaTen}</option>
                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                            <div class="mb-6">
                                                <label class="block text-gray-700 font-regular mb-1" >
                                                    Tiêu Đề
                                                </label>
                                                <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                       name="title" type="text" placeholder="Nhập tiêu đề" required>
                                            </div>
                                            <div class="mb-6">
                                                <label class="block text-gray-700 font-regular mb-1" for="requestText">
                                                    Nội Dung Yêu Cầu
                                                </label>
                                                <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                          name="requestText" rows="10" required></textarea>
                                            </div>
                                            <div class="mb-6">
                                                <label class="block text-gray-700 font-regular mb-1" for="title">
                                                    Tình Trạng
                                                </label>
                                                <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                       name="tinhTrang" type="text" value="" >
                                            </div>
                                            <p style="color: red;">${Message}</p>
                                            <p style="color: green;">${Message1}</p>

                                            <div class="flex justify-between">
                                                <button class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                        type="button" onclick="window.history.back()">
                                                    Back
                                                </button>
                                                <button class="shadow bg-gray-700 hover:bg-gray-600 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded" onclick="confirmSend(event, this.href)"
                                                        type="submit">
                                                    Send 
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!--/Email Request Form-->
                            </div>
                            <!-- /Card Section Ends Here -->
                        </div>
                    </main>
                    <!--/Main-->

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
