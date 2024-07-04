package controller;

import dal.LinhDao;
import dal.SonDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Accounts;
import model.DichVuChung;

/**
 *
 * Servlet implementation class EditDichVuChung
 */
@WebServlet(name = "EditDichVuChung", urlPatterns = {"/editdichvuchung"})
public class EditDichVuChung extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            // Redirect to login page or show error message if account is not logged in
            response.sendRedirect("login.jsp");
        } else {
            String dvcID = request.getParameter("id");
            SonDAO dao = new SonDAO();
            DichVuChung dvc = dao.getDichVuChungByID(dvcID, a.getAccountID());
            request.setAttribute("detail", dvc);
        }
        request.getRequestDispatcher("EditDichVuChung.jsp").forward(request, response);
    }

}
