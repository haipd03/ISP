/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.SonDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import model.HopDong;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "EditKhachThue", urlPatterns = {"/editKhachThue"})
public class EditKhachThue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
    }

    DAO dao = new DAO();
    if (errorMsg != null) {
        request.setAttribute("error", errorMsg);
        request.getRequestDispatcher("listNguoiThue?lntid=" + PhongID).forward(request, response);
    } else {
        SonDAO sondao = new SonDAO();

        HopDong hd = sondao.getHopDongByKhachID(KhachID);
        if (hd != null) {
            int hdongid = hd.getHopDongID();
            int khachid = hd.getKhachID();
            int phongid = hd.getPhongID();
            int tiencoc = hd.getTienCoc();
            Date ngaythue = hd.getNgayThue();
            Date ngaytra = hd.getNgayTra();
            int sokhachthue = hd.getSoKhachThue();
            String ghichu = hd.getGhiChu();
            int tinhtrang = hd.getTinhTrang();

            String hdid = String.valueOf(hdongid);
            String kid = String.valueOf(khachid);
            String pid = String.valueOf(phongid);
            String tc = String.valueOf(tiencoc);
            String skt = String.valueOf(sokhachthue);
            String tt = String.valueOf(tinhtrang);
            String nthue = String.valueOf(ngaythue);
            String ntra = String.valueOf(ngaytra);

            sondao.updateHopDong(hdid, kid, pid, tc, nthue, ntra, skt, ghichu, CCCD, SDT, HoVaTen, tt);
        }
        dao.Updatekhachthue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
        response.sendRedirect("listNguoiThue?lntid=" + PhongID);
    }
}
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
