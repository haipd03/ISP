<%-- 
    Document   : AddHoaDonDetail
    Created on : May 30, 2024, 6:59:37 PM
    Author     : Ngoc Lan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.HoaDon" %>
<%@page import = "model.HoaDonDetail" %>
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
        <title></title>
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
                            Thêm hóa đơn chi tiết
                        </div>
                        <div class="p-6 bg-white">
                            <div class="container">
                                <div class="table-wrapper">
                                    <div class="table-title">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <h2>Thêm hóa đơn chi tiết</h2>
                                            </div>
                                            <div class="col-sm-6"></div>
                                        </div>
                                    </div>
                                </div>
                                <div id="editEmployeeModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form action="addhoadondetail" method="post">
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Chi tiết</h4>
                                                </div>

                                                <c:if test="${not empty error}">
                                                    <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                                                </c:if>
                                                <div class="modal-body">					
                                                    <div class="form-group">
                                                        <label>Mã hóa đơn chi tiết</label>
                                                        <input name="HoaDonDetailID" type="text" class="form-control" value="${nextHoaDonDetailID}" readonly>
                                                    </div>

                                                    <div class="form-group">
                                                        <label>Mã hóa đơn</label>

                                                        <input value="${id}" name="HoaDonID" type="text" class="form-control" readonly required>                                    

                                                    </div>

                                                    <div class="form-group">
                                                        <label>Từ ngày</label>
                                                        <input name="TuNgay" type="date" class="form-control" value="${hdid[0].tuNgay}" readonly>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Đến ngày</label>
                                                        <input name="DenNgay" type="date" class="form-control" value="${hdid[0].denNgay}" readonly>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Hệ số</label>
                                                        <select name="HeSo" required class="form-control">
                                                            <option value="1">1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="4">4</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Mã dịch vụ</label>
                                                        <select name="DichVuID" required class="form-control">
                                                            <c:forEach items="${dv1}" var="d">
                                                                <option value="${d.dichVuID}">${d.dichVuID}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">                            
                                                    <input type="submit" class="btn btn-success" value="Add">
                                                    <c:forEach items="${hdid}" var="o">
                                                        <a href="listhoadondetail?id=${o.hoaDonID}" class="btn btn-danger">Quay về</a>
                                                    </c:forEach>
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
