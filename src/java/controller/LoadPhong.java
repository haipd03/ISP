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
import java.util.ArrayList;
import java.util.List;
import model.Accounts;

@WebServlet(name = "LoadPhong", urlPatterns = {"/loadphong"})
public class LoadPhong extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            String PhongIDParam = request.getParameter("PhongID");
            PhongDAO phongDAO = new PhongDAO();
            int PhongID = 0;
            if (PhongIDParam != null) {
                try {
                    PhongID = Integer.parseInt(PhongIDParam);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (a.getRole() == 1) {
                    List<Phong> danhSachPhong = phongDAO.getPhongByKhuByAccountID(PhongID, a.getAccountID());
                    request.setAttribute("danhSachPhong", danhSachPhong);
                } else {
                    List<Phong> danhSachPhong = phongDAO.getPhongByPhongID(PhongID);
                    Integer userRole = (Integer) session.getAttribute("userRole");
                    request.setAttribute("userRole", userRole);
                    request.setAttribute("danhSachPhong", danhSachPhong);
                }
                request.getRequestDispatcher("HienThiThongTinPhong.jsp").forward(request, response);
            }
        }

    }

}
