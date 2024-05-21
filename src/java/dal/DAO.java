/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import model.Phong;
import model.ThietBi;

/**
 *
 * @author admin
 */
public class DAO extends MyDAO {

    public List<Phong> getPhong() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong "; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                // Tạo đối tượng Truyen từ thông tin lấy được
                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                // Thêm đối tượng Truyen vào danh sách truyens
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<Phong> getPhong1() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong Where KhuID= 1"; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                // Tạo đối tượng Truyen từ thông tin lấy được
                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                // Thêm đối tượng Truyen vào danh sách truyens
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<Phong> getPhong2() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong Where KhuID= 2"; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                // Tạo đối tượng Truyen từ thông tin lấy được
                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                // Thêm đối tượng Truyen vào danh sách truyens
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<ThietBi> getThietBi(String id) {
        List<ThietBi> ThietBi = new ArrayList<>();
        String sql = "select * from ThietBi where PhongID = ? "; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int ThietBiID = rs.getInt("ThietBiID");
                int PhongID = rs.getInt("PhongID");
                String Name = rs.getString("Name");
                int SoLuong = rs.getInt("SoLuong");
                String TinhTrang = rs.getString("TinhTrang");
                int Gia = rs.getInt("Gia");

                // Tạo đối tượng Truyen từ thông tin lấy được
                ThietBi thietbi = new ThietBi(ThietBiID, PhongID, Name, SoLuong, TinhTrang, Gia);
                // Thêm đối tượng Truyen vào danh sách truyens
                ThietBi.add(thietbi);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return ThietBi;
    }

    public ThietBi getThietBibyID(String id) {
        String sql = "select * from ThietBi where ThietBiID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int thietbiId = rs.getInt("ThietBiID");
                int phongId = rs.getInt("Phongid");
                String name = rs.getString("Name");
                int songLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                // Assuming Truyen is your custom class
                ThietBi thietbi = new ThietBi(thietbiId, phongId, name, songLuong, tinhTrang, gia);
                return thietbi;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThietBi getThietBibyIDandAccID(String id, int aid) {
        String sql = "SELECT Tb.* \n"
                + "FROM ThietBi Tb\n"
                + "JOIN Phong P ON P.PhongID = Tb.PhongID\n"
                + "JOIN Khu K ON K.KhuID = P.KhuID \n"
                + "JOIN Accounts a ON a.AccountID = k.AccountID \n"
                + "WHERE Tb.ThietBiID = ? and a.AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, aid);
            rs = ps.executeQuery();
            if (rs.next()) {
                int thietbiId = rs.getInt("ThietBiID");
                int phongId = rs.getInt("Phongid");
                String name = rs.getString("Name");
                int songLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                // Assuming Truyen is your custom class
                ThietBi thietbi = new ThietBi(thietbiId, phongId, name, songLuong, tinhTrang, gia);
                return thietbi;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public ThietBi getThietBibypID(String id) {
        String sql = "select * from ThietBi\n"
                + "where PhongID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int thietbiId = rs.getInt("ThietBiID");
                int phongId = rs.getInt("Phongid");
                String name = rs.getString("Name");
                int songLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                // Assuming Truyen is your custom class
                ThietBi thietbi = new ThietBi(thietbiId, phongId, name, songLuong, tinhTrang, gia);
                return thietbi;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<Phong> getPhongByID(String tbid) {
//        String query = "select distinct PhongID\n"
//                + "from ThietBi\n"
//                + "where PhongID = ?";
//        try {
//            ps = con.prepareStatement(query);
//            ps.setString(1, tbid);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int phongId = rs.getInt("Phongid");
//                Phong phong = new Phong();
//                return phong;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    
    public List<ThietBi> getPhongByID(String tbid) {
        List<ThietBi> ThietBis = new ArrayList<>();
        String sql = "select distinct PhongID\n"
                + "from ThietBi\n"
                + "where PhongID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tbid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                ThietBi thietBi = new ThietBi(PhongID);
                ThietBis.add(thietBi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ThietBis;
    }

    public void editThietBi(String id, String name, String soluong, String tinhtrang, String gia) {
        String query = "UPDATE ThietBi\n"
                + "SET Name = ?,\n"
                + "    SoLuong = ?,\n"
                + "    TinhTrang = ?,\n"
                + "    Gia = ?\n"
                + "WHERE ThietBiID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, soluong);
            ps.setString(3, tinhtrang);
            ps.setString(4, gia);
            ps.setString(5, id);  // Use the correct parameter index
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public void deleteThietBi(String tbid) {
        String query = "delete from ThietBi where ThietBiID = ?";
        try (
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tbid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertThietBi(String tbid, String tbpid, String tbname, String tbsoluong, String tbtinhtrang, String tbgia) {
        String query = "INSERT INTO [dbo].[ThietBi] ([ThietBiID],[PhongID],[Name],[SoLuong],[TinhTrang],[Gia]) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tbid);
            ps.setString(2, tbpid);
            ps.setString(3, tbname);
            ps.setString(4, tbsoluong);
            ps.setString(5, tbtinhtrang);
            ps.setString(6, tbgia);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public List<ThietBi> getThietBibyIDandAccID1(String id, int aid) {
List<ThietBi> ThietBis = new ArrayList<>();
        String sql = "SELECT Tb.* \n"
                + "FROM ThietBi Tb\n"
                + "JOIN Phong P ON P.PhongID = Tb.PhongID\n"
                + "JOIN Khu K ON K.KhuID = P.KhuID \n"
                + "JOIN Accounts a ON a.AccountID = k.AccountID \n"
                + "WHERE Tb.PhongID = ? and a.AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int thietbiId = rs.getInt("ThietBiID");
                int phongId = rs.getInt("Phongid");
                String name = rs.getString("Name");
                int songLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                // Assuming Truyen is your custom class
                ThietBi thietbi = new ThietBi(thietbiId, phongId, name, songLuong, tinhTrang, gia);
                ThietBis.add(thietbi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ThietBis;
    }

    public Accounts login(String username, String password) {
        String query = "SELECT * FROM Accounts WHERE TaiKhoan = ? AND Password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Accounts(
                        rs.getInt("AccountID"),
                        rs.getString("TaiKhoan"),
                        rs.getString("Password"),
                        rs.getInt("Role"),
                        rs.getString("HoVaTen"),
                        rs.getString("Email"),
                        rs.getInt("CCCD"),
                        rs.getString("DiaChi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

    }
}
