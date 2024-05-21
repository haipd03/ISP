<%-- 
    Document   : AddThietBi.jsp
    Created on : May 19, 2024, 6:48:54 PM
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
        <title>Add</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Thêm thiết bị</h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="addthietbi" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Chi tiết</h4>

                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ThietBiID:</label>
                                    <input name="ThietBiID" type="text" class="form-control" required>
                                </div>
                                <c:forEach items="${pid}" var="thietbi">
                                    <div class="form-group">
                                        <label>PhongID:</label>
                                        <input value="${thietbi.phongID}" name="PhongID" type="text" class="form-control" readonly required>                                    
                                    </div>
                                </c:forEach>
                                <div class="form-group">
                                    <label>Name:</label>
                                    <input name="Name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>SoLuong:</label>
                                    <input name="SoLuong" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>TinhTrang:</label>
                                    <input name="TinhTrang" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Gia:</label>
                                    <input name="Gia" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">                            
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>