/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.RequestDao;
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
import model.Request;

@WebServlet(name = "UpdateRequest", urlPatterns = {"/UpdateRequest"})
public class UpdateRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bạn chưa đăng nhập.");
            return;
        }
        String requestIDStr = request.getParameter("requestID");
        String tinhTrang = request.getParameter("tinhTrang");
        String phanHoi = request.getParameter("phanHoi");
        try {
            int requestID = Integer.parseInt(requestIDStr);
            RequestDao dao = new RequestDao();
            dao.updateTinhTrangPhanHoi(requestID, tinhTrang, phanHoi);
            request.setAttribute("phanHoi", phanHoi);
            request.setAttribute("message3", "Tin Nhắn Đã Được Phản Hồi Thành Công!");
            request.getRequestDispatcher("ListRequest").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Request ID không hợp lệ.");
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
