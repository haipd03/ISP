/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Ngoc Lan
 */
@WebServlet(name = "EditTB", urlPatterns = {"/edittb"})
public class EditTB extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String tbid = request.getParameter("ThietBiID");
        String tbpid = request.getParameter("PhongID");
        String tbname = request.getParameter("Name");
        String tbsoluong = request.getParameter("Soluong");
        String tbtinhtrang = request.getParameter("TinhTrang");
        String tbgia = request.getParameter("Gia");

        DAO dao = new DAO();

        String SoLuongPattern = "^[0-9]+$";
        String GiaPattern = "^[0-9]+$";

        if (!tbsoluong.matches(SoLuongPattern) || !tbgia.matches(GiaPattern)) {
            request.setAttribute("error", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("listthietbi?id=" + tbpid);
            dispatcher.forward(request, response);
        } else {
//            if (dao.checkExistingThietBiID(tbid)) {
//                request.setAttribute("error", "Đã tồn tại ThietBiID trong cơ sở dữ liệu! Vui lòng chọn ThietBiID khác!");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("listthietbi?id=" + tbpid);
//                dispatcher.forward(request, response);
//            } else {
                dao.editThietBi(tbid, tbname, tbsoluong, tbtinhtrang, tbgia);
//            }
            response.sendRedirect("listthietbi?id=" + tbpid);
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
