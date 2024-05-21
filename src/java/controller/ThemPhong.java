/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PhongDAO;
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
import model.Phong;

/**
 *
 * @author Admin
 */
public class ThemPhong extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
 
         if (a == null ) {
            // Redirect to login page or show error message if account is not logged in
            response.sendRedirect("login.jsp");
        } else {
      String phongIDString = request.getParameter("PhongID");
        String soPhongString = request.getParameter("SoPhong");
        String khuIDString = request.getParameter("KhuID");
        String loaiPhong = request.getParameter("LoaiPhong");
        String phongConTrongString = request.getParameter("PhongConTrong");
        String giaString = request.getParameter("Gia");

        try {
            int phongID = Integer.parseInt(phongIDString);
            int soPhong = Integer.parseInt(soPhongString);
            int khuID = Integer.parseInt(khuIDString);
            int phongConTrong = Integer.parseInt(phongConTrongString);
            int gia = Integer.parseInt(giaString);

            if (phongID <= 0 || soPhong <= 0 || khuID <= 0 || phongConTrong < 0 || gia < 0) {
                request.setAttribute("message", "Dữ liệu nhập vào không hợp lệ!");
                request.getRequestDispatcher("/nhapaddphong").forward(request, response);
                return;
            }

            PhongDAO phongDAO = new PhongDAO();
            if (phongDAO.isPhongIDExists(phongID) || phongDAO.isSoPhongExists(soPhong)) {
                request.setAttribute("message", "Phòng ID hoặc Số Phòng đã tồn tại trong cơ sở dữ liệu! Vui lòng chọn một Phòng ID hoặc Số Phòng khác.");
                request.getRequestDispatcher("/nhapaddphong").forward(request, response);
                return;
            }

            Phong phong = new Phong(phongID, soPhong, khuID, loaiPhong, phongConTrong, gia);
            List<Phong> phongList = phongDAO.addPhong(phong);

            if (phongList != null && !phongList.isEmpty()) {
                request.setAttribute("success", "Thêm phòng thành công!");
                request.setAttribute("Phong", phong);
                request.getRequestDispatcher("HienThiPhongThem.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Thêm phòng thất bại!");
                request.getRequestDispatcher("/nhapaddphong").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Dữ liệu nhập vào không hợp lệ!");
            request.getRequestDispatcher("/nhapaddphong").forward(request, response);
        }
    }
    }
}
