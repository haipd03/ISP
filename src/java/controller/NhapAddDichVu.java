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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Accounts;
import model.HoaDon;
import model.HopDong;
import model.Phong;

/**
 *
 * @author THANH SON
 */
@WebServlet(name="NhapAddDichVu", urlPatterns={"/nhapadddichvu"})
public class NhapAddDichVu extends HttpServlet {
   
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
    HttpSession session = request.getSession();
    Accounts a = (Accounts) session.getAttribute("acc");

    if (a == null || a.getRole() == 0) {
        response.sendRedirect("login.jsp");
    } else {
        String pid = request.getParameter("id");
        SonDAO sondao = new SonDAO();

        List<Phong> phong = sondao.getPhongByAccountID(pid, a.getAccountID());
        HoaDon listhdon = sondao.getIDByHoaDonIDByPhongIDAndAccountID(pid, a.getAccountID());
        int nextDichVuID = sondao.getNextDichVuID();

        request.setAttribute("lp1", phong);
        request.setAttribute("lp2", listhdon);
        request.setAttribute("lp3", pid);
        request.setAttribute("nextDichVuID", nextDichVuID);

        request.getRequestDispatcher("NhapAddDichVu.jsp").forward(request, response);
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
