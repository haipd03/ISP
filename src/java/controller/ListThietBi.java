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

@WebServlet(name = "ListThietBi", urlPatterns = {"/listthietbi"})
public class ListThietBi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            // Redirect to login page or show error message if account is not logged in
            response.sendRedirect("login.jsp");
        } else {
            String id = request.getParameter("id");
            DAO dao = new DAO();
            if (a.getRole() == 1) {
                List<ThietBi> ltb = dao.getThietBibyIDandAccID1(id, a.getAccountID());
                request.setAttribute("ltb", ltb);
            } else {
                List<ThietBi> ltb = dao.getThietBi(id);
                request.setAttribute("ltb", ltb);
            }

        }
        request.getRequestDispatcher("thietbi.jsp").forward(request, response);
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
    }
}
