<%-- 
    Document   : AddThietBiChung
    Created on : Jul 2, 2024, 2:19:43 AM
    Author     : Ngoc Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Khu" %>
<%@page import = "model.ThietBiChung" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Css -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Thêm Dịch Vụ</title>
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

                    <!-- Main Content -->
                    <div class="mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-4/5">
                        <div class="bg-blue-500 text-white text-center font-bold text-2xl px-4 py-3 rounded-t-lg">
                            Thêm Thiết Bị Chung
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">Thêm Thiết Bị Chung</div>
                                            <div class="card-body">
                                                <c:if test="${not empty errorMessage}">
                                                    <div class="alert alert-danger">${errorMessage}</div>
                                                </c:if>
                                                <form action="addthietbichung" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Mã Thiết Bị Chung:</label>
                                                            <input name="ThietBiChungID" type="text" class="form-control" value="${nextThietBiChungID}" readonly>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Mã Khu:</label>
                                                            <select name="KhuID" class="form-control" required>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Tên:</label>
                                                            <input name="Ten" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Số Lượng: </label>
                                                            <input name="SoLuong" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Tình Trạng: </label>
                                                            <select name="TinhTrang" class="form-control" required>
                                                                <option value="Tốt">Tốt</option>
                                                                <option value="Bảo trì">Đang sửa </option>
                                                                <option value="Vô hiệu hóa">Vô hiệu hóa</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Giá:</label>
                                                            <input name="Gia" type="text" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="modal-footer">
                                                        <input type="submit" class="btn btn-success" value="Add">
                                                        <a href="listthietbichung?id=${detail.thietBiChungID}" class="btn btn-danger">Quay về</a>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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


