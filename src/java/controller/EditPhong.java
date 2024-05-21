package controller;

import dal.PhongDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Phong;
import java.util.List;
import model.Accounts;

@WebServlet(name = "EditPhong", urlPatterns = {"/editPhong"})
public class EditPhong extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
 
         if (a == null ) {
            // Redirect to login page or show error message if account is not logged in
            response.sendRedirect("login.jsp");
        } else {
        // Lấy thông tin phòng từ request
        String phongIDStr = request.getParameter("phongID");
        String soPhongStr = request.getParameter("soPhong");
        String khuIDStr = request.getParameter("khuID");
        String loaiPhong = request.getParameter("loaiPhong");
        String phongConTrongStr = request.getParameter("phongConTrong");
        String giaStr = request.getParameter("gia");

        // Kiểm tra và chuyển đổi các giá trị đầu vào
        try {
            int phongID = Integer.parseInt(phongIDStr);
            int soPhong = Integer.parseInt(soPhongStr);
            int khuID = Integer.parseInt(khuIDStr);

            if (loaiPhong == null || loaiPhong.trim().isEmpty()) {
                request.setAttribute("message", "Loại Phòng không được để trống!");
                request.getRequestDispatcher("editPhong.jsp").forward(request, response);
                return;
            } else {
                loaiPhong = loaiPhong.trim();  
            }

            int phongConTrong = Integer.parseInt(phongConTrongStr);
            if (phongConTrong < 0) {
                request.setAttribute("message", "Phòng Còn Trống không được nhỏ hơn 0!");
                request.getRequestDispatcher("/nhapeditphong").forward(request, response);
                return;
            }

            int gia = Integer.parseInt(giaStr);
            if (gia < 0) {
                request.setAttribute("message", "Giá không được nhỏ hơn 0!");
                request.getRequestDispatcher("/nhapeditphong").forward(request, response);
                return;
            }

            // Tạo đối tượng Phong mới với thông tin vừa nhận được
            Phong phong = new Phong(phongID, soPhong, khuID, loaiPhong, phongConTrong, gia);

            // Cập nhật thông tin phòng trong cơ sở dữ liệu
            PhongDAO phongDAO = new PhongDAO();
            List<Phong> updatedPhongList = phongDAO.updatePhong(phong);

            // Kiểm tra kết quả cập nhật
            if (updatedPhongList != null) {
                // Chuyển hướng đến trang jsp để hiển thị thông tin phòng vừa cập nhật 
                request.setAttribute("message", "Cập nhật phòng thành công!");
                request.setAttribute("phong", phong);
               
                request.getRequestDispatcher("HienThiEditPhong.jsp").forward(request, response);
            } else {
                // Xử lý lỗi và chuyển hướng người dùng đến trang thông báo lỗi
                request.setAttribute("message", "Cập nhật phòng thất bại!");
                request.getRequestDispatcher("/nhapeditphong").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Dữ liệu nhập vào không hợp lệ!");
            request.getRequestDispatcher("/nhapeditphong").forward(request, response);
        }
    }
   }
}
