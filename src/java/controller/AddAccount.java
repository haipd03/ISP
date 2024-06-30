package controller;

import dal.DAO;
import java.io.IOException;
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
 * Servlet implementation class AddAccount
 */
@WebServlet(name = "AddAccount", urlPatterns = {"/addacc"})
public class AddAccount extends HttpServlet {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idParameter = request.getParameter("ID");
        int accountID;
        try {
            accountID = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            // Handle the case where the ID parameter is not a valid integer
            request.setAttribute("errorMessage", "Invalid account ID format.");
            request.getRequestDispatcher("listaccount").forward(request, response);
            return;
        }

        String taiKhoan = request.getParameter("taikhoan");
        String password = request.getParameter("password");
        int role = 1; // Assuming role is set to 1 for all new accounts
        String hoVaTen = request.getParameter("hovaten");
        String email = request.getParameter("email");
        String cccd = request.getParameter("cccd");
        String diaChi = request.getParameter("diachi");

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            // Email is invalid, set an error message and return
            request.setAttribute("errorMessage", "Invalid email format.");
            request.getRequestDispatcher("listaccount").forward(request, response);
            return;
        }

        try {
            DAO dao = new DAO();

            // Check if AccountID already exists
            Accounts existingAccountByID = dao.getAccountsByID(accountID);
            if (existingAccountByID != null) {
                request.setAttribute("errorMessage", "Account ID already exists");
                request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi)); // Maintain input data
                request.getRequestDispatcher("listaccount").forward(request, response);
                return;
            }

            // Check if TaiKhoan already exists
            Accounts existingAccountByTaiKhoan = dao.getAccountByTaiKhoan(taiKhoan);
            if (existingAccountByTaiKhoan != null) {
                request.setAttribute("errorMessage", "Account username already exists");
                request.setAttribute("listA", new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi)); // Maintain input data
                request.getRequestDispatcher("listaccount").forward(request, response);
                return;
            }

            // Create and add new account
            Accounts account = new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi);
            dao.addAccount(account);
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("listaccount");
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
