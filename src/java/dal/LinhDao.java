/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DichVu;
import model.Phong;

/*
 *
 * @author vulin
 */
public class LinhDao extends MyDAO {

    public List<DichVu> getAllDichVu() {
        List<DichVu> dichVuList = new ArrayList<>();
        String sql = "SELECT * FROM DichVu"; // Giả sử bảng trong cơ sở dữ liệu là "DichVu"
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int soPhong = rs.getInt("SoPhong");
                String name = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");

                DichVu dichVu = new DichVu(dichVuID, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
                dichVuList.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return dichVuList;
    }

    public List<DichVu> getDichVuBySoPhong(String soPhong) {
        List<DichVu> dichVuSearch = new ArrayList<>();
        String sql = "SELECT * FROM DichVu WHERE SoPhong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int soPhong1 = rs.getInt("SoPhong");
                String name = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");

                DichVu dichVu = new DichVu(dichVuID, soPhong1, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
                dichVuSearch.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return dichVuSearch;
    }

    public DichVu getDichVubyID(String id) {
        String sql = "select * from DichVu where DichVuID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int soPhong = rs.getInt("SoPhong");
                String name = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");

                DichVu dichVu = new DichVu(dichVuID, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
                return dichVu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editDichVu(String id, int soPhong, String name, int giaTien, Date tuNgay, Date denNgay, int chiSoCu, int chiSoMoi) {
        String query = "UPDATE DichVu\n"
                + "SET SoPhong = ?,\n"
                + "    Name = ?,\n"
                + "    GiaTien = ?,\n"
                + "    TuNgay = ?,\n"
                + "    DenNgay = ?,\n"
                + "    ChiSoCu = ?,\n"
                + "    ChiSoMoi = ?\n"
                + "WHERE DichVuID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, soPhong);
            ps.setString(2, name);
            ps.setInt(3, giaTien);
            ps.setDate(4, new java.sql.Date(tuNgay.getTime())); // Convert java.util.Date to java.sql.Date
            ps.setDate(5, new java.sql.Date(denNgay.getTime())); // Convert java.util.Date to java.sql.Date
            ps.setInt(6, chiSoCu);
            ps.setInt(7, chiSoMoi);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDichVu(String dvid, String phongid, String name, String giaTien, String tuNgay, String denNgay, String chiSoCu, String chiSoMoi) {
        String sql = "INSERT INTO DichVu (DichVuID, SoPhong, Name, GiaTien, TuNgay, DenNgay, ChiSoCu, ChiSoMoi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dvid);
            ps.setString(2, phongid);
            ps.setString(3, name);
            ps.setString(4, giaTien);
            ps.setString(5, tuNgay);
            ps.setString(6, denNgay);
            ps.setString(7, chiSoCu);
            ps.setString(8, chiSoMoi);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void deleteDichVu(int dichVuID) throws SQLException {
    String sql = "DELETE FROM DichVu WHERE dichVuID = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, dichVuID);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deleting dich vu failed, no rows affected.");
        }
    } catch (SQLException e) {
        throw new SQLException("Error deleting dich vu: " + e.getMessage(), e);
    }
}


    public static void main(String[] args) throws SQLException {
        LinhDao u = new LinhDao();
        Date tuNgay = new Date(2024, 1, 1); // Constructing Date objects, the first parameter is the year minus 1900
        Date denNgay = new Date(2024, 1, 31); // Constructing Date objects, the first parameter is the year minus 1900

        u.editDichVu("1", 1, "Nước", 11000, tuNgay, denNgay, 0, 0); // Passing id as String
    }
}
