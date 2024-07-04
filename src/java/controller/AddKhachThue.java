/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddKhachThue", urlPatterns = {"/addkhachthue"})

public class AddKhachThue extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String KhachID = request.getParameter("KhachID");
        String HoVaTen = request.getParameter("HoVaTen");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");
        String QueQuan = request.getParameter("QueQuan");
        String TenNguoiThan = request.getParameter("TenNguoiThan");
        String SDTNguoiThan = request.getParameter("SDTNguoiThan");
        String QuanHeVoiNguoiThan = request.getParameter("QuanHeVoiNguoiThan");
        String PhongID = request.getParameter("PhongID");
        String TinhTrang = request.getParameter("TinhTrang");

        // Validation
        String errorMsg = null;

        if (HoVaTen == null || HoVaTen.trim().isEmpty() || HoVaTen.length() > 50) {
            errorMsg = "Họ và tên không hợp lệ.";
        } else if (CCCD == null || !CCCD.matches("\\d{12}")) {
            errorMsg = "CCCD không hợp lệ.";
        } else if (SDT == null || !SDT.matches("\\d{10}")) {
            errorMsg = "Số điện thoại không hợp lệ.";
        } else if (QueQuan == null || QueQuan.trim().isEmpty() || QueQuan.length() > 100) {
            errorMsg = "Quê quán không hợp lệ.";
        } else if (TenNguoiThan != null && TenNguoiThan.length() > 50) {
            errorMsg = "Tên người thân không hợp lệ.";
        } else if (SDTNguoiThan != null && !SDTNguoiThan.matches("\\d{10}")) {
            errorMsg = "Số điện thoại người thân không hợp lệ.";
        } else if (QuanHeVoiNguoiThan != null && QuanHeVoiNguoiThan.length() > 50) {
            errorMsg = "Quan hệ với người thân không hợp lệ.";
        } else if (PhongID == null || !PhongID.matches("\\d+")) {
            errorMsg = "Không thể thêm khách thuê.";
        }

        SonDAO sondao = new SonDAO();
        
        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("listNguoiThue?lntid=" + PhongID).forward(request, response);
        } else {
            sondao.insertkhachthue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
            response.sendRedirect("listNguoiThue?lntid=" + PhongID);
        }
    }
}
