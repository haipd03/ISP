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
    <title>Edit Thiết Bị</title>
</head>
<body>
    <div class="mx-auto bg-grey-lightest">
        <div class="min-h-screen flex flex-col">
            <jsp:include page="menu1.jsp" />
            <div class="flex flex-1">
                <jsp:include page="menu2.jsp" />
                <div class="mb-4 md:mx-2 lg:mx-2 border border-gray-300 rounded-lg shadow-lg w-full md:w-1/2 lg:w-4/5">
                    <div class="bg-gray-600 text-white px-4 py-3 rounded-t-lg">
                        Chỉnh sửa hóa đơn chi tiết
                    </div>
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
                                                    <label>HoaDonDetailID:</label>
                                                    <input value="${detail.hoaDonDetailID}" name="HoaDonChiTietID" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>HoaDonID</label>
                                                    <input value="${detail.hoaDonID}" name="HoaDonID" type="text" class="form-control" readonly required>
                                                </div>
                                                <div class="form-group">
                                                    <label>TuNgay</label>
                                                    <input value="${detail.tuNgay}" name="TuNgay" type="date" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>DenNgay</label>
                                                    <input value="${detail.denNgay}" name="DenNgay" type="date" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>TongSo</label>
                                                    <input value="${detail.tongSo}" name="TongSo" type="text" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>HeSo</label>
                                                    <input value="${detail.heSo}" name="HeSo" type="text" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>ThanhTien</label>
                                                    <input value="${detail.thanhTien}" name="ThanhTien" type="text" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>DichVuID</label>
                                                    <input value="${detail.dichVuID}" name="DichVuID" type="text" class="form-control" readonly required>
                                                </div>
                                                <button type="submit" class="btn btn-primary">Save Changes</button>
                                                <a href="listhoadondetail?id=${detail.hoaDonID}" class="btn btn-danger">Back</a>
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