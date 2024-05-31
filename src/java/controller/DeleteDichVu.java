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
import java.sql.SQLException;


@WebServlet(name = "DeleteDichVu", urlPatterns = {"/deletedichvu"})
public class DeleteDichVu extends HttpServlet {

    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String dvid = request.getParameter("id");
        if (dvid != null && !dvid.isEmpty()) {
            LinhDao dao = new LinhDao();
            try {
                int dichVuID = Integer.parseInt(dvid);
                dao.deleteDichVu(dichVuID);
                response.sendRedirect("listdichvu"); // Redirect to the list of services after deletion
            } catch (SQLException e) {
                e.printStackTrace();
                // Set error message as request attribute and forward back to list page
                request.setAttribute("error", "Xóa dịch vụ không thành công:Dịch vụ đang liên kết với Hóa Đơn Detail ");
                request.getRequestDispatcher("listdichvu").forward(request, response);
            }
        } else {
            response.sendRedirect("listdichvu"); // Redirect to an error page or handle it accordingly
        }
        
      
    }

    @Override
    public String getServletInfo() {
        return "Delete Dich Vu Servlet";
    }
}
