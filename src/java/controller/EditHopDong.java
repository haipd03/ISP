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
@WebServlet(name="EditHopDong", urlPatterns={"/edithopdong"})
public class EditHopDong extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        SonDAO sondao = new SonDAO();
        
        sondao.updateHopDong(HopDongID, KhachID, PhongID, TienCoc, NgayThue, NgayTra, SoKhachThue, GhiChu, CCCD, SDT, HoVaTen, TinhTrang);
        response.sendRedirect("listhopdong");
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
