/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import model.DichVu;
import model.HoaDon;
import model.HoaDonDetail;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "ListHoaDonPhong", urlPatterns = {"/listhoadonphong"})
public class ListHoaDonPhong extends HttpServlet {

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

        if (a == null ) {
            response.sendRedirect("login.jsp");
        } else {
            String id = request.getParameter("id");
            SonDAO sondao = new SonDAO();

            HoaDon listhdon = sondao.getIDByHoaDonIDByPhongIDAndAccountID(id, a.getAccountID());
            List<DichVu> listdv = new ArrayList<>();
            List<HoaDonDetail> hdd = new ArrayList<>();
            if (listhdon != null) {
                listdv = sondao.getDichVubyhdonID(listhdon.getHoaDonID());
                hdd = sondao.getHoaDonDetailByDVuID(listhdon.getHoaDonID());
            }

            HoaDon listhdon1 = sondao.getIDByHoaDonIDByPhong(id);
            List<DichVu> listdv1 = new ArrayList<>();
            List<HoaDonDetail> hdd1 = new ArrayList<>();
            if (listhdon1 != null) {
                listdv1 = sondao.getDichVubyhdonID(listhdon1.getHoaDonID());
                hdd1 = sondao.getHoaDonDetailByDVuID(listhdon1.getHoaDonID());
            }

            request.setAttribute("listhdon", listhdon);
            request.setAttribute("listhdon", listhdon1);
            request.setAttribute("phongid", id);
            request.setAttribute("listdv", listdv);
            request.setAttribute("hdd", hdd);
            request.setAttribute("listdv", listdv1);
            request.setAttribute("hdd", hdd1);

            request.getRequestDispatcher("ListHoaDonPhong.jsp").forward(request, response);
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
