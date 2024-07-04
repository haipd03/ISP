<%-- 
    Document   : AddDichVu
    Created on : May 29, 2024, 10:44:42 PM
    Author     : vulin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
<%@page import = "model.ThietBi" %>
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
                            Thêm Dịch Vụ
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">Thêm Dịch Vụ</div>
                                            <div class="card-body">
                                                <c:if test="${not empty errorMessage}">
                                                    <div class="alert alert-danger">${errorMessage}</div>
                                                </c:if>
                                                <form action="adddichvu" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Mã Dịch Vụ:</label>
                                                            <input name="DichVuID" type="text" class="form-control" value="${nextDichVuID}" readonly>
                                                        </div>
                                                        <div class="form-group col-md-6">

                                                            <label>Số Phòng ID:</label>
                                                            <select name="PhongID" class="form-control" required>
                                                                <c:forEach var="phong" items="${ldv}">
                                                                    <option value="${phong.phongID}">${phong.phongID}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Tên:</label>
                                                            <input name="Name" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Giá Tiền:</label>
                                                            <input name="GiaTien" type="text" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Từ Ngày:</label>
                                                            <input name="TuNgay" type="date" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Đến Ngày:</label>
                                                            <input name="DenNgay" type="date" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Chỉ số cũ:</label>
                                                            <input name="ChiSoCu" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Chỉ số mới:</label>
                                                            <input name="ChiSoMoi" type="text" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <input type="submit" class="btn btn-success" value="Add">
                                                        <a href="listdichvu?id=${detail.dichVuID}" class="btn btn-danger">Quay về</a>
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
                    <div class="flex flex-1 mx-auto">&copy; My Design</div>
                </footer>
                <!--/footer-->
            </div>
        </div>
        <script src="./main.js"></script>
    </body>

</html>

