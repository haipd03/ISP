package controller;

import dal.PhongDAO;
import model.Phong;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadPhong", urlPatterns = {"/loadphong"})
public class LoadPhong extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soPhongParam = request.getParameter("soPhong");

        int soPhong = 0;
        if (soPhongParam != null) {
            try {
                soPhong = Integer.parseInt(soPhongParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle the error according to your requirement
            }
        }

        // Call PhongDAO to get the list of rooms based on soPhong
        PhongDAO phongDAO = new PhongDAO();
        List<Phong> danhSachPhong = phongDAO.getPhongBySoPhong(soPhong);
         HttpSession session = request.getSession();
        Integer userRole = (Integer) session.getAttribute("userRole");
        request.setAttribute("userRole", userRole);
        // Forward the list of rooms as an attribute to pass to JSP
        request.setAttribute("danhSachPhong", danhSachPhong);

        // Forward to the JSP to display the list of rooms
        request.getRequestDispatcher("HienThiThongTinPhong.jsp").forward(request, response);
    }
}
