package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.BaseColor;
import dal.HaiDao;
import dal.LanDao;
import model.HoaDon;
import model.KhachThue;

@WebServlet(name = "GeneratePDFHoaDon", urlPatterns = {"/generatePDFhoadon"})
public class GeneratePDFHoaDon extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        HaiDao dao = new HaiDao();
        LanDao ldao = new LanDao();
        HoaDon hoaDon = dao.getHoaDonById(id);
        KhachThue kt = ldao.getKhachThueByHoaDonID(id);

        if (hoaDon != null) {
            // Set the content type to PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=hoadon-" + id + ".pdf");

            try {
                // Create a new PDF document
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
                document.open();

                // Load the UTF-8 font
                BaseFont baseFont = BaseFont.createFont(
                        getServletContext().getRealPath("/WEB-INF/fonts/DejaVuSans.ttf"),
                        BaseFont.IDENTITY_H,
                        BaseFont.EMBEDDED
                );
                com.itextpdf.text.Font utf8Font = new com.itextpdf.text.Font(baseFont, 12);
                com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(baseFont, 18, com.itextpdf.text.Font.BOLD);
                com.itextpdf.text.Font headerFont = new com.itextpdf.text.Font(baseFont, 12, com.itextpdf.text.Font.BOLDITALIC);
                com.itextpdf.text.Font contentFont = new com.itextpdf.text.Font(baseFont, 12);

                // Title of the PDF
                Paragraph title = new Paragraph("Hóa Đơn", titleFont);
                title.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(title);

                // Add a line break
                document.add(new Paragraph("\n"));

                // Header of the PDF
                Paragraph header = new Paragraph("Thông tin hóa đơn", headerFont);
                header.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(header);

                // Add a line break
                document.add(new Paragraph("\n"));

                // Create a table for the invoice details
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);
                float[] columnWidths = {0.4f, 0.6f};
                table.setWidths(columnWidths);

                PdfPCell cell1 = new PdfPCell(new Phrase("Mã hóa đơn:", contentFont));
                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell1.setPadding(10f);
                table.addCell(cell1);

                PdfPCell cell2 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getHoaDonID()), utf8Font));
                cell2.setPadding(10f);
                table.addCell(cell2);

                PdfPCell cell3 = new PdfPCell(new Phrase("Tên khách thuê:", contentFont));
                cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell3.setPadding(10f);
                table.addCell(cell3);

                PdfPCell cell4 = new PdfPCell(new Phrase(kt.getHoVaTen(), utf8Font));
                cell4.setPadding(10f);
                table.addCell(cell4);

                PdfPCell cell5 = new PdfPCell(new Phrase("Mã hợp đồng:", contentFont));
                cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell5.setPadding(10f);
                table.addCell(cell5);

                PdfPCell cell6 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getHopDongID()), utf8Font));
                cell6.setPadding(10f);
                table.addCell(cell6);

                PdfPCell cell7 = new PdfPCell(new Phrase("Ngày thanh toán:", contentFont));
                cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell7.setPadding(10f);
                table.addCell(cell7);

                PdfPCell cell8 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getNgayThanhToan()), utf8Font));
                cell8.setPadding(10f);
                table.addCell(cell8);

                PdfPCell cell9 = new PdfPCell(new Phrase("Tình trạng:", contentFont));
                cell9.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell9.setPadding(10f);
                table.addCell(cell9);

                PdfPCell cell10 = new PdfPCell(new Phrase(hoaDon.getTinhTrangThanhToan(), utf8Font));
                cell10.setPadding(10f);
                table.addCell(cell10);

                PdfPCell cell11 = new PdfPCell(new Phrase("Từ ngày:", contentFont));
                cell11.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell11.setPadding(10f);
                table.addCell(cell11);

                PdfPCell cell12 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getTuNgay()), utf8Font));
                cell12.setPadding(10f);
                table.addCell(cell12);

                PdfPCell cell13 = new PdfPCell(new Phrase("Đến ngày:", contentFont));
                cell13.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell13.setPadding(10f);
                table.addCell(cell13);

                PdfPCell cell14 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getDenNgay()), utf8Font));
                cell14.setPadding(10f);
                table.addCell(cell14);

                PdfPCell cell15 = new PdfPCell(new Phrase("Tổng tiền:", contentFont));
                cell15.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell15.setPadding(10f);
                table.addCell(cell15);

                PdfPCell cell16 = new PdfPCell(new Phrase(String.valueOf(hoaDon.getTongTien()), utf8Font));
                cell16.setPadding(10f);
                table.addCell(cell16);

                document.add(table);

                // Add a line break
                document.add(new Paragraph("\n"));

                // Footer of the PDF
                Paragraph footer = new Paragraph("Cảm ơn quý khách!", headerFont);
                footer.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(footer);

                // Close the document
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "HoaDon not found");
        }
    }
}