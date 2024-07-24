/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.HaiDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Accounts;

/**
 *
 * @author admin
 */
@WebServlet(name="UnreadCountServlet", urlPatterns={"/unreadCount"})
public class UnreadCountServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Accounts acc = (Accounts) session.getAttribute("acc");
            if (acc != null) {
                HaiDao dao2 = new HaiDao();
                int unreadCount = dao2.countUnreadRequests(acc.getAccountID());
                response.setContentType("application/json");
                response.getWriter().write("{\"unreadCount\": " + unreadCount + "}");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No active session.");
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
}
