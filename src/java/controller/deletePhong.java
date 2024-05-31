package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


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
@WebServlet(urlPatterns={"/deletePhong"})
public class deletePhong extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            int phongID = Integer.parseInt(request.getParameter("phongID"));
            PhongDAO phongDAO = new PhongDAO();
            if (phongDAO.checkPhongIDcoThietBi(phongID) ) {
                List<Phong> phongs = phongDAO.getPhongByPhongID(phongID);
                request.setAttribute("error", "Phòng đang có thiết bị không thể xóa phòng!");
                request.setAttribute("danhSachPhong", phongs);
                request.getRequestDispatcher("HienThiThongTinPhong.jsp").forward(request, response);
            } else {
                List<Phong> phongs = phongDAO.getPhongByPhongID(phongID);
                if (phongs.size() > 0) {
                    Phong phong = phongs.get(0);
                    if (phong.getPhongConTrong() == 1) {
                        phongDAO.deletePhongByPhongID(phongID);
                        request.setAttribute("deleted", true);
                    }
                }
            }if (phongDAO.checkPhongIDcoHopDong(phongID) && phongDAO.checkPhongIDcoTinTrangHopDong(phongID)) {
                List<Phong> phongs = phongDAO.getPhongByPhongID(phongID);
                request.setAttribute("error", "Phòng đang có thiết bị không thể xóa phòng hợp đồng của khách còn hiệu lực!");
                request.setAttribute("danhSachPhong", phongs);
                request.getRequestDispatcher("HienThiThongTinPhong.jsp").forward(request, response);
            }
        }
        response.sendRedirect(request.getContextPath() + "/listphong");
    }
}
