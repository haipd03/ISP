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

@WebServlet(name = "AddDichVuChung", urlPatterns = {"/adddichvuchung"})
public class AddDichVuChung extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String dvid = request.getParameter("DichVuChungID");
        String khuID = request.getParameter("KhuID");
        String dichVuChungName = request.getParameter("DichVuChungName");
        String ten = request.getParameter("Ten");
        String sdt = request.getParameter("Sdt");
        String gia = request.getParameter("Gia");
        String tuNgay = request.getParameter("TuNgay");
        String denNgay = request.getParameter("DenNgay");
        String tinhTrang = request.getParameter("TinhTrang");
        String ghiChu = request.getParameter("GhiChu");

        LinhDao dao = new LinhDao();
        String numericPattern = "^[0-9]+$";
        String datePattern = "\\d{4}-\\d{2}-\\d{2}";

//        if (!dvid.matches(numericPattern) || !khuID.matches(numericPattern) 
//                || !tuNgay.matches(datePattern) || !denNgay.matches(datePattern)) {
//            request.setAttribute("errorMessage", "Dữ liệu nhập vào không hợp lệ!");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvuchung");
//            dispatcher.forward(request, response);
//            return;
//        }

        if (!gia.matches(numericPattern)) {
            request.setAttribute("errorMessage", "Giá nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvuchung");
            dispatcher.forward(request, response);
            return;
        }
        
        if (!sdt.matches(numericPattern)) {
            request.setAttribute("errorMessage", "Số điện thoại nhập vào không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvuchung");
            dispatcher.forward(request, response);
            return;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date tuNgayDate = dateFormat.parse(tuNgay);
            Date denNgayDate = dateFormat.parse(denNgay);
            if (tuNgayDate.after(denNgayDate)) {
                request.setAttribute("errorMessage", "Từ ngày phải nhỏ hơn hoặc bằng đến ngày!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvuchung");
                dispatcher.forward(request, response);
                return;
            }

            dao.insertDichVuChung(dvid, khuID, dichVuChungName, ten, sdt, gia, tuNgay, denNgay, tinhTrang, ghiChu);

            request.getSession().setAttribute("success", "Đã Thêm Dịch Vụ thành công!");
            response.sendRedirect("listdichvuchung?id=" + dvid);

        } catch (NumberFormatException | ParseException e) {
            request.setAttribute("errorMessage", "Lỗi định dạng dữ liệu!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("insertdichvuchung");
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
