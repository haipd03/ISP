/*
         * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
         * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Accounts;

/**
 *
 * @author admin
 */
@WebServlet(name = "EditAccount", urlPatterns = {"/editaccount"})
public class EditAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String GMAIL_REGEX = "^[A-Z0-9a-z._%+-]+@gmail\\.com$";
    private static final String PASSWORD_REGEX = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*[A-Za-z])(?=.*\\d).{6,}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int accountID = Integer.parseInt(request.getParameter("AccountID"));
        String taiKhoan = request.getParameter("TaiKhoan");
        String password = request.getParameter("Password");
        String roleParam = request.getParameter("Role");
        String hoVaTen = request.getParameter("HoVaTen");
        String email = request.getParameter("Email");
        String cccd = request.getParameter("CCCD");
        String diaChi = request.getParameter("DiaChi");

        int role;
        try {
            role = Integer.parseInt(roleParam);
            if (role != 1 && role != 2) {
                throw new NumberFormatException("Invalid role value");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Role must be 1 or 2");
            request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, 0, hoVaTen, email, cccd, diaChi)); // Maintain input data
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            return;
        }

        // Validate `taiKhoan`
        if (taiKhoan == null || taiKhoan.length() < 6) {
            request.setAttribute("errorMessage", "TaiKhoan phải dài ít nhất 6 ký tự.");
            request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi));
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            return;
        }

        // Validate `password`
        Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (password == null || password.length() < 6 || !passwordMatcher.matches()) {
            request.setAttribute("errorMessage", "Mật khẩu cần ít nhất 6 ký tự ,chứa ít nhất một ký tự đặc biệt, một ký tự chữ cái, một ký tự số");
            request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi));
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            return;
        }

        // Validate `email`
        Pattern pattern = Pattern.compile(GMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            request.setAttribute("errorMessage", "Invalid Gmail format. Email must end with '@gmail.com'.");
            request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi));
            request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
            return;
        }

        Accounts account = new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi);
        DAO dao = new DAO();
        try {
            dao.updateAccount(account);
        } catch (SQLException ex) {
            Logger.getLogger(EditAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listaccount");
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
