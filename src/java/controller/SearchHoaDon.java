package controller;

import dal.HaiDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Accounts;
import model.HoaDon;

@WebServlet(name = "SearchHoaDon", urlPatterns = {"/searchhoadon"})
public class SearchHoaDon extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        String soPhongStr = request.getParameter("soPhong");
        String tinhTrangThanhToan = request.getParameter("tinhTrangThanhToan");
        String tuNgayStr = request.getParameter("tuNgay");
        String denNgayStr = request.getParameter("denNgay");

        HaiDao dao = new HaiDao();
        List<HaiDao.HoaDonWithSoPhong> lhd = null; // Sửa đổi kiểu danh sách để khớp với kết quả trả về của phương thức
        if ((soPhongStr != null && !soPhongStr.trim().isEmpty())
                || (tinhTrangThanhToan != null && !tinhTrangThanhToan.trim().isEmpty())
                || (tuNgayStr != null && !tuNgayStr.trim().isEmpty())
                || (denNgayStr != null && !denNgayStr.trim().isEmpty())) {

            try {
                if (a.getRole() == 1) {
                    lhd = dao.getHoaDonByCriteria1(soPhongStr, tinhTrangThanhToan, tuNgayStr, denNgayStr, a.getAccountID());
                } else {
                    lhd = dao.getHoaDonByCriteria(soPhongStr, tinhTrangThanhToan, tuNgayStr, denNgayStr); // Gọi đúng phương thức
                }
                if (lhd == null || lhd.isEmpty()) {
                    request.setAttribute("error", "Không tìm thấy hóa đơn với tiêu chí tìm kiếm!");
                } else {
                    request.setAttribute("lhd", lhd); // Đặt thuộc tính với danh sách HoaDonWithSoPhong
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
            }
        } else {
            request.setAttribute("lhd", lhd); // Gán lại danh sách dịch vụ ban đầu
            request.setAttribute("error", "Vui lòng nhập ít nhất một tiêu chí để tìm kiếm.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("HoaDon.jsp");
        dispatcher.forward(request, response);  // Chuyển hướng tới trang JSP
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SearchHoaDon Servlet";
    }
}
