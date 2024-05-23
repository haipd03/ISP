package controller;

import dal.DAO;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="MyAccount", urlPatterns={"/myaccount"})
public class MyAccount extends HttpServlet {

    // Regex pattern for validating email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accountID = request.getParameter("accountID");
        String hoVaTen = request.getParameter("hoVaTen");
        String cccdStr = request.getParameter("CCCD");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");

        // Validate email format
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            // Email is invalid, set an error message and return
            request.setAttribute("errorMessage", "Invalid email format.");
            request.getRequestDispatcher("loadmyaccount?id=" + accountID).forward(request, response);
            return;
        }

        int cccd;
        try {
            cccd = Integer.parseInt(cccdStr);
        } catch (NumberFormatException e) {
            // Handle invalid CCCD format
            request.setAttribute("errorMessage", "Invalid CCCD format.");
            request.getRequestDispatcher("loadmyaccount?id=" + accountID).forward(request, response);
            return;
        }

        DAO dao = new DAO();
        dao.editMyAccount(accountID, hoVaTen, email, cccd, diaChi);

        response.sendRedirect("loadmyaccount?id=" + accountID);
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
        return "Handles account updates";
    }
}
