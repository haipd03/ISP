package controller;

import dal.HaiDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.KhachThue;

@WebServlet(name="SearchChiTietKhachThue", urlPatterns={"/searchchitietkhachthue"})
public class SearchChiTietKhachThue extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");

        HaiDao dao = new HaiDao();
        List<KhachThue> ktList;

        // Fetch all KhachThue initially
        List<KhachThue> allKtList = dao.getKhachThue();

        if ((name != null && !name.trim().isEmpty())
                || (CCCD != null && !CCCD.trim().isEmpty())
                || (SDT != null && !SDT.trim().isEmpty())) {
            try {
                ktList = dao.searchKhachThueByCriteria(name, SDT, CCCD);
                if (ktList.isEmpty()) {
                    request.setAttribute("error", "Không tìm thấy khách thuê với tiêu chí tìm kiếm.");
                    request.setAttribute("listK", allKtList); // Reassign initial list
                } else {
                    request.setAttribute("listK", ktList); // Update ktList with search results
                }
            } catch (Exception e) {
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
                request.setAttribute("listK", allKtList); // Reassign initial list
            }
        } else {
            request.setAttribute("listK", allKtList); // Reassign initial list
            request.setAttribute("error", "Vui lòng nhập ít nhất một tiêu chí tìm kiếm.");
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