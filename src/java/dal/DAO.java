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

    public List<KhachThue> getKhachThueByPhongID(String id) {
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

    public void Updatekhachthue(String KhachID, String HoVaTen, String CCCD, String SDT, String QueQuan, String TenNguoiThan, String SDTNguoiThan, String QuanHeVoiNguoiThan, String PhongID) {
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

    public List<Khu> getKhuByKhuID() {
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

    public List<Khu> getKhuByKhuID1() {
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

    public List<Khu> getKhuByKhuID2() {
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

    public void DeleteKhu(String kid) {
        String sql = "delete from Khu where KhuID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertKhu(String khuID, String name, String accountID) {
        String sql = "INSERT INTO [dbo].[Khu] ([KhuID],[Name],[AccountID]) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, khuID);
            ps.setString(2, name);
            ps.setString(3, accountID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Accounts> getAccounts() {
        List<Accounts> Account = new ArrayList<>();
        String sql = "select * from Accounts"; // Câu lệnh SQL để lấy dữ liệu từ bảng Truyen
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int AccountID = rs.getInt("AccountID");
                String TaiKhoan = rs.getString("TaiKhoan");
                String Password = rs.getString("Password");
                int Role = rs.getInt("Role");
                String HoVaTen = rs.getString("HoVaTen");
                String Email = rs.getString("Email");
                int CCCD = rs.getInt("CCCD");
                String DiaChi = rs.getString("DiaChi");

                Accounts Accounts = new Accounts(AccountID, TaiKhoan, Password, Role, HoVaTen, Email, CCCD, DiaChi);
                Account.add(Accounts);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Account;
    }

    public int CountPhongInKhu(String kid) {
        String sql = "SELECT COUNT(*) AS SoPhong FROM Phong P INNER JOIN Khu K ON P.KhuID = K.KhuID WHERE P.KhuID = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SoPhong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Khu getKhuByKhuID(String id) {
        String sql = "Select * from khu k where k.KhuID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int KhuID = rs.getInt("KhuID");
                String Name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");
                Khu khu = new Khu(KhuID, Name, AccountID);
                return khu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateKhu(String khuID, String name, String accountID) {
        String sql = "UPDATE [dbo].[Khu] SET [Name] = ?,[AccountID] = ? WHERE KhuID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, accountID);
            ps.setString(3, khuID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        DBContext dbContext = new DBContext();

        try (Connection con = dbContext.connection) {
            System.out.println("Kết nối thành công!");

            // Tạo đối tượng Main để gọi phương thức CountPhongInKhu
            DAO dao = new DAO();
            String kid = "1"; // Thay đổi giá trị này tùy theo khu cần đếm
            int soPhong = dao.CountPhongInKhu(kid);
            System.out.println("Số phòng trong khu " + kid + " là: " + soPhong);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
