/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.HaiDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.KhachThue;

/**
 *
 * @author admin
 */
@WebServlet(name="SearchChiTietKhachThue", urlPatterns={"/searchchitietkhachthue"})
public class SearchChiTietKhachThue extends HttpServlet {
   
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
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");

        HaiDao dao = new HaiDao();
        List<KhachThue> ktList;

        List<KhachThue> allKtList = dao.getKhachThue();

        if ((name != null && !name.trim().isEmpty())
                || (CCCD != null && !CCCD.trim().isEmpty())
                || (SDT != null && !SDT.trim().isEmpty())) {
            try {
                ktList = dao.searchKhachThueByCriteria(name, CCCD, SDT);
                if (ktList.isEmpty()) {
                    request.setAttribute("error", "Không tìm thấy khách thuê với các tiêu chí tìm kiếm.");
                    request.setAttribute("listK", allKtList);
                } else {
                    request.setAttribute("listK", ktList);
                }
            } catch (Exception e) {
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
                request.setAttribute("listK", allKtList);
            }
        } else {
            request.setAttribute("listK", allKtList);
            request.setAttribute("error", "Vui lòng nhập ít nhất một tiêu chí tìm kiếm.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("ChiTietKhachThue.jsp");
        dispatcher.include(request, response); 
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
