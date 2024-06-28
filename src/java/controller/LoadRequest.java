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

@WebServlet(name="LoadRequest", urlPatterns={"/LoadRequest"})
public class LoadRequest extends HttpServlet {
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
                int requestId = Integer.parseInt(requestIdParam);
                RequestDao requestDao = new RequestDao();
                DAO dao = new DAO();
                List<Accounts> acc = dao.getAccounts();
                List<Request> requests = requestDao.getAllRequestByRequestID(requestId);
                request.setAttribute("listK3", acc);
                request.setAttribute("requests", requests); 
                request.getRequestDispatcher("Respone.jsp").forward(request, response); 
            } else {
                response.sendRedirect("error.jsp");
            }
    }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
