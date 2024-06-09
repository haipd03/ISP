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
import model.DichVu;

/**
 *
 * @author Ngoc Lan
 */
@WebServlet(name="AddHoaDonDetail", urlPatterns={"/addhoadondetail"})
public class AddHoaDonDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String hddid = request.getParameter("HoaDonDetailID");
        String hdid = request.getParameter("HoaDonID");
        String tn = request.getParameter("TuNgay");
        String dn = request.getParameter("DenNgay");
        int hs1 = Integer.parseInt(request.getParameter("HeSo"));
        String dvid = request.getParameter("DichVuID");
        
        DAO dao = new DAO();
        SonDAO sondao = new SonDAO();
        DichVu listdvu = sondao.getDichVubyID(dvid);
        
        int giaTien = listdvu.getGiaTien();
        int chiSoCu = listdvu.getChiSoCu();
        int chiSoMoi = listdvu.getChiSoMoi();
        
        int tongSo = chiSoMoi - chiSoCu;
        
        int thanhTien = tongSo * hs1 * giaTien;
        
        String ts = String.valueOf(tongSo);
        String hs = String.valueOf(hs1);
        String tt = String.valueOf(thanhTien);
        
        try {
            dao.insertHoaDonDetail(hddid, hdid, tn, dn, ts, hs, tt, dvid);
            response.sendRedirect("listhoadondetail?id=" + hdid);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}