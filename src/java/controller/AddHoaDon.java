/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.HaiDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddHoaDon", urlPatterns = {"/addhoadon"})
public class AddHoaDon extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String hoaDonID = request.getParameter("HoaDonID");
        String hopDongID = request.getParameter("HopDongID");
        String tinhTrangThanhToan = request.getParameter("TinhTrangThanhToan");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String tongTien = request.getParameter("TongTien");

        HaiDao dao = new HaiDao(); // Initialize your DAO

       

        // Inside your processRequest method
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        Date toDate = null;
        try {
            fromDate = sdf.parse(tuNgay);
            toDate = sdf.parse(denNgay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

// Create a new HoaDon object with parsed dates
        HoaDon hoaDon = new HoaDon(Integer.parseInt(hoaDonID), Integer.parseInt(hopDongID),
                tinhTrangThanhToan, fromDate, toDate,
                Integer.parseInt(tongTien));

        // Add the HoaDon to the database
        dao.addHoaDon(hoaDon);

        // Redirect to the listhoadon page
        response.sendRedirect("listhoadon");

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
