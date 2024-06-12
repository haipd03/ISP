/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.HaiDao;
import dal.LinhDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DichVu;
/**
 *
 * @author vulin
 */
@WebServlet(name = "EditDV", urlPatterns = {"/editdv"})
public class EditDV extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String dvid = request.getParameter("DichVuID");
        String soPhong = request.getParameter("SoPhong");
        String name = request.getParameter("Name");
        String giaTienStr = request.getParameter("GiaTien");
        String tuNgayStr = request.getParameter("TuNgay");
        String denNgayStr = request.getParameter("DenNgay");
        String chiSoCuStr = request.getParameter("ChiSoCu");
        String chiSoMoiStr = request.getParameter("ChiSoMoi");

        if (dvid != null && soPhong != null && name != null && giaTienStr != null && tuNgayStr != null && denNgayStr != null && chiSoCuStr != null && chiSoMoiStr != null) {
            
            try {
                // Validate giaTien, chiSoCu, chiSoMoi are integers
                int giaTien = Integer.parseInt(giaTienStr);
                int chiSoCu = Integer.parseInt(chiSoCuStr);
                int chiSoMoi = Integer.parseInt(chiSoMoiStr);
                
                // Parse dates
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date tuNgay = dateFormat.parse(tuNgayStr);
                Date denNgay = dateFormat.parse(denNgayStr);

                // Check chiSoCu < chiSoMoi
                if (chiSoCu >= chiSoMoi) {
                    request.setAttribute("error", "Chi số cũ phải nhỏ hơn chi số mới.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvu");
                    dispatcher.forward(request, response);
                    return;
                }

                // Check tuNgay <= denNgay
                if (tuNgay.after(denNgay)) {
                    request.setAttribute("error", "Từ ngày phải nhỏ hơn hoặc bằng đến ngày.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvu");
                    dispatcher.forward(request, response);
                    return;
                }

                // Perform the update
                LinhDao u = new LinhDao();
                u.editDichVu(dvid, soPhong, name, giaTienStr, tuNgay, denNgay, chiSoCuStr, chiSoMoiStr);
                
                // Set success message
                request.setAttribute("success", "Đã sửa Dịch Vụ thành công!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvu");
                dispatcher.forward(request, response);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("error", "Sửa dịch vụ không thành công! Vui lòng nhập đúng dữ liệu");
                request.getRequestDispatcher("listdichvu").forward(request, response);
            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute("error", "Định dạng ngày không hợp lệ.");
                request.getRequestDispatcher("listdichvu").forward(request, response);
            }
        } else {
            response.sendRedirect("listdichvu"); // Redirect to an error page or handle it accordingly
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("error", "Định dạng ngày không hợp lệ.");
            request.getRequestDispatcher("listdichvu").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("error", "Định dạng ngày không hợp lệ.");
            request.getRequestDispatcher("listdichvu").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}