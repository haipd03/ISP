/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.PhongDAO;
import dal.SonDAO;
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

@WebServlet(name = "NhapAddPhong", urlPatterns = {"/nhapaddphong"})
public class NhapAddPhong extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null || a.getRole() == 1) {
            response.sendRedirect("login.jsp");
        } else {
            PhongDAO phongDAO = new PhongDAO();
            SonDAO sondao = new SonDAO();
            
            List<Phong> loaiPhongList = phongDAO.getAllLoaiPhong();
            List<Phong> ghiChuList1 = phongDAO.getAllGhiChu();
            List<Khu> khuIDList = phongDAO.getAllKhuID();
            int nextPhongID = sondao.getNextPhongID();
            
            request.setAttribute("lp1", loaiPhongList);
            request.setAttribute("lp2", khuIDList);
            request.setAttribute("lp3", ghiChuList1);
            request.setAttribute("nextPhongID", nextPhongID);
            
            request.getRequestDispatcher("NhapAddPhong.jsp").forward(request, response);
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


