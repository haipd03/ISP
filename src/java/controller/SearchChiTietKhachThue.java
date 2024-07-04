
package controller;

import dal.HaiDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Accounts;
import model.KhachThue;

@WebServlet(name="SearchChiTietKhachThue", urlPatterns={"/searchchitietkhachthue"})
public class SearchChiTietKhachThue extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        String name = request.getParameter("name");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");

        HaiDao dao = new HaiDao();
        List<KhachThue> ktList;
          List<KhachThue> ktList1;

        if ((name != null && !name.trim().isEmpty())
                || (CCCD != null && !CCCD.trim().isEmpty())
                || (SDT != null && !SDT.trim().isEmpty())) {
            try {
                ktList = dao.searchKhachThueByCriteria(name, SDT, CCCD);
                ktList1 = dao.searchKhachThueByCriteria1(a.getAccountID(), name, SDT, CCCD);
                if (ktList.isEmpty() && ktList1.isEmpty()) {
                    request.setAttribute("error", "Không tìm thấy khách thuê với tiêu chí tìm kiếm.");
                } else {
                    request.setAttribute("listK", ktList); // Update ktList with search results
                    request.setAttribute("listK1", ktList1); // Update ktList with search results
                }
            } catch (Exception e) {
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
            }
        } 

        RequestDispatcher dispatcher = request.getRequestDispatcher("ChiTietKhachThue.jsp");
        dispatcher.include(request, response); 

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
