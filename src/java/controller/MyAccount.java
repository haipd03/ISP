package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="MyAccount", urlPatterns={"/myaccount"})
public class MyAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accountID = request.getParameter("accountID");
        String hoVaTen = request.getParameter("hoVaTen");
        String email = request.getParameter("email");
        String cccdStr = request.getParameter("CCCD");
        String diaChi = request.getParameter("diaChi");

        int cccd = Integer.parseInt(cccdStr);

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
