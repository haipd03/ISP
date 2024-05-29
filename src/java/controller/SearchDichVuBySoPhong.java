/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.HaiDao;
import dal.LinhDao;
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
import model.DichVu;
/**
 *
 * @author vulin
 */
@WebServlet(name = "SearchDichVuBySoPhong", urlPatterns = {"/searchdichvubysophong"})
public class SearchDichVuBySoPhong extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    String soPhongStr = request.getParameter("soPhong"); // Lấy tham số từ trường input
    LinhDao dao = new LinhDao();
    List<DichVu> sdv;
    
    // Thiết lập danh sách dịch vụ ban đầu
    List<DichVu> ldv = dao.getAllDichVu();
    request.setAttribute("ldv", ldv);
    
    if (soPhongStr != null && !soPhongStr.trim().isEmpty()) {
        try {
            sdv = dao.getDichVuBySoPhong(soPhongStr); // Truyền chuỗi soPhongStr vào thay vì biến soPhong
            request.setAttribute("ldv", sdv); // Cập nhật ldv thành kết quả tìm kiếm
        } catch (NumberFormatException e) {
            // Xử lý nếu số phòng không hợp lệ
            request.setAttribute("error", "Số phòng phải là số nguyên.");
        }
    }
    
    request.getRequestDispatcher("DichVu.jsp").forward(request, response); // Chuyển hướng sang trang JSP để hiển thị kết quả
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
