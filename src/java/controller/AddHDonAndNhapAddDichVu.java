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

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "AddHDonAndNhapAddDichVu", urlPatterns = {"/addhdonandnhapadddichvu"})
public class AddHDonAndNhapAddDichVu extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("id");
        String hoaDonID = request.getParameter("HoaDonID");
        String hopDongID = request.getParameter("HopDongID");
        String ngayThanhToan = request.getParameter("NgayThanhToan");
        String tinhTrangThanhToan = request.getParameter("TinhTrangThanhToan");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String tongTien = request.getParameter("TongTien");

        SonDAO sondao = new SonDAO();

        sondao.insertHoaDon(hoaDonID, hopDongID, ngayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);

        response.sendRedirect("nhapadddichvu?id=" + pid);
    }
}
