/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import dal.DAO;
import dal.HaiDao;
import dal.LinhDao;
import model.DichVu;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Accounts;
import model.Khu;
/**
 *
 * @author vulin
 */
@WebServlet(name = "EditDichVu", urlPatterns = {"/editdichvu"})
public class EditDichVu extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            // Redirect to login page or show error message if account is not logged in
            response.sendRedirect("login.jsp");
        } else {
            String dvid = request.getParameter("id");
           LinhDao dao = new LinhDao();
            DichVu tb = dao.getDichVubyID(dvid);
            request.setAttribute("detail", tb);
        }
        request.getRequestDispatcher("EditDichVu.jsp").forward(request, response);
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
        return "Edit Dich Vu Servlet";
    }

}

