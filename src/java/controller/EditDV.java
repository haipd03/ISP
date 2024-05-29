/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.HaiDao;
import dal.LinhDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    String dvid = request.getParameter("DichVuID");
    int dvsoPhong = Integer.parseInt(request.getParameter("SoPhong"));
    String dvname = request.getParameter("Name");
    int dvgiaTien = Integer.parseInt(request.getParameter("GiaTien"));
    Date dvtuNgay = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("TuNgay"));
    Date dvdenNgay = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DenNgay"));
    int dvchiSoCu = Integer.parseInt(request.getParameter("ChiSoCu"));
    int dvchiSoMoi = Integer.parseInt(request.getParameter("ChiSoMoi"));

    LinhDao u = new LinhDao();
    u.editDichVu(dvid, dvsoPhong, dvname, dvgiaTien, dvtuNgay, dvdenNgay, dvchiSoCu, dvchiSoMoi);
    response.sendRedirect("listdichvu");
}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
