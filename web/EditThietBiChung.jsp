<%-- 
    Document   : EditThietBiChung
    Created on : Jul 2, 2024, 4:19:37 PM
    Author     : Ngoc Lan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Sửa Thiết Bị Chung</title>
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
                        <div class="p-6 bg-white">
                            <div class="container">
                                <h2 class="text-center">Sửa Thiết Bị Chung</h2>
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">Sửa Thiết Bị Chung</div>
                                            <div class="card-body">
                                                <form action="editthietbichung" method="get">
                                                    <div class="form-group">
                                                        <label>Mã Thiết Bị Chung:</label>
                                                        <input value="${detail.thietBiChungID}" name="ThietBiChungID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Mã Khu:</label>
                                                        <input value="${detail.khuID}" name="KhuID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tên:</label>
                                                        <input value="${detail.ten}" name="Ten" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Số Lượng:</label>
                                                        <input value="${detail.soLuong}" name="SoLuong" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tình Trạng</label>
                                                        <select name="TinhTrang" class="form-control" required>
                                                            <option value="Tốt" <c:if test="${detail.tinhTrang == 'Tốt'}">selected</c:if>>Tốt</option>
                                                            <option value="Đang sửa" <c:if test="${detail.tinhTrang == 'Đang sửa'}">selected</c:if>>Đang sửa</option>
                                                            <option value="Vô hiệu hóa" <c:if test="${detail.tinhTrang == 'Vô hiệu hóa'}">selected</c:if>>Vô hiệu hóa</option>
                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label>Giá</label>
                                                            <input value="${detail.gia}" name="Gia" type="text" class="form-control" required>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Lưu</button>
                                                    <a href="listthietbichung" class="btn btn-danger">Quay về</a>
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
                    <div class="flex flex-1 mx-auto">&copy; My Design</div>
                </footer>
                <!--/footer-->
            </div>
        </div>
        <script src="./main.js"></script>
    </body>

</html>

