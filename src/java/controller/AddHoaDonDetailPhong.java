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
import java.util.Date;
import java.util.List;
import model.HoaDon;
import model.HoaDonDetail;
import model.Phong;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "AddHoaDonDetailPhong", urlPatterns = {"/addhoadondetailphong"})
public class AddHoaDonDetailPhong extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String hddid = request.getParameter("HoaDonDetailID");
        String hdid = request.getParameter("HoaDonID");
        String tn = request.getParameter("TuNgay");
        String dn = request.getParameter("DenNgay");

        int csc = Integer.parseInt(request.getParameter("ChiSoCu"));
        int csm = Integer.parseInt(request.getParameter("ChiSoMoi"));

        int hs1 = Integer.parseInt(request.getParameter("HeSo"));
        
        int gt = Integer.parseInt(request.getParameter("GiaTien"));

        // Tính toán TongSo
        int tongSo = csm - csc;

        // Tính toán ThanhTien
        int thanhTien = tongSo * hs1 * gt;

        // Chuyển đổi các giá trị tính toán thành chuỗi
        String ts = String.valueOf(tongSo);
        String hs = String.valueOf(hs1);
        String tt = String.valueOf(thanhTien);

        String dvid = request.getParameter("DichVuID");

        SonDAO sondao = new SonDAO();

        sondao.insertHoaDonDetail(hddid, hdid, tn, dn, ts, hs, tt, dvid);

        Phong listphong = sondao.getPhongByHoaDonID(hdid);
        int giaPhong = listphong.getGia();

        HoaDon listhdon = sondao.getIDByHoaDonIDByPhongID(pid);

        int hdonid = listhdon.getHoaDonID();
        int hdongid = listhdon.getHopDongID();
        Date NgayThanhToan = listhdon.getNgayThanhToan();
        String tttt = listhdon.getTinhTrangThanhToan();
        Date TuNgay = listhdon.getTuNgay();
        Date DenNgay = listhdon.getDenNgay();

        List<HoaDonDetail> listhdondetail = sondao.getHoaDonDetail(hdid);

        int TongTien = giaPhong;
        for (HoaDonDetail detail : listhdondetail) {
            TongTien += detail.getThanhTien();
        }

        HoaDon hoadon = new HoaDon(hdonid, hdongid, NgayThanhToan, tttt, TuNgay, DenNgay, TongTien);
        sondao.updateHoaDon(hoadon);

        response.sendRedirect("listhoadonphong?id=" + pid);
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
