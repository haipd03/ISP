/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.HaiDao;
import dal.LinhDao;
import jakarta.servlet.RequestDispatcher;
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
import model.DichVu;
import model.DichVuChung;
import model.Khu;

/**
 *
 * @author vulin
 */
@WebServlet(name = "SearchDichVuChung", urlPatterns = {"/searchdichvuchung"})
public class SearchDichVuChung extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }else {
            String dvid = request.getParameter("id");

        String dichVuChungName = request.getParameter("dichVuChungName");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String giaStr = request.getParameter("gia");
        String tuNgay = request.getParameter("tuNgay");
        String denNgay = request.getParameter("denNgay");
        String tinhTrang = request.getParameter("tinhTrang");
        String khuIDStr = request.getParameter("khuID");

        Integer gia = null;
        if (giaStr != null && !giaStr.trim().isEmpty()) {
            try {
                gia = Integer.parseInt(giaStr);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Giá tiền phải là số nguyên.");
            }
        }

        Integer khuID = null;
        if (khuIDStr != null && !khuIDStr.trim().isEmpty()) {
            try {
                khuID = Integer.parseInt(khuIDStr);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Khu ID phải là số nguyên.");
            }
        }

        LinhDao linhDao = new LinhDao();
        List<DichVuChung> ldvc;
       DAO dao = new DAO();

          List<Khu> khu = dao.getKhuByKhuID();

        try {
            ldvc = linhDao.getDichVuChungByCriteria(dichVuChungName, ten, sdt, gia, tuNgay, denNgay, tinhTrang, a.getAccountID(), a.getRole(), khuID);
            if (ldvc.isEmpty()) {
                request.setAttribute("error", "Không tìm thấy dịch vụ với tiêu chí tìm kiếm!");
            }
            request.setAttribute("khu", khu);
            request.setAttribute("ldvc", ldvc);
        } catch (Exception e) {
            request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
        }

        request.getRequestDispatcher("DichVuChung.jsp").forward(request, response);
    }
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
        return "Short description";
    }
}
