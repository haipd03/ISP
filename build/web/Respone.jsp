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
            function confirmSend(event) {
                var phanHoi = document.forms["feedbackForm"]["phanHoi"].value;
                if (phanHoi.trim() === "") {
                    alert("Vui lòng nhập phản hồi để gửi!");
                    event.preventDefault();
                    return false;
                }
                if (!confirm("Bạn có chắc muốn gửi tin nhắn này?")) {
                    event.preventDefault();
                    return false;
                }
                return true;
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
                                        Phản Hồi Yêu Cầu
                                    </div>
                                    <div class="p-4 bg-white rounded-b-lg">
                                        <form action="UpdateRequest" method="post" class="w-full" name="feedbackForm" onsubmit="return confirmSend(event)">
                                            <c:forEach items="${requests}" var="r">
                                                <div class="mb-6">
                                                    <label class="block text-gray-700 font-regular mb-1">
                                                        Người Gửi
                                                    </label>
                                                    <c:forEach items="${listK3}" var="a">
                                                        <c:if test="${a.accountID == r.accountID}">
                                                            <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                   name="accountID" type="text" value="${a.hoVaTen}" readonly>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="mb-6">
                                                    <label class="block text-gray-700 font-regular mb-1">
                                                        Tiêu Đề
                                                    </label>
                                                    <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                           name="title" type="text" value="${r.title}" readonly>
                                                </div>
                                                <div class="mb-6">
                                                    <label class="block text-gray-700 font-regular mb-1" for="requestText">
                                                        Nội Dung Yêu Cầu
                                                    </label>
                                                    <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                              name="requestText" rows="7" readonly>${r.requestText}</textarea>
                                                </div>
                                                <!--TH1-->
                                                <c:if test="${r.tinhTrang == 0}">
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="phanHoi">
                                                            Phản Hồi 
                                                        </label>
                                                        <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                  id="phanHoi" name="phanHoi" rows="7" required></textarea>
                                                    </div>
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="tinhTrang">
                                                            Tình Trạng
                                                        </label>
                                                        <select class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                name="tinhTrang">
                                                            <option value="" disabled selected hidden>${r.tinhTrang == 1 ? 'Đã làm' : 'Chưa làm'}</option>
                                                            <option value="1" ${r.tinhTrang == 1 ? 'selected' : ''}>Đã làm</option>
                                                            <option value="0" ${r.tinhTrang == 0 ? 'selected' : ''}>Chưa làm</option>
                                                            <option value="2" ${r.tinhTrang == 2 ? 'selected' : ''}>Đang làm</option>
                                                        </select>
                                                    </div>
                                                    <input type="hidden" name="requestID" value="${r.requestID}">
                                                    <div class="flex justify-between">
                                                        <button class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="button" onclick="window.history.back()">
                                                            Quay về
                                                        </button>
                                                        <button class="shadow bg-gray-700 hover:bg-gray-600 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="submit">
                                                            Gửi 
                                                        </button>
                                                    </div>
                                                </c:if>
                                                <!--TH2-->
                                                <c:if test="${r.tinhTrang == 1}">
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="phanHoi">
                                                            Bạn Đã Phản Hồi 
                                                        </label>
                                                        <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                  name="phanHoi" rows="7" readonly>${r.phanHoi}</textarea>
                                                    </div>
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="tinhTrang">
                                                            Tình Trạng
                                                        </label>
                                                        <input class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                               name="tinhTrang" type="text" value=" ${r.tinhTrang == 1 ? 'Đã làm' : 'Chưa làm'}"readonly>
                                                    </div>
                                                    <input type="hidden" name="requestID" value="${r.requestID}">
                                                    <div class="flex justify-between">
                                                        <button class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="button" onclick="window.history.back()">
                                                            Quay về
                                                        </button>
                                                        <button class="shadow bg-gray-700 hover:bg-gray-600 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="button" onclick="window.location.href = 'ListRequest'">
                                                            Danh sách
                                                        </button>
                                                    </div>
                                                </c:if>
                                                <!--TH3-->
                                                <c:if test="${r.tinhTrang == 2}">
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="phanHoi">
                                                            Phản Hồi 
                                                        </label>
                                                        <textarea class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                  id="phanHoi" name="phanHoi" rows="7" required></textarea>
                                                    </div>
                                                    <div class="mb-6">
                                                        <label class="block text-gray-700 font-regular mb-1" for="tinhTrang">
                                                            Tình Trạng
                                                        </label>
                                                        <select class="bg-gray-100 appearance-none border border-gray-300 rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                                                name="tinhTrang">
                                                            <option value="" disabled selected hidden>${r.tinhTrang == 1 ? 'Đã làm' : 'Chưa làm'}</option>
                                                            <option value="1" ${r.tinhTrang == 1 ? 'selected' : ''}>Đã làm</option>
                                                            <option value="2" ${r.tinhTrang == 2 ? 'selected' : ''}>Đang làm</option>
                                                        </select>
                                                    </div>
                                                    <input type="hidden" name="requestID" value="${r.requestID}">
                                                    <div class="flex justify-between">
                                                        <button class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="button" onclick="window.history.back()">
                                                            Quay về
                                                        </button>
                                                        <button class="shadow bg-gray-700 hover:bg-gray-600 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded"
                                                                type="submit">
                                                            Gửi 
                                                        </button>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </form>
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
                    <div class="flex flex-1 mx-auto">&copy; My Design</div>
                </footer>
                <!--/footer-->
            </div>
        </div>
        <script src="./main.js"></script>

    </body>

</html>
