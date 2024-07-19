/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@WebServlet(name = "DeleteAcc", urlPatterns = {"/deleteacc"})
public class DeleteAcc extends HttpServlet {

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
    String aid = request.getParameter("aid");
    DAO dao = new DAO();

    try {
        if ("1".equals(aid)) {
            request.setAttribute("error", "Không Thể Xóa Account Admin");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaccount");
            dispatcher.forward(request, response);
            return;
        }

        if (dao.checkAccIDcoKhu(aid)) {
            request.setAttribute("error", "Account đang quản lý khu không thể xóa!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaccount");
            dispatcher.forward(request, response);
        } else {
            dao.deleteAccount(aid);
            response.sendRedirect("listaccount");
        }
    } catch (SQLException ex) {
        Logger.getLogger(DeleteAcc.class.getName()).log(Level.SEVERE, null, ex);
        request.setAttribute("error", "Có lỗi xảy ra trong quá trình xóa tài khoản.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaccount");
        dispatcher.forward(request, response);
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



