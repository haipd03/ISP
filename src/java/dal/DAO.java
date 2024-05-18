/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import model.KhachThue;
import model.Khu;
import model.Phong;

/**
 *
 * @author admin
 */
public class DAO extends MyDAO {

    private Connection con;
    private List<KhachThue> kt;
    private String status = "ok";

    public List<KhachThue> getKt() {
        return kt;
    }

    public void setKt(List<KhachThue> kt) {
        this.kt = kt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DAO() {
        con = new DBContext().connection;
    }

    public List<Phong> getPhong() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong"; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
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

    public List<KhachThue> getKhachThue(String id) {
        List<KhachThue> KhachThues = new ArrayList<>();
        String sql = "Select * from khachthue k where k.PhongID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int KhachID = rs.getInt("KhachID");
                String HoVaTen = rs.getString("HoVaTen");
                String CCCD = rs.getString("CCCD");
                String SDT = rs.getString("SDT");
                String QueQuan = rs.getString("QueQuan");
                String TenNguoiThan = rs.getString("TenNguoiThan");
                String SDTNguoiThan = rs.getString("SDTNguoiThan");
                String QuanHeVoiNguoiThan = rs.getString("QuanHeVoiNguoiThan");
                int PhongID = rs.getInt("PhongID");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID);
                KhachThues.add(khachThue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KhachThues;
    }

    public KhachThue getKhachThueByKhachID(String id) {
        String sql = "Select * from khachthue k where k.KhachID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int KhachID = rs.getInt("KhachID");
                String HoVaTen = rs.getString("HoVaTen");
                String CCCD = rs.getString("CCCD");
                String SDT = rs.getString("SDT");
                String QueQuan = rs.getString("QueQuan");
                String TenNguoiThan = rs.getString("TenNguoiThan");
                String SDTNguoiThan = rs.getString("SDTNguoiThan");
                String QuanHeVoiNguoiThan = rs.getString("QuanHeVoiNguoiThan");
                int PhongID = rs.getInt("PhongID");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID);
                return khachThue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Update(String KhachID, String HoVaTen, String CCCD, String SDT, String QueQuan, String TenNguoiThan, String SDTNguoiThan, String QuanHeVoiNguoiThan, String PhongID) {
        String sql = "UPDATE khachthue SET KhachID=?, HoVaTen=?, CCCD=?, SDT=?, QueQuan=?, TenNguoiThan=?, SDTNguoiThan=?, QuanHeVoiNguoiThan=?, PhongID=? WHERE KhachID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KhachID);
            ps.setString(2, HoVaTen);
            ps.setString(3, CCCD);
            ps.setString(4, SDT);
            ps.setString(5, QueQuan);
            ps.setString(6, TenNguoiThan);
            ps.setString(7, SDTNguoiThan);
            ps.setString(8, QuanHeVoiNguoiThan);
            ps.setString(9, PhongID);
            ps.setString(10, KhachID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Khu> getPhongByKhuID() {
        List<Khu> khus = new ArrayList<>();
        String sql = "select * from Khu";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int KhuID = rs.getInt("KhuID");
                String Name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");
                Khu khu = new Khu(KhuID, Name, AccountID);
                khus.add(khu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khus;
    }

    public List<Khu> getPhongByKhuID1() {
        List<Khu> khus = new ArrayList<>();
        String sql = "select * from Khu Where KhuID= 1";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int KhuID = rs.getInt("KhuID");
                String Name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");
                Khu khu = new Khu(KhuID, Name, AccountID);
                khus.add(khu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khus;
    }

    public List<Khu> getPhongByKhuID2() {
        List<Khu> khus = new ArrayList<>();
        String sql = "select * from Khu Where KhuID= 2";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int KhuID = rs.getInt("KhuID");
                String Name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");
                Khu khu = new Khu(KhuID, Name, AccountID);
                khus.add(khu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khus;
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
        KhachThue kt = dao.getKhachThueByKhachID("1014");

        System.out.println(kt);

    }

}
