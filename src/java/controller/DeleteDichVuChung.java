package controller;

import dal.LinhDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(name = "DeleteDichVuChung", urlPatterns = {"/deletedichvuchung"})
public class DeleteDichVuChung extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dvid = request.getParameter("id");
        if (dvid != null && !dvid.isEmpty()) {
            LinhDao dao = new LinhDao();
            try {
                int dichVuID = Integer.parseInt(dvid);
                dao.deleteDichVuChung(dichVuID); // Gọi phương thức xóa dịch vụ chung từ lớp DAO/LinhDao
                response.sendRedirect("listdichvuchung"); // Chuyển hướng về danh sách dịch vụ sau khi xóa thành công
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý lỗi và chuyển hướng về trang danh sách dịch vụ
                request.setAttribute("errorMessage", "Xóa dịch vụ không thành công: " + e.getMessage());
                request.getRequestDispatcher("listdichvuchung").forward(request, response);
            }
        } else {
            response.sendRedirect("listdichvuchung"); // Xử lý nếu không có ID hoặc ID rỗng
        }
    }

    @Override
    public String getServletInfo() {
        return "Delete Dich Vu Chung Servlet";
    }
}
