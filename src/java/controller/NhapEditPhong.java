/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.PhongDAO;
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
import model.Khu;
import model.Phong;

/**
 *
 * @author Admin
 */
@WebServlet(name="NhapEditPhong", urlPatterns={"/nhapeditphong"})
public class NhapEditPhong extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
    String phongIDStr = request.getParameter("phongID");
   
    int phongID = 0;
    try {
        phongID = Integer.parseInt(phongIDStr);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    
    if (a == null || a.getRole() == 1) {
        // Redirect to login page or show error message if account is not logged in
        response.sendRedirect("login.jsp");
    } else {
        PhongDAO phongDAO = new PhongDAO();
        Phong thongtinphong = phongDAO.getPhongByID(phongID); // Truyền phongID vào phương thức getPhongByID()
        List<Phong> loaiPhongList = phongDAO.getAllLoaiPhong();
        List<Phong> phongConTrong = phongDAO.getAllPhongConTrong();
        request.setAttribute("p", thongtinphong);
        request.setAttribute("lp1", loaiPhongList);
        request.setAttribute("lp2", phongConTrong);
        request.getRequestDispatcher("EditThongTinPhong.jsp").forward(request, response);
    }
}
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
    }
}



