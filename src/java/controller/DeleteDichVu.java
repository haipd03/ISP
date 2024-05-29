/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.LinhDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ThietBi;
/**
 *
 * @author vulin
 */
@WebServlet(name = "DeleteDichVu", urlPatterns = {"/deletedichvu"})
public class DeleteDichVu extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int dichVuID = Integer.parseInt(request.getParameter("id"));
    LinhDao dao = new LinhDao();
    try {
        dao.deleteDichVu(dichVuID);
        response.sendRedirect("dichvulist"); // Redirect to the list page
    } catch (Exception e) {
        request.setAttribute("error", "Xóa dịch vụ thất bại: " + e.getMessage());
        request.getRequestDispatcher("dichvulist.jsp").forward(request, response); // Forward to the JSP
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>aaaaaaaaaaaaaaaaaaaa


}
