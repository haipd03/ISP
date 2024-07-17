package controller;

import dal.LanDao;
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
import model.ThietBiChung;

/**
 * Servlet implementation class SearchThietBiChung
 */
@WebServlet(name = "SearchThietBiChung", urlPatterns = {"/searchthietbichung"})
public class SearchThietBiChung extends HttpServlet {

    /**

     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *

     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");
        String ten = request.getParameter("ten");
        String sl = request.getParameter("soLuong");
        String tt = request.getParameter("tinhTrang");
        String gia = request.getParameter("gia");

        LanDao u = new LanDao();
        List<ThietBiChung> stbc = null;
        List<ThietBiChung> stbc1 = null;

        if ((ten != null && !ten.trim().isEmpty())
                || (sl != null && !sl.trim().isEmpty())
                || (tt != null && !tt.trim().isEmpty())
                || (gia != null && !gia.trim().isEmpty())) {

            try {
                if (a.getRole() == 0) {
                    stbc = u.getThietbiChungByCriteria(ten, sl, tt, gia);
                } else {
                    stbc = u.getThietbiChungByCriteria1(ten, sl, tt, gia, a.getAccountID());
                }

                if ((stbc != null && stbc.isEmpty())) {
                    request.setAttribute("error", "Không tìm thấy thiết bị chung với tiêu chí tìm kiếm!");
                } else {
                    if (stbc != null) {
                        request.setAttribute("ltbc", stbc);
                    }
                    if (stbc != null) {
                        request.setAttribute("ltbc", stbc);
                    }
                }
            } catch (Exception e) {
                request.setAttribute("error", "Đã xảy ra lỗi trong quá trình tìm kiếm.");
            }
        } else {
            request.setAttribute("error", "Vui lòng nhập ít nhất một tiêu chí để tìm kiếm.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("ThietBiChung.jsp");
        dispatcher.include(request, response);
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
        return "SearchThietBiChung Servlet";
    }// </editor-fold>
}
