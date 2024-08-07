package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dal.DBContext;

@WebServlet(name = "NewPassword", urlPatterns = {"/newPassword"})
public class NewPassword extends HttpServlet {

   private static final Logger LOGGER = Logger.getLogger(NewPassword.class.getName());
private static final String PASSWORD_REGEX = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*[A-Za-z])(?=.*\\d).{6,}$";

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession();
    String newPassword = request.getParameter("password");
    String confPassword = request.getParameter("confPassword");
    RequestDispatcher dispatcher = null;

    // Validate passwords
    if (newPassword == null || confPassword == null) {
        request.setAttribute("status", "passwordMissing");
        dispatcher = request.getRequestDispatcher("newPassword.jsp");
        dispatcher.forward(request, response);
        return;
    }

    // Check if passwords match
    if (!newPassword.equals(confPassword)) {
        request.setAttribute("status", "passwordMismatch");
        dispatcher = request.getRequestDispatcher("newPassword.jsp");
        dispatcher.forward(request, response);
        return;
    }

    // Validate `newPassword` against PASSWORD_REGEX
    if (!newPassword.matches(PASSWORD_REGEX)) {
        request.setAttribute("status", "invalidPassword");
        dispatcher = request.getRequestDispatcher("newPassword.jsp");
        dispatcher.forward(request, response);
        return;
    }

    try (Connection con = new DBContext().connection;
         PreparedStatement pst = con.prepareStatement("UPDATE accounts SET Password = ? WHERE email = ?")) {
        
        // Ideally, hash the password before storing
        pst.setString(1, newPassword);
        pst.setString(2, (String) session.getAttribute("email"));

        int rowCount = pst.executeUpdate();
        if (rowCount > 0) {
            request.setAttribute("status", "resetSuccess");
            dispatcher = request.getRequestDispatcher("login.jsp");
        } else {
            request.setAttribute("status", "resetFailed");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }
        dispatcher.forward(request, response);
    } catch (SQLException ex) {
        LOGGER.log(Level.SEVERE, "Database error: ", ex);
        request.setAttribute("error", "An error occurred while resetting your password. Please try again.");
        dispatcher = request.getRequestDispatcher("404.jsp");
        dispatcher.forward(request, response);
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
        return "Handles new password setting";
    }
}
