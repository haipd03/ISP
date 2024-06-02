<%-- 
    Document   : EditThietBi.jsp
    Created on : May 19, 2024, 2:05:30 PM
    Author     : Ngoc Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
<%@page import = "model.DichVu" %>
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
        <title>Edit Thiết Bị</title>
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
                        <div class="bg-gray-600 text-white px-4 py-3 rounded-t-lg">
                            Edit Thiết Bị
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <h2 class="text-center">Edit Thiết Bị</h2>
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">Edit Thiết Bị</div>
                                            <div class="card-body">
                                                <form action="edittb" method="post">
                                                    <div class="form-group">
                                                        <label>ThietBiID:</label>
                                                        <input value="${detail.thietBiID}" name="ThietBiID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>PhongID:</label>
                                                        <input value="${detail.phongID}" name="PhongID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Name:</label>
                                                        <input value="${detail.name}" name="Name" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>SoLuong:</label>
                                                        <input value="${detail.soLuong}" name="Soluong" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>TinhTrang:</label>
                                                        <select name="TinhTrang" class="form-control" required>
                                                            <option value="Tốt" <c:if test="${detail.tinhTrang == 'Tốt'}">selected</c:if>>Tốt</option>
                                                            <option value="Bảo trì" <c:if test="${detail.tinhTrang == 'Bảo trì'}">selected</c:if>>Bảo trì</option>
                                                            <option value="Vô hiệu hóa" <c:if test="${detail.tinhTrang == 'Vô hiệu hóa'}">selected</c:if>>Vô hiệu hóa</option>
                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label>Gia:</label>
                                                            <input value="${detail.gia}" name="Gia" type="text" class="form-control" required>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                                    <a href="listthietbi?id=${detail.phongID}" class="btn btn-danger">Back</a>
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