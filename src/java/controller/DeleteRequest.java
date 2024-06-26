/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.RequestDao;
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
import model.Request;

@WebServlet(name = "DeleteRequest", urlPatterns = {"/DeleteRequest"})
public class DeleteRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("login"); 
        } else {
            String requestIdParam = request.getParameter("id");
            if (requestIdParam != null && !requestIdParam.isEmpty()) {
                try {
                    int requestId = Integer.parseInt(requestIdParam);
                    RequestDao requestDao = new RequestDao();
                    requestDao.deleteRequestByRequestID(requestId);
                    DAO dao = new DAO();
                    RequestDao dao1 = new RequestDao();
                    List<Accounts> acc = dao.getAccounts();
                    List<Request> gui = dao1.getAllRequestGui(a.getAccountID());
                    List<Request> requests = dao1.getAllRequestNhan(a.getAccountID());
                        request.setAttribute("requests", requests);
                    request.setAttribute("listK3", acc);
                    request.setAttribute("gui", gui);
                    request.setAttribute("message1", "Delete thành công!");
                    request.getRequestDispatcher("ListRequest?action=gui").forward(request, response);
                } catch (NumberFormatException e) {
                    response.sendRedirect("error.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }
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
