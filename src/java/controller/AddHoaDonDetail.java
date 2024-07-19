/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.SonDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import model.DichVu;
import model.HoaDon;
import model.HoaDonDetail;
import model.Phong;

/**
 *
 * @author Ngoc Lan
 */
@WebServlet(name = "AddHoaDonDetail", urlPatterns = {"/addhoadondetail"})
public class AddHoaDonDetail extends HttpServlet {

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
    String hddid = request.getParameter("HoaDonDetailID");
    String hdid = request.getParameter("HoaDonID");
    String tn = request.getParameter("TuNgay");
    String dn = request.getParameter("DenNgay");
    int hs1 = Integer.parseInt(request.getParameter("HeSo"));
    String dvid = request.getParameter("DichVuID");

    String errorMsg = null;
    if (tn == null || tn.trim().isEmpty() || dn == null || dn.trim().isEmpty()) {
        errorMsg = "Bạn Không Thể Thêm Hóa Đơn Chi Tiết!";
    }
    if (dvid == null || dvid.trim().isEmpty()) {
        errorMsg = "Dịch Vụ ID không được để trống!";
    }

    if (errorMsg != null) {
        request.setAttribute("error", errorMsg);
        request.getRequestDispatcher("listhoadondetail?id=" + hdid).forward(request, response);
    } else {
        DAO dao = new DAO();
        SonDAO sondao = new SonDAO();

        try {
            DichVu listdvu = sondao.getDichVubyID(dvid);
            if (listdvu == null) {
                throw new Exception("Không tìm thấy dịch vụ với ID: " + dvid);
            }

            Phong listphong = sondao.getPhongByHoaDonID(hdid);

            int giaTien = listdvu.getGiaTien();
            int chiSoCu = listdvu.getChiSoCu();
            int chiSoMoi = listdvu.getChiSoMoi();
            int giaPhong = listphong.getGia();

            int tongSo = chiSoMoi - chiSoCu;

            int thanhTien = tongSo * hs1 * giaTien;

            String ts = String.valueOf(tongSo);
            String hs = String.valueOf(hs1);
            String tt = String.valueOf(thanhTien);

            dao.insertHoaDonDetail(hddid, hdid, tn, dn, ts, hs, tt, dvid);

            HoaDon listhdon1 = sondao.getHoaDonByHoaDonID(hdid);

            int hdonid = listhdon1.getHoaDonID();
            int hdongid = listhdon1.getHopDongID();
            Date NgayThanhToan = listhdon1.getNgayThanhToan();
            String tttt = listhdon1.getTinhTrangThanhToan();
            Date TuNgay = listhdon1.getTuNgay();
            Date DenNgay = listhdon1.getDenNgay();

            List<HoaDonDetail> listhdondetail = sondao.getHoaDonDetail(String.valueOf(hdonid));

            int TongTien = giaPhong;
            for (HoaDonDetail detail : listhdondetail) {
                TongTien += detail.getThanhTien();
            }

            HoaDon hoadon = new HoaDon(hdonid, hdongid, NgayThanhToan, tttt, TuNgay, DenNgay, TongTien);
            sondao.updateHoaDon(hoadon);

            response.sendRedirect("listhoadondetail?id=" + hdid);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Không thể thêm dịch vụ: " + e.getMessage());
            request.getRequestDispatcher("listhoadondetail?id=" + hdid).forward(request, response);
        }
    }
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
        return "Short description";
    }// </editor-fold>

}
