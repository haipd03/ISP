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
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null ) {
            response.sendRedirect("login.jsp");
        } else {
            String phongIDStr = request.getParameter("phongID");
            String soPhongStr = request.getParameter("soPhong");
            String khuIDStr = request.getParameter("khuID");
            String loaiPhong = request.getParameter("loaiPhong");
            String phongConTrongStr = request.getParameter("phongConTrong");
            String ghiChu = request.getParameter("ghiChu");
            String giaStr = request.getParameter("gia");

            try {
                int phongID = Integer.parseInt(phongIDStr);
                int soPhong = Integer.parseInt(soPhongStr);
                int khuID = Integer.parseInt(khuIDStr);
                int phongConTrong = Integer.parseInt(phongConTrongStr);

                if (phongConTrong == 0 && !ghiChu.equals("Tốt")) {
                    request.setAttribute("message", "Phòng Còn đang có khách không thể vô hiệu hóa!");
                    request.getRequestDispatcher("/nhapeditphong").forward(request, response);
                    return;
                }

                int gia = Integer.parseInt(giaStr);
                if (gia <= 0) {
                    request.setAttribute("message", "Giá không được bằng hay nhỏ hơn 0!");
                    request.getRequestDispatcher("/nhapeditphong").forward(request, response);
                    return;
                }

                Phong phong = new Phong(phongID, soPhong, khuID, loaiPhong, phongConTrong, ghiChu, gia);
                PhongDAO phongDAO = new PhongDAO();
                
                if (phongDAO.checkPhongIDcoTinTrangHopDong(phongID)) {
                    request.setAttribute("message", "Không thể cập nhật vì phòng có hợp đồng có khách đang thuê!");
                    request.getRequestDispatcher("/nhapeditphong").forward(request, response);
                } else {
                    List<Phong> updatedPhongList = phongDAO.updatePhong(phong);
                    request.setAttribute("message", "Cập nhật phòng thành công!");
                    request.setAttribute("phong", phong);
                    request.getRequestDispatcher("HienThiEditPhong.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Dữ liệu nhập vào không hợp lệ!");
                request.getRequestDispatcher("/nhapeditphong").forward(request, response);
            }
        }
    }
}

