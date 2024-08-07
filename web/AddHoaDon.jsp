<%-- 
    Document   : AddThietBi.jsp
    Created on : May 19, 2024, 6:48:54 PM
    Author     : Ngoc Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dal.HaiDao.HoaDonWithSoPhong" %>
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
        <title>Thêm hóa đơn</title>
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
                            Thêm hóa đơn
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <div class="table-wrapper">
                                    <div class="table-title">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <h2>Thêm hóa đơn</h2>
                                            </div>
                                            <div class="col-sm-6"></div>
                                        </div>
                                    </div>
                                </div>
                                <div id="editEmployeeModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form action="addhoadon" method="post">
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Chi tiết</h4>
                                                </div>
                                                <div class="modal-body">					
                                                    <div class="form-group">
                                                        <label>Mã Hóa Đơn</label>
                                                        <input name="HoaDonID" type="text" class="form-control" required>
                                                    </div>                                                    
                                                    <div class="form-group">
                                                        <label>Hợp Đồng</label>
                                                        <input name="HopDongID" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Ngày Thanh Toán</label>
                                                        <input name="NgayThanhToan" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tình trạng</label>
                                                        <input name="TinhTrangThanhToan" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Từ Ngày</label>
                                                        <input name="TuNgay" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Đến Ngày</label>
                                                        <input name="DenNgay" type="date" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tổng Tiền</label>
                                                        <input name="TongTien" type="text" class="form-control" required>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">                            
                                                    <input type="submit" class="btn btn-success" value="Add">

                                                        <a href="" class="btn btn-danger">Quay về</a>
                                                    
                                                </div>
                                            </form>
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
