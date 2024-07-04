package controller;

import dal.DAO;
import dal.HaiDao;
import dal.LinhDao;
import dal.SonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import model.DichVu;
import model.DichVuChung;
import model.Khu;


/**
 *
 * @author vulin
 */
@WebServlet(name = "ListDichVuChung", urlPatterns = {"/listdichvuchung"})
public class ListDichVuChung extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        List<DichVuChung> ldvc = null;

        if (a == null) {
            response.sendRedirect("login");
            return;
        }else {
            String dvid = request.getParameter("id");
        
        LinhDao linhDao = new LinhDao();
        SonDAO sonDao = new SonDAO();
        DAO dao = new DAO();

          List<Khu> khu = dao.getKhuByKhuID();
        
        if (a.getRole() == 1) {
            ldvc = sonDao.getAllDichVuChungByAccountID(a.getAccountID());
        } else {
            ldvc = linhDao.getAllDichVuChung();
        }

        request.setAttribute("ldvc", ldvc);
        request.setAttribute("khu", khu);
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