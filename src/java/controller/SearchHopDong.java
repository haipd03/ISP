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
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Accounts;
import model.HopDong;

/**
 *
 * @author admin
 */
@WebServlet(name = "SearchHopDong", urlPatterns = {"/searchhopdong"})
public class SearchHopDong extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        String soKhachThueStr = request.getParameter("sokhachthue");
        String name = request.getParameter("hovaten");
        String ngaythueStr = request.getParameter("ngaythue");
        String ngaytraStr = request.getParameter("ngaytra");

        HaiDao dao = new HaiDao();
        List<HopDong> hopDongList;
        List<HopDong> hopDongList1;
        // Fetch all HopDong records initially

        if ((soKhachThueStr != null && !soKhachThueStr.trim().isEmpty())
                || (name != null && !name.trim().isEmpty())
                || (ngaythueStr != null && !ngaythueStr.trim().isEmpty())
                || (ngaytraStr != null && !ngaytraStr.trim().isEmpty())) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date tuNgay = null;
                Date denNgay = null;

                if (ngaythueStr != null && !ngaythueStr.trim().isEmpty()) {
                    tuNgay = sdf.parse(ngaythueStr);
                }
                if (ngaytraStr != null && !ngaytraStr.trim().isEmpty()) {
                    denNgay = sdf.parse(ngaytraStr);
                }
                hopDongList = dao.getHopDongByCriteria(soKhachThueStr, name, tuNgay, denNgay);
                hopDongList1 = dao.getHopDongByCriteria1(soKhachThueStr, name, tuNgay, tuNgay, a.getAccountID());
                if (hopDongList.isEmpty() && hopDongList1.isEmpty()) {
                    request.setAttribute("error", "Không tìm thấy hợp đồng với tiêu chí tìm kiếm!");

                } else {
                    request.setAttribute("listK", hopDongList);
                    request.setAttribute("listK1", hopDongList1);
                }
            } catch (ParseException e) {
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");

            }
        } else {

            request.setAttribute("error", "Vui lòng nhập ít nhất một tiêu chí để tìm kiếm.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("HopDong.jsp");
        dispatcher.include(request, response); // Forward to JSP page to display the results
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SearchHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SearchHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
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
