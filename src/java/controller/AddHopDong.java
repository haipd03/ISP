/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SonDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "AddHopDong", urlPatterns = {"/addhopdong"})
public class AddHopDong extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        String HopDongID = request.getParameter("HopDongID");
        String KhachID = request.getParameter("KhachID");
        String PhongID = request.getParameter("PhongID");
        String TienCoc = request.getParameter("TienCoc");
        String NgayThue = request.getParameter("NgayThue");
        String NgayTra = request.getParameter("NgayTra");
        String SoKhachThue = request.getParameter("SoKhachThue");
        String GhiChu = request.getParameter("GhiChu");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");
        String HoVaTen = request.getParameter("HoVaTen");
        String TinhTrang = request.getParameter("TinhTrang");

        String errorMsg = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (KhachID == null || !KhachID.matches("\\d+")) {
            errorMsg = "Bạn Cần thêm Khách Thuê Đại diện trước khi tạo Hợp Đồng!";
        } else if (TienCoc == null || !TienCoc.matches("\\d+")) {
            errorMsg = "TienCoc không hợp lệ.";
        } else if (SoKhachThue == null || !SoKhachThue.matches("\\d+")) {
            errorMsg = "Số khách thuê không hợp lệ.";
        } else {
            try {
                Date dateNgayThue = dateFormat.parse(NgayThue);
                Date dateNgayTra = dateFormat.parse(NgayTra);
                if (!dateNgayTra.after(dateNgayThue)) {
                    errorMsg = "Ngày trả phải lớn hơn ngày thuê.";
                }
            } catch (ParseException e) {
                errorMsg = "Định dạng ngày không hợp lệ.";
            }
        }

        SonDAO sondao = new SonDAO();

        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("nhapaddhopdong").forward(request, response);
        } else {
            sondao.insertHopDong(HopDongID, KhachID, PhongID, TienCoc, NgayThue, NgayTra, SoKhachThue, GhiChu, CCCD, SDT, HoVaTen, TinhTrang);
            response.sendRedirect("listhopdong");
        }
    }

}
