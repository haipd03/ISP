package controller;

import dal.PhongDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Phong;

@WebServlet(name = "DeletePhong", urlPatterns = {"/deletePhong"})
public class deletePhong extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy số phòng từ request
        int phongID = Integer.parseInt(request.getParameter("phongID"));
        
        // Kiểm tra phòng còn trống hay không
        PhongDAO phongDAO = new PhongDAO();
        List<Phong> phongs = phongDAO.getPhongByPhongID(phongID);
        if (phongs.size() > 0) {
            Phong phong = phongs.get(0);
            if (phong.getPhongConTrong() == 1) {
                // Nếu phòng trống, thực hiện xóa
                phongDAO.deletePhongByPhongID(phongID);
                
                // Đặt thuộc tính để thông báo xóa thành công trên trang Thông Tin Phòng
                request.setAttribute("deleted", true);
            }
        }
        
        // Sau khi xóa, chuyển hướng lại trang danh sách phòng
        response.sendRedirect(request.getContextPath() + "/listphong");
    }
}
