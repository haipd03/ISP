/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
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
 * @author Ngoc Lan
 */

@WebServlet(name = "EditHoaDonDetail", urlPatterns = {"/edithoadondetail"})
public class EditHoaDonDetail extends HttpServlet {

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
        String id = request.getParameter("id");

        String hddid = request.getParameter("HoaDonChiTietID");
        String hdid = request.getParameter("HoaDonID");
        String tn = request.getParameter("TuNgay");
        String dn = request.getParameter("DenNgay");
        String ts = request.getParameter("TongSo");
        String hs = request.getParameter("HeSo");
        String tt = request.getParameter("ThanhTien");
        String dvid = request.getParameter("DichVuID");

        String errorMsg = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (hs == null || !hs.matches("\\d+")) {
            errorMsg = "Hệ số không hợp lệ!";
        } else {
            int heSo = Integer.parseInt(hs);
            if (heSo <= 0) {
                errorMsg = "Hệ số phải là số nguyên dương và không được bằng 0!";
            } else {
                try {
                    Date dateNgayThue = dateFormat.parse(tn);
                    Date dateNgayTra = dateFormat.parse(dn);
                    if (!dateNgayTra.after(dateNgayThue)) {
                        errorMsg = "Ngày tính tiền dịch vụ không đúng!";
                    }
                } catch (ParseException e) {
                    errorMsg = "Định dạng ngày không hợp lệ.";
                }
            }
        }

        DAO dao = new DAO();
        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("loadhoadondetail").forward(request, response);
        } else {
            dao.editHoaDonDetail(tn, dn, ts, hs, tt, dvid, hddid);
            response.sendRedirect("listhoadondetail?id=" + hdid);
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
