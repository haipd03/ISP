/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.LinhDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Phong;
import model.ThietBi;


/**
 *
 * @author vulin
 */
@WebServlet(name = "AddDichVu", urlPatterns = {"/adddichvu"})
public class AddDichVu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String dvid = request.getParameter("DichVuID");
        String phongid = request.getParameter("SoPhong");
        String name = request.getParameter("Name");
        String giaTien = request.getParameter("GiaTien");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String chiSoCu = request.getParameter("ChiSoCu");
        String chiSoMoi = request.getParameter("ChiSoMoi");

        LinhDao dao = new LinhDao();
        String giaTienPattern = "^[0-9]+$";
        String datePattern = "\\d{4}-\\d{2}-\\d{2}";

        if (!giaTien.matches(giaTienPattern) || !tuNgay.matches(datePattern) || !denNgay.matches(datePattern) 
                || !chiSoCu.matches(giaTienPattern) || !chiSoMoi.matches(giaTienPattern)) {
            request.setAttribute("errorMessage", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddDichVu.jsp");
            dispatcher.forward(request, response);
        } else {
            dao.insertDichVu(dvid, phongid, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
            response.sendRedirect("listdichvu?id=" + dvid);
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
        return "Add Dich Vu Servlet";
    }
}
