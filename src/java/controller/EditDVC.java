package controller;

import dal.LinhDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditDVC", urlPatterns = {"/editdvc"})
public class EditDVC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String dvcIDStr = request.getParameter("DichVuChungID");
        String khuIDStr = request.getParameter("KhuID");
        String dichVuChungName = request.getParameter("DichVuChungName");
        String ten = request.getParameter("Ten");
        String sdt = request.getParameter("Sdt");
        String giaTienStr = request.getParameter("Gia");
        String tuNgayStr = request.getParameter("TuNgay");
        String denNgayStr = request.getParameter("DenNgay");
        String tinhTrang = request.getParameter("TinhTrang");
        String ghiChu = request.getParameter("GhiChu");

        if (dvcIDStr != null && khuIDStr != null && dichVuChungName != null && ten != null && sdt != null && giaTienStr != null && tuNgayStr != null && denNgayStr != null && tinhTrang != null && ghiChu != null) {
            try {
                // Parse integers
                int dvcID = Integer.parseInt(dvcIDStr);
                int khuID = Integer.parseInt(khuIDStr);
                int giaTien = Integer.parseInt(giaTienStr);

                // Parse dates
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date tuNgay = dateFormat.parse(tuNgayStr);
                Date denNgay = dateFormat.parse(denNgayStr);

                // Validate data as needed
                if (tuNgay.after(denNgay)) {
                    request.setAttribute("error", "Sửa dịch dịch vụ không thành công! Từ ngày phải nhỏ hơn hoặc bằng đến ngày.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvuchung");
                    dispatcher.forward(request, response);
                    return;
                }
                // Perform the update
                LinhDao dao = new LinhDao();
                dao.editDichVuChung(dvcID, khuID, dichVuChungName, ten, sdt, giaTien, tuNgay, denNgay, tinhTrang, ghiChu);

                // Set success message
                request.setAttribute("success", "Đã sửa Dịch Vụ chung thành công!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvuchung");
                dispatcher.forward(request, response);

            } catch (NumberFormatException | ParseException e) {
                e.printStackTrace();
                request.setAttribute("error", "Sửa dịch vụ chung không thành công! Vui lòng nhập đúng dữ liệu.");
                request.getRequestDispatcher("listdichvuchung").forward(request, response);
            }
        } else {
            response.sendRedirect("listdichvuchung"); // Redirect to an error page or handle it accordingly
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
            request.getRequestDispatcher("listdichvuchung").forward(request, response);
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
            request.getRequestDispatcher("listdichvuchung").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "EditDVC Servlet";
    }
}
