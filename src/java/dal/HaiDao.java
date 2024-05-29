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
import model.HoaDon;
import model.HopDong;
import model.Phong;
import model.ThietBi;

/**
 *
 * @author admin
 */
public class HaiDao extends MyDAO {

    public List<Phong> getPhong() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");

                HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return hoaDonList;
    }
//
//    public List<DichVu> getAllDichVu() {
//        List<DichVu> dichVuList = new ArrayList<>();
//        String sql = "SELECT * FROM DichVu"; // Giả sử bảng trong cơ sở dữ liệu là "DichVu"
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int dichVuID = rs.getInt("DichVuID");
//                int soPhong = rs.getInt("SoPhong");
//                String name = rs.getString("Name");
//                int giaTien = rs.getInt("GiaTien");
//                Date tuNgay = rs.getDate("TuNgay");
//                Date denNgay = rs.getDate("DenNgay");
//                int chiSoCu = rs.getInt("ChiSoCu");
//                int chiSoMoi = rs.getInt("ChiSoMoi");
//
//                DichVu dichVu = new DichVu(dichVuID, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
//                dichVuList.add(dichVu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // In ra lỗi nếu có
//        }
//        return dichVuList;
//    }
//
//    public List<DichVu> getDichVuBySoPhong(String soPhong) {
//        List<DichVu> dichVuSearch = new ArrayList<>();
//        String sql = "SELECT * FROM DichVu WHERE SoPhong = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, soPhong);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int dichVuID = rs.getInt("DichVuID");
//                int soPhong1 = rs.getInt("SoPhong");
//                String name = rs.getString("Name");
//                int giaTien = rs.getInt("GiaTien");
//                Date tuNgay = rs.getDate("TuNgay");
//                Date denNgay = rs.getDate("DenNgay");
//                int chiSoCu = rs.getInt("ChiSoCu");
//                int chiSoMoi = rs.getInt("ChiSoMoi");
//
//                DichVu dichVu = new DichVu(dichVuID, soPhong1, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
//                dichVuSearch.add(dichVu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // In ra lỗi nếu có
//        }
//        return dichVuSearch;
//    }
//
//    public DichVu getDichVubyID(String id) {
//        String sql = "select * from DichVu where DichVuID = ?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int dichVuID = rs.getInt("DichVuID");
//                int soPhong = rs.getInt("SoPhong");
//                String name = rs.getString("Name");
//                int giaTien = rs.getInt("GiaTien");
//                Date tuNgay = rs.getDate("TuNgay");
//                Date denNgay = rs.getDate("DenNgay");
//                int chiSoCu = rs.getInt("ChiSoCu");
//                int chiSoMoi = rs.getInt("ChiSoMoi");
//
//                DichVu dichVu = new DichVu(dichVuID, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
//                return dichVu;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    
//   public void editDichVu(String id, int soPhong, String name, int giaTien, Date tuNgay, Date denNgay, int chiSoCu, int chiSoMoi) {
//    String query = "UPDATE DichVu\n"
//                 + "SET SoPhong = ?,\n"
//                 + "    Name = ?,\n"
//                 + "    GiaTien = ?,\n"
//                 + "    TuNgay = ?,\n"
//                 + "    DenNgay = ?,\n"
//                 + "    ChiSoCu = ?,\n"
//                 + "    ChiSoMoi = ?\n"
//                 + "WHERE DichVuID = ?;";
//     try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, soPhong);
//            ps.setString(2, name);
//            ps.setInt(3, giaTien);
//            ps.setDate(4, new java.sql.Date(tuNgay.getTime())); // Convert java.util.Date to java.sql.Date
//            ps.setDate(5, new java.sql.Date(denNgay.getTime())); // Convert java.util.Date to java.sql.Date
//            ps.setInt(6, chiSoCu);
//            ps.setInt(7, chiSoMoi);
//            ps.setString(8, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


public static void main(String[] args) throws SQLException {
    HaiDao dao = new HaiDao();
    Date tuNgay = new Date(2024, 1, 1); // Constructing Date objects, the first parameter is the year minus 1900
    Date denNgay = new Date(2024, 1, 31); // Constructing Date objects, the first parameter is the year minus 1900

//    dao.editDichVu("1", 1, "Nước", 11000, tuNgay, denNgay, 0, 0); // Passing id as String
}

}
