/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
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
import model.HopDong;
import model.KhachThue;
import model.Phong;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "ListNguoiThue", urlPatterns = {"/listNguoiThue"})
public class ListNguoiThue extends HttpServlet {

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
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("login");
            return;
        }

        String id = request.getParameter("lntid");
        request.setAttribute("phongID", id);
        DAO dao = new DAO();
        SonDAO sondao = new SonDAO();

        List<HopDong> hd;
        List<KhachThue> kt;
        HopDong hd1;

        if (a.getRole() == 1) {
            hd = sondao.getHopDong();
            kt = dao.getKhachThueByPhongIDByAccountID(id, a.getAccountID());
            hd1 = sondao.getHopDongByPhongIDandTinhTrang1andAccountID(id, a.getAccountID());
        } else {
            hd = sondao.getHopDong();
            kt = dao.getKhachThueByPhongID(id);
            hd1 = sondao.getHopDongByPhongIDandTinhTrang1(id);
        }
        if (sondao.checkPhongIDcoHopDongConThue(id)) {
            int sokhach = sondao.countKhachThueByPhongID(id);
            request.setAttribute("sokhach", sokhach);
        }
        
        int sokhach1 = sondao.countKhachThueByPhongID(id);
        request.setAttribute("sokhach1", sokhach1);

        request.setAttribute("listHopDong", hd);
        request.setAttribute("listNguoiThue", kt);
        request.setAttribute("listHopDong1", hd1);
        request.getRequestDispatcher("ListKhachThue.jsp").forward(request, response);
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
