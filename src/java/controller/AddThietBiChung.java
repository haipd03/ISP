/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.LanDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Ngoc Lan
 */
@WebServlet(name="AddThietBiChung", urlPatterns={"/addthietbichung"})
public class AddThietBiChung extends HttpServlet {
   
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
        
        String tbcid = request.getParameter("ThietBiChungID");
        String kid = request.getParameter("KhuID");
        String t = request.getParameter("Ten");
        String sl = request.getParameter("SoLuong");
        String tt = request.getParameter("TinhTrang");
        String g = request.getParameter("Gia");
        String soPattern = "^[0-9]+$";
       if (t == null || t.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên không được để trống.");
            request.getRequestDispatcher("insertthietbichung").forward(request, response);
            return;
        }
        if (!sl.matches(soPattern) || !g.matches(soPattern) ) {
            request.setAttribute("errorMessage", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("insertthietbichung");

            dispatcher.forward(request, response);
            return;
        }
        
        LanDao u = new LanDao();
        u.insertthietBiChung(tbcid, kid, t, sl, tt, g);
         request.getSession().setAttribute("success", "Đã Thêm thiết Bị Chung thành công!");
            response.sendRedirect("listthietbichung" );
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
