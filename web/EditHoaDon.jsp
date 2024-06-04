

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.HoaDon" %>
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
        <title>Edit Hóa Đơn</title>
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
                            Edit Hóa Đơn
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <h2 class="text-center">Edit Hóa Đơn</h2>
                                <div class="row justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">Edit Hóa Đơn</div>
                                            <div class="card-body">
                                                <form action="edithoadon" method="post">
                                                    <div class="form-group">
                                                        <label>HoaDonID:</label>
                                                        <input value="${hoadon.hoaDonID}" name="HoaDonID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>HopDongID:</label>
                                                        <input value="${hoadon.hopDongID}" name="HopDongID" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>NgayThanhToan:</label>
                                                        <input value="${hoadon.ngayThanhToan}" name="NgayThanhToan" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>TinhTrangThanhToan:</label>
                                                        <input value="${hoadon.tinhTrangThanhToan}" name="TinhTrangThanhToan" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>TuNgay:</label>
                                                        <input value="${hoadon.tuNgay}" name="TuNgay" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>DenNgay:</label>
                                                        <input value="${hoadon.denNgay}" name="DenNgay" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>TongTien:</label>
                                                        <input value="${hoadon.tongTien}" name="TongTien" type="text" class="form-control" required>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                                    <a href="listhoadon" class="btn btn-danger">Back</a>
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
