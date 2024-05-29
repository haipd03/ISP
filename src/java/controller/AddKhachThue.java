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

@WebServlet(name = "AddKhachThue", urlPatterns = {"/addkhachthue"})

public class AddKhachThue extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String KhachID = request.getParameter("KhachID");
        String HoVaTen = request.getParameter("HoVaTen");
        String CCCD = request.getParameter("CCCD");
        String SDT = request.getParameter("SDT");
        String QueQuan = request.getParameter("QueQuan");
        String TenNguoiThan = request.getParameter("TenNguoiThan");
        String SDTNguoiThan = request.getParameter("SDTNguoiThan");
        String QuanHeVoiNguoiThan = request.getParameter("QuanHeVoiNguoiThan");
        String PhongID = request.getParameter("PhongID");
        String TinhTrang = request.getParameter("TinhTrang");

        SonDAO sondao = new SonDAO();

        sondao.insertkhachthue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
        response.sendRedirect("listNguoiThue?lntid=" + PhongID);
    }

}
