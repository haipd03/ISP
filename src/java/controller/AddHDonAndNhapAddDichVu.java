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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        String errorMsg = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (hopDongID == null || !hopDongID.matches("\\d+")) {
            errorMsg = "Bạn Không Thể Thêm Hóa Đơn!";
        } else {
            try {
                Date dateNgayThue = dateFormat.parse(tuNgay);
                Date dateNgayTra = dateFormat.parse(denNgay);
                if (!dateNgayTra.after(dateNgayThue)) {
                    errorMsg = "Ngày tính tiền dịch vụ không đúng!";
                }
            } catch (ParseException e) {
                errorMsg = "Định dạng ngày không hợp lệ.";
            }
        }

        SonDAO sondao = new SonDAO();

        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("nhapaddhoadonphong").forward(request, response);
        } else {
            sondao.insertHoaDon(hoaDonID, hopDongID, ngayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
            response.sendRedirect("nhapadddichvu?id=" + pid);
        }
    }
}
