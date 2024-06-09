/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
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
import model.ThietBi;
import model.Phong;
import model.Khu;

@WebServlet(name = "ListAllThietBi", urlPatterns = {"/ListAllThietBi"})
public class ListAllThietBi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListAllThietBi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAllThietBi at " + request.getContextPath() + "</h1>");
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

        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        } else {
            DAO dao = new DAO();
            List<Accounts> acc = dao.getAccounts();
            List<ThietBi> ltb = dao.getAllThietBi();
//            List<ThietBi> ltb;
            List<Khu> listK = dao.getKhuByKhuID();
            List<Phong> listP = dao.getPhong();
//            if (a.getRole() == 0) {
//                ltb = dao.getAllThietBi();
//            } else {
//                ltb = dao.getAllThietBiByAccountID(a.getAccountID());
//                
//            }
            request.setAttribute("listK", listK);
            request.setAttribute("listP", listP);
            request.setAttribute("ltb", ltb);
            request.setAttribute("listK3", acc);
            request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
