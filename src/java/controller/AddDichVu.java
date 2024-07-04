package controller;

import dal.DAO;
import dal.LinhDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddDichVu", urlPatterns = {"/adddichvu"})
public class AddDichVu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String dvid = request.getParameter("DichVuID");
        String phongID = request.getParameter("PhongID");
        String name = request.getParameter("Name");
        String giaTien = request.getParameter("GiaTien");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String chiSoCu = request.getParameter("ChiSoCu");
        String chiSoMoi = request.getParameter("ChiSoMoi");

        LinhDao dao = new LinhDao();
        String giaTienPattern = "^[0-9]+$";
        String datePattern = "\\d{4}-\\d{2}-\\d{2}";


        if (!dvid.matches(giaTienPattern) || !phongID.matches(giaTienPattern) || !giaTien.matches(giaTienPattern) || !tuNgay.matches(datePattern) || !denNgay.matches(datePattern)
                || !chiSoCu.matches(giaTienPattern) || !chiSoMoi.matches(giaTienPattern)) {
            request.setAttribute("errorMessage", "Dữ liệu nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvu");

            dispatcher.forward(request, response);
            return;
        }

        try {
            int chiSoCuInt = Integer.parseInt(chiSoCu);
            int chiSoMoiInt = Integer.parseInt(chiSoMoi);
            if (chiSoCuInt >= chiSoMoiInt) {
                request.setAttribute("error", "Thêm dịch dịch vụ không thành công! Chi số cũ phải nhỏ hơn chi số mới!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvu");
                dispatcher.forward(request, response);
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date tuNgayDate = dateFormat.parse(tuNgay);
            Date denNgayDate = dateFormat.parse(denNgay);
            if (tuNgayDate.after(denNgayDate)) {
                request.setAttribute("error", "Thêm dịch dịch vụ không thành công! Từ ngày phải nhỏ hơn hoặc bằng đến ngày!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvu");
                dispatcher.forward(request, response);
                return;
            }


            dao.insertDichVu(dvid, phongID, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);


            request.getSession().setAttribute("success", "Đã Thêm Dịch Vụ thành công!");
            response.sendRedirect("listdichvu?id=" + dvid);

        } catch (NumberFormatException | ParseException e) {
            request.setAttribute("errorMessage", "Lỗi định dạng dữ liệu!");

            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvu");

            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
