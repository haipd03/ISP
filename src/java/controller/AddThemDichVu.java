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
@WebServlet(name = "AddThemDichVu", urlPatterns = {"/addthemdichvu"})
public class AddThemDichVu extends HttpServlet {

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

        String chiSoCuStr = request.getParameter("ChiSoCu");
        String chiSoMoiStr = request.getParameter("ChiSoMoi");
        String heSoStr = request.getParameter("HeSo");
        String giaTienStr = request.getParameter("GiaTien");

        String errorMsg = null;
        if (hdid == null || !hdid.matches("\\d+")) {
            errorMsg = "Bạn Không Thể Thêm Dịch Vụ!";
        } else if (heSoStr == null || !heSoStr.matches("\\d+")) {
            errorMsg = "Hệ số không hợp lệ.";
        }

        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("nhapaddhoadondetail?pid=" + pid + "&dvid=" + request.getParameter("DichVuID")).forward(request, response);
            return;
        }

        int csc = Integer.parseInt(chiSoCuStr);
        int csm = Integer.parseInt(chiSoMoiStr);
        int hs1 = Integer.parseInt(heSoStr);
        int gt = Integer.parseInt(giaTienStr);

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

        response.sendRedirect("nhapadddichvu?id=" + pid);
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
