<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.DichVuChung"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Sửa Dịch Vụ Chung</title>
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
                            Sửa Dịch Vụ Chung
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header"> Sửa Dịch Vụ Chung</div>
                                            <div class="card-body">
                                                <c:if test="${not empty errorMessage}">
                                                    <div class="alert alert-danger">${errorMessage}</div>
                                                </c:if>
                                                <form action="editdvc" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Mã dịch vụ chung</label>
                                                            <input value="${detail.dichVuChungID}" name="DichVuChungID" type="text" class="form-control" readonly required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Mã khu</label>
                                                            <input value="${detail.khuID}" name="KhuID" type="text" class="form-control" readonly required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Tên dịch vụ chung</label>
                                                            <input value="${detail.dichVuChungName}" name="DichVuChungName" type="text" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Tên công nhân</label>
                                                            <input value="${detail.ten}" name="Ten" type="text" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Số điện thoại</label>
                                                            <input value="${detail.sdt}" name="Sdt" type="text" class="form-control" required pattern="\d{10}" maxlength="10" title="Số điện thoại phải có 10 chữ số" oninput="validatePhoneNumber(this)">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Giá</label>
                                                            <input value="${detail.gia}" name="Gia" type="text" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>Từ ngày</label>
                                                            <input value="${detail.tuNgay}" name="TuNgay" type="date" class="form-control" required>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Đến ngày</label>
                                                            <input value="${detail.denNgay}" name="DenNgay" type="date" class="form-control" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="tinhTrang">Tình trạng</label>
                                                            <select name="TinhTrang" id="tinhTrang" class="form-control" required>
                                                                <option value="Chưa làm" ${detail.tinhTrang == 'Chưa làm' ? 'selected' : ''}>Chưa làm</option>
                                                                <option value="Đang làm" ${detail.tinhTrang == 'Đang làm' ? 'selected' : ''}>Đang làm</option>
                                                                <option value="Đã hoàn thành" ${detail.tinhTrang == 'Đã hoàn thành' ? 'selected' : ''}>Đã hoàn thành</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label>Ghi chú</label>
                                                            <input value="${detail.ghiChu}" name="GhiChu" type="text" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group text-right">
                                                        <button type="submit" class="btn btn-primary">Lưu</button>
                                                        <a href="listdichvuchung?id=${detail.dichVuChungID}" class="btn btn-danger">Quay về</a>
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
