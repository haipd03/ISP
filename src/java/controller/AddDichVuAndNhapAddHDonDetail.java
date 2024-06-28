/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author THANH SON
 */
@WebServlet(name = "AddDichVuAndNhapAddHDonDetail", urlPatterns = {"/adddichvuandnhapaddhdondetail"})
public class AddDichVuAndNhapAddHDonDetail extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("id");
        String dvid = request.getParameter("DichVuID");
        String PhongID = request.getParameter("PhongID");
        String name = request.getParameter("Name");
        String giaTien = request.getParameter("GiaTien");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String chiSoCu = request.getParameter("ChiSoCu");
        String chiSoMoi = request.getParameter("ChiSoMoi");

        String errorMsg = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (PhongID == null || !PhongID.matches("\\d+")) {
            errorMsg = "Bạn Không Thể Thêm Dịch Vụ!";
        } else if (giaTien == null || !giaTien.matches("\\d+")) {
            errorMsg = "Giá tiền không hợp lệ.";
        } else if (chiSoCu == null || !chiSoCu.matches("\\d+")) {
            errorMsg = "Chỉ số cũ không hợp lệ.";
        } else if (chiSoMoi == null || !chiSoMoi.matches("\\d+")) {
            errorMsg = "Chỉ số mới không hợp lệ.";
        } else if (Integer.parseInt(chiSoCu) >= Integer.parseInt(chiSoMoi)) {
            errorMsg = "Chỉ số cũ phải nhỏ hơn chỉ số mới.";
        } else {
            try {
                Date dateNgayThue = dateFormat.parse(tuNgay);
                Date dateNgayTra = dateFormat.parse(denNgay);
                if (!dateNgayTra.after(dateNgayThue)) {
                    errorMsg = "Ngày tính tiền dịch vụ không đúng!";
                }
            } catch (ParseException e) {
                errorMsg = "Định dạng ngày không hợp lệ.";
            }
        }
        SonDAO sondao = new SonDAO();
        if (errorMsg != null) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("nhapadddichvu").forward(request, response);
        } else {
            sondao.insertDichVu(dvid, PhongID, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
            response.sendRedirect("nhapaddhoadondetail?pid=" + pid + "&dvid=" + dvid);
        }
    }

}
