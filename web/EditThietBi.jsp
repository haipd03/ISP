<%-- 
    Document   : EditThietBi
    Created on : May 19, 2024, 2:05:30 PM
    Author     : Ngoc Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Phong" %>
<%@page import = "model.ThietBi" %>
<%@page import = "java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Thiết Bị</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

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
                            <input value="${detail.tinhTrang}" name="TinhTrang" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Gia:</label>
                            <input value="${detail.gia}" name="Gia" type="text" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
                        

</body>
</html>