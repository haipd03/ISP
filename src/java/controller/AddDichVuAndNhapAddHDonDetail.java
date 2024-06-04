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
        String soPhong = request.getParameter("SoPhong");
        String name = request.getParameter("Name");
        String giaTien = request.getParameter("GiaTien");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String chiSoCu = request.getParameter("ChiSoCu");
        String chiSoMoi = request.getParameter("ChiSoMoi");
        
        SonDAO sondao = new SonDAO();
        sondao.insertDichVu(dvid, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
        
        response.sendRedirect("nhapaddhoadondetail?pid=" + pid + "&dvid=" + dvid );
    }
    
}
