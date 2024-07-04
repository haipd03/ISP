/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.HaiDao;
import dal.LinhDao;
import dal.SonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import model.DichVu;

/**
 *
 * @author vulin
 */
@WebServlet(name = "ListDichVu", urlPatterns = {"/listdichvu"})
public class ListDichVu extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        
        List<DichVu> ldv = new ArrayList<>();
        LinhDao u = new LinhDao();
        SonDAO sondao = new SonDAO();
        String pageStr = request.getParameter("page");
        int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
        int pageSize = 10;
        int offset = (page - 1) * pageSize;

        if (a == null) {
            response.sendRedirect("login");
        } else {

            if (a.getRole() == 1) {
                ldv = sondao.getAllDichVuByAccountID(a.getAccountID(), offset, pageSize);
            } else {
                ldv = u.getAllDichVu(offset, pageSize);
            }
        }

        int totalRecords = u.getTotalDichVuRecords();
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        int totalRecords1 = u.getTotalDichVuRecords1(a.getAccountID());
        int totalPages1 = (int) Math.ceil((double) totalRecords1 / pageSize);

        request.setAttribute("currentPage", page);
        request.setAttribute("ldv", ldv);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalPages1", totalPages1);
        request.getRequestDispatcher("DichVu.jsp").forward(request, response);
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
