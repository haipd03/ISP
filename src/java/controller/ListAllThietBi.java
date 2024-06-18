/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.PhongDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Accounts;
import model.ThietBi;
import model.Phong;
import model.Khu;

@WebServlet(name = "ListAllThietBi", urlPatterns = {"/ListAllThietBi"})
public class ListAllThietBi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListAllThietBi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAllThietBi at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        } else {
            DAO dao = new DAO();
            List<Accounts> acc = dao.getAccounts();
            String pageStr = request.getParameter("page");
            int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
            int pageSize = 15;
            int offset = (page - 1) * pageSize;

            List<ThietBi> ltb = dao.getAllThietBi(offset, pageSize);

            int totalRecords = dao.getTotalThietBiCount();
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

            List<Khu> listK = dao.getKhuByKhuID();
            List<Phong> listP = dao.getPhong();

            request.setAttribute("listK", listK);
            request.setAttribute("listP", listP);
            request.setAttribute("ltb", ltb);
            request.setAttribute("listK3", acc);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);
            request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Accounts a = (Accounts) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        } else {
            DAO dao = new DAO();
            PhongDAO p = new PhongDAO();
            List<Accounts> acc = dao.getAccounts();
            List<Khu> listK = dao.getKhuByKhuID();
            List<Phong> listP = dao.getPhong();

            String accountIDParam = request.getParameter("accountID");
            String khuIDParam = request.getParameter("khuID");
            String phongIDParam = request.getParameter("phongID");
            String name = request.getParameter("name");
            String tinhTrang = request.getParameter("tinhTrang");
            String giaParam = request.getParameter("gia");
            String soPhongParam = request.getParameter("soPhong");

            int accountID = (accountIDParam != null && !accountIDParam.isEmpty()) ? Integer.parseInt(accountIDParam) : 0;
            int khuID = (khuIDParam != null && !khuIDParam.isEmpty()) ? Integer.parseInt(khuIDParam) : 0;
            int phongID = 0;

            if (soPhongParam != null && !soPhongParam.isEmpty()) {
                try {
                    int soPhong = Integer.parseInt(soPhongParam);
                    List<Phong> phongs;

                    if (a.getRole() == 0) {
                        phongs = p.getPhongBySoPhong(soPhong);
                    } else {
                        phongs = p.getPhongBySoPhongByAccount(soPhong, a.getAccountID());
                    }

                    if (!phongs.isEmpty()) {
                        phongID = phongs.get(0).getPhongID();
                    } else {
                        request.setAttribute("listK3", acc);
                    request.setAttribute("listK", listK);
                    request.setAttribute("listP", listP);
                        request.setAttribute("error", "Không tìm thấy phòng!");
                        request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
                        return;
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("listK3", acc);
                    request.setAttribute("listK", listK);
                    request.setAttribute("listP", listP);
                    request.setAttribute("error", "Vui lòng nhập lại số phòng hợp lệ!");
                    request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
                    return;
                }
            }

            int gia = 0;
            if (giaParam != null && !giaParam.isEmpty()) {
                try {
                    gia = Integer.parseInt(giaParam);
                } catch (NumberFormatException e) {
                    request.setAttribute("listK3", acc);
                    request.setAttribute("listK", listK);
                    request.setAttribute("listP", listP);
                    request.setAttribute("error", "Vui lòng nhập lại giá thiết bị!");
                    request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
                    return;
                }
            }
//            String pageStr = request.getParameter("page");
//            int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
//            int pageSize = 15;
//            int offset = (page - 1) * pageSize;
            List<ThietBi> ltb = dao.searchListThietBi(accountID, khuID, phongID, name, tinhTrang, gia);
//            int totalRecords1 = dao.getTotalThietBiCount1();
//            int totalPages = (int) Math.ceil((double) totalRecords1 / pageSize);

            if (ltb.isEmpty()) {
                request.setAttribute("listK3", acc);
                    request.setAttribute("listK", listK);
                    request.setAttribute("listP", listP);
                request.setAttribute("error", "Không tìm thấy thiết bị nào theo yêu cầu!");
                request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);

                return;
            }
            request.setAttribute("listK3", acc);
            request.setAttribute("listK", listK);
            request.setAttribute("listP", listP);
            request.setAttribute("ltb", ltb);

//            request.setAttribute("currentPage", page);
//            request.setAttribute("totalPages", totalPages);
            request.getRequestDispatcher("ListThietBi.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}