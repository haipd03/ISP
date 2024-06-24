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
import model.Khu;
import model.Phong;

/**
 *
 * @author vulin
 */
@WebServlet(name="Search", urlPatterns={"/search"})
public class Search extends HttpServlet {

    

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt"); // Ensure this matches the input field's name attribute
//        if (txtSearch == null || txtSearch.trim().isEmpty()) {       
//            response.sendRedirect("index.jsp");
//            return;
//        }
        DAO dao = new DAO();
        List<Phong> ltr = dao.searchbySoPhong(txtSearch); // Pass the search text to the search method
        List<Khu> lk = dao.getKhu2();   //edit
        List<Phong> bp = dao.getPhongForLoaiPhong();
        List<Phong> btt = dao.getPhongForTinhTrang();
        List<Phong> ba = dao.getPhongForGia();
        if (ltr == null || ltr.isEmpty()) {
            response.sendRedirect("404.jsp");
            return;
        }
 
        request.setAttribute("lp", ltr);
        request.setAttribute("lk", lk); //edit
        request.setAttribute("bp", bp);
        request.setAttribute("btt", btt);
        request.setAttribute("ba", ba);

        request.getRequestDispatcher("index.jsp").forward(request, response);
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