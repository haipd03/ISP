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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet" href="./dist/all.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Chỉnh sửa thông tin hóa đơn chi tiết</title>
</head>
<body>
    <div class="mx-auto bg-grey-lightest">
        <div class="min-h-screen flex flex-col">
            <jsp:include page="menu1.jsp" />
            <div class="flex flex-1">
                <jsp:include page="menu2.jsp" />
                <div class="mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-4/5">
                    <div class="bg-gray-600 text-white px-4 py-3 rounded-t-lg">
                        Chỉnh sửa thông tin hóa đơn chi tiết
                    </div>
                   <c:if test="${not empty error}">
                            <p style="color: red; font-size: 1.2em; font-weight: bold;">${error}</p>
                        </c:if>
                    <div class="p-6 bg-white">
                        <div class="container">
                            <h2 class="text-center">Chỉnh sửa</h2>
                            <div class="row justify-content-center">
                                <div class="col-md-8">
                                    <div class="card">
                                        <div class="card-header">Chi tiết:</div>
                                        <div class="card-body">
                                            <form action="edithoadondetail" method="post">
                                                <div class="form-group">
                                                    <label>Mã hóa đơn chi tiết </label>
                                                    <input value="${detail.hoaDonDetailID}" name="HoaDonChiTietID" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Mã hóa đơn</label>
                                                    <input value="${detail.hoaDonID}" name="HoaDonID" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Từ ngày </label>
                                                    <input value="${detail.tuNgay}" name="TuNgay" type="date" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Đến ngày</label>
                                                    <input value="${detail.denNgay}" name="DenNgay" type="date" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Tổng số</label>
                                                    <input value="${detail.tongSo}" name="TongSo" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Hệ số</label>
                                                    <input value="${detail.heSo}" name="HeSo" type="text" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Thành tiền</label>
                                                    <input value="${detail.thanhTien}" name="ThanhTien" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Mã dich vụ</label>
                                                    <input value="${detail.dichVuID}" name="DichVuID" type="text" class="form-control" readonly required>
                                                </div>
                                                <input type="hidden" name="id" value="${lp3}">
                                                <button type="submit" class="btn btn-primary">Lưu</button>
                                                <a href="listhoadondetail?id=${detail.hoaDonID}" class="btn btn-danger">Quay về</a>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="bg-grey-darkest text-white p-2">
                <div class="flex flex-1 mx-auto">&copy; My Design</div>
            </footer>
        </div>
    </div>
    <script src="./main.js"></script>
</body>
</html>