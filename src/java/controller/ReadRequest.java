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

/**
 *
 * @author Admin
 */
@WebServlet(name = "ReadRequest", urlPatterns = {"/ReadRequest"})
public class ReadRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }

        String accountIDStr = request.getParameter("accountID");
        String accountNhanStr = request.getParameter("accountNhan");
        String title = request.getParameter("title");
        String requestText = request.getParameter("requestText");
        String tinhTrang = request.getParameter("tinhTrang");

        if (accountIDStr == null || accountIDStr.isEmpty()
                || accountNhanStr == null || accountNhanStr.isEmpty()
                || title == null || title.isEmpty()
                || requestText == null || requestText.isEmpty()
                || tinhTrang == null || tinhTrang.isEmpty()) {
            request.setAttribute("Message", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("NhapRequest.jsp").forward(request, response);
            return;
        }else{

        try {
            int accountID = Integer.parseInt(accountIDStr);
            int accountNhan = Integer.parseInt(accountNhanStr);

            DAO dao = new DAO();
            List<Accounts> acc = dao.getAccounts();
            Request newRequest = new Request(accountID, title, requestText, tinhTrang, accountNhan);
            RequestDao requestDao = new RequestDao();
            requestDao.addRequest(accountID, title, requestText, tinhTrang, accountNhan);
             request.setAttribute("listK3", acc);
            request.setAttribute("title", title);
        request.setAttribute("requestText", requestText);
        request.setAttribute("tinhTrang", tinhTrang);
        request.setAttribute("accountNhan", accountNhan);
        request.setAttribute("Message1", "Tin Nhắn Đã Được Gửi Thành Công!");
        request.getRequestDispatcher("ReadRequest.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Message", "Đã có lỗi xảy ra. Vui lòng thử lại.");
            request.getRequestDispatcher("NhapRequest.jsp").forward(request, response);
        }
        // Forward to the JSP page
        
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
