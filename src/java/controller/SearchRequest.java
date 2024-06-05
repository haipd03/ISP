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

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchRequest", urlPatterns = {"/SearchRequest"})
public class SearchRequest extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet New</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet New at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

// Kiểm tra nếu a bằng null, chuyển hướng đến trang login
        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int accountID = 0;
        String title = request.getParameter("title");
        String submittedAtStr = request.getParameter("submittedAt");
        String accountNhanStr = request.getParameter("accountNhan");
        java.sql.Date submittedAt = null;
        int accountNhan = 0;

        if (request.getParameter("accountID") != null) {
            accountID = Integer.parseInt(request.getParameter("accountID"));
        }

        if (submittedAtStr != null && !submittedAtStr.isEmpty()) {
            submittedAt = java.sql.Date.valueOf(submittedAtStr);
        }

        if (accountNhanStr != null && !accountNhanStr.isEmpty()) {
            accountNhan = Integer.parseInt(accountNhanStr);
        }

        RequestDao dao1 = new RequestDao();
        DAO dao = new DAO();
        List<Accounts> acc = dao.getAccounts();
        List<Request> results = dao1.searchRequests(accountID, title, submittedAt);

        if (results.isEmpty()) {
            request.setAttribute("error", "Không tìm thấy kết quả!");
            request.setAttribute("listK3", acc);
            request.setAttribute("requests", results);
        } else {
            request.setAttribute("listK3", acc);
            request.setAttribute("requests", results);
        }

        request.setAttribute("accountNhan", accountNhan);
        request.getRequestDispatcher("ListRequest.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

// Kiểm tra nếu a bằng null, chuyển hướng đến trang login
        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int accountID = 0;
        String title = request.getParameter("title");
        String submittedAtStr = request.getParameter("submittedAt");
        String accountNhanStr = request.getParameter("accountNhan");
        java.sql.Date submittedAt = null;
        int accountNhan = 0;

        if (request.getParameter("accountNhan") != null) {
            accountID = Integer.parseInt(request.getParameter("accountNhan"));
        }

        if (submittedAtStr != null && !submittedAtStr.isEmpty()) {
            submittedAt = java.sql.Date.valueOf(submittedAtStr);
        }

        if (accountNhanStr != null && !accountNhanStr.isEmpty()) {
            accountNhan = Integer.parseInt(accountNhanStr);
        }

        RequestDao dao1 = new RequestDao();
        DAO dao = new DAO();
        List<Accounts> acc = dao.getAccounts();
        List<Request> results = dao1.searchRequestsGui(accountNhan, title, submittedAt);

        if (results.isEmpty()) {
            request.setAttribute("error", "Không tìm thấy kết quả!");
            request.setAttribute("listK3", acc);
            request.setAttribute("gui", results);
        } else {
            request.setAttribute("listK3", acc);
            request.setAttribute("gui", results);
        }

        request.setAttribute("accountNhan", accountNhan);
        request.getRequestDispatcher("ListRequest.jsp?action=gui").forward(request, response);
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
