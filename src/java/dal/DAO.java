/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Accounts;
import model.DichVu;
import model.HoaDon;
import model.HoaDonDetail;
import model.KhachThue;
import model.Khu;
import model.Phong;
import model.ThietBi;

/**
 *
 * @author admin
 */
public class DAO extends MyDAO {

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

    public List<Phong> getPhong() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Phongs;
    }

    public List<Phong> getPhongDetailsByAccountID(int accountID) {
        List<Phong> phongDetailsList = new ArrayList<>();
        String sql = "SELECT p.* "
                + "FROM Phong p "
                + "JOIN Khu k ON p.KhuID = k.KhuID "
                + "JOIN Accounts a ON a.AccountID = k.AccountID "
                + "WHERE a.AccountID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accountID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int PhongID = rs.getInt("PhongID");
                    int SoPhong = rs.getInt("SoPhong");
                    int KhuID = rs.getInt("KhuID");
                    String LoaiPhong = rs.getString("LoaiPhong");
                    int PhongConTrong = rs.getInt("PhongConTrong");
                    String GhiChu = rs.getString("GhiChu");
                    int Gia = rs.getInt("Gia");

                    Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                    phongDetailsList.add(phong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongDetailsList;
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
                        rs.getString("CCCD"),
                        rs.getString("DiaChi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Accounts getAccountsByID(int id) {
        String sql = "SELECT * FROM Accounts WHERE AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int accountId = rs.getInt("AccountID");
                String taiKhoan = rs.getString("TaiKhoan");
                String password = rs.getString("Password");
                int role = rs.getInt("Role");
                String hoVaTen = rs.getString("HoVaTen");
                String email = rs.getString("Email");
                String cccd = rs.getString("CCCD");
                String diaChi = rs.getString("DiaChi");

                // Creating an Accounts object with retrieved data
                Accounts account = new Accounts(accountId, taiKhoan, password, role, hoVaTen, email, cccd, diaChi);
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Accounts getAccountByTaiKhoan(String taiKhoan) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE TaiKhoan = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, taiKhoan);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int accountId = rs.getInt("AccountID");
                    String retrievedTaiKhoan = rs.getString("TaiKhoan"); // Renamed to avoid shadowing
                    String password = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String hoVaTen = rs.getString("HoVaTen");
                    String email = rs.getString("Email");
                    String cccd = rs.getString("CCCD");
                    String diaChi = rs.getString("DiaChi");

                    // Creating an Accounts object with retrieved data
                    Accounts account = new Accounts(accountId, retrievedTaiKhoan, password, role, hoVaTen, email, cccd, diaChi);
                    return account;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to indicate failure
        }
        return null;
    }

    public void editMyAccount(String accountID, String hoVaTen, String email, int cccd, String diaChi, String password) {
        String query = "UPDATE Accounts\n"
                + "SET HoVaTen = ?,\n"
                + "Email = ?,\n"
                + "CCCD = ?,\n"
                + "DiaChi = ?,\n"
                + "Password = ?\n"
                + "WHERE AccountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hoVaTen);
            ps.setString(2, email);
            ps.setInt(3, cccd);
            ps.setString(4, diaChi);
            ps.setString(5, password);
            ps.setString(6, accountID);  // Use the correct parameter index
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public List<Accounts> getAllAccounts() {
        List<Accounts> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Accounts";
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
                String CCCD = rs.getString("CCCD");
                String DiaChi = rs.getString("DiaChi");

                Accounts account = new Accounts(AccountID, TaiKhoan, Password, Role, HoVaTen, Email, CCCD, DiaChi);
                accounts.add(account);
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    public void addAccount(Accounts account) {
        String sql = "INSERT INTO Accounts (AccountID, TaiKhoan, Password, Role, HoVaTen, Email, CCCD, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, account.getAccountID());
            ps.setString(2, account.getTaiKhoan());
            ps.setString(3, account.getPassword());
            ps.setInt(4, account.getRole());
            ps.setString(5, account.getHoVaTen());
            ps.setString(6, account.getEmail());
            ps.setString(7, account.getCCCD());
            ps.setString(8, account.getDiaChi());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String accountID) throws SQLException {
        String sql = "DELETE FROM Accounts WHERE AccountID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, accountID);
            ps.executeUpdate();
        }
    }

    public boolean checkAccIDcoKhu(String aid) {
        String query = "select distinct A.* from Accounts A join Khu k on k.AccountID = A.AccountID where A.AccountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, aid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateAccount(Accounts account) throws SQLException {
        String sql = "UPDATE Accounts SET TaiKhoan = ?, Password = ?, Role = ?, HoVaTen = ?, Email = ?, CCCD = ?, DiaChi = ? WHERE AccountID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, account.getTaiKhoan());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getRole());
            ps.setString(4, account.getHoVaTen());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getCCCD());
            ps.setString(7, account.getDiaChi());
            ps.setInt(8, account.getAccountID());
            ps.executeUpdate();
        }
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
                int TinhTrang = rs.getInt("TinhTrang");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
                KhachThues.add(khachThue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KhachThues;
    }

    public List<KhachThue> getKhachThueByPhongIDByAccountID(String id, int aid) {
        List<KhachThue> KhachThues = new ArrayList<>();
        String sql = "SELECT Kh.* FROM KhachThue Kh JOIN Phong P ON P.PhongID = Kh.PhongID JOIN Khu K ON K.KhuID = P.KhuID JOIN Accounts a ON a.AccountID = k.AccountID WHERE Kh.PhongID = ? and a.AccountID =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, aid);
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
                int TinhTrang = rs.getInt("TinhTrang");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
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
                int TinhTrang = rs.getInt("TinhTrang");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
                return khachThue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Updatekhachthue(String KhachID, String HoVaTen, String CCCD, String SDT, String QueQuan, String TenNguoiThan, String SDTNguoiThan, String QuanHeVoiNguoiThan, String PhongID, String TinhTrang) {
        String sql = "UPDATE khachthue SET KhachID=?, HoVaTen=?, CCCD=?, SDT=?, QueQuan=?, TenNguoiThan=?, SDTNguoiThan=?, QuanHeVoiNguoiThan=?, PhongID=?, TinhTrang=? WHERE KhachID=?";
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
            ps.setString(10, TinhTrang);
            ps.setString(11, KhachID);
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

    public List<Khu> getKhuByKhuID1(int accountID) {
        List<Khu> khus = new ArrayList<>();
        String sql = "SELECT k.* FROM Khu k JOIN Accounts a ON a.AccountID = k.AccountID WHERE a.AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
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

    public boolean checkExistingName(String Name) {
        String query = "SELECT KhuID FROM [dbo].[Khu] WHERE Name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
        }
        return false; // Nếu không tìm thấy khuID
    }

    public boolean checkKhuIDcoPhong(String kid) {
        String query = "select distinct k.* from Khu k join Phong p on p.KhuID = k.KhuID where k.KhuID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, kid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public void UpdateKhu(String name, String accountID, String khuID) {
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

    public List<Phong> searchbySoPhong(String soPhong) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE SoPhong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                // Add the Phong object to the list
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printany SQL exceptions that occur
        }
        return Phongs; // Return the list of Phong objects
    }

    public List<Khu> getKhu2() {
        List<Khu> khus = new ArrayList<>();
        String sql = "SELECT * FROM khu";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu

                int KhuID = rs.getInt("KhuID");
                String name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");
                // Tạo đối tượng Truyen từ thông tin lấy được
                Khu Khu = new Khu(KhuID, name, AccountID);
                // Thêm đối tượng Truyen vào danh sách truyens
                khus.add(Khu);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return khus;
    }

    public List<Phong> getPhongByKhuID(String ck) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong Where KhuID= ?";   // edit
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ck);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<Phong> getPhongByLoaiPhong(String bl) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE LoaiPhong LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + bl + "%"); // Concatenate the wildcard characters around the parameter value
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error if any
        }
        return Phongs;
    }

    public List<Phong> getPhongByGia(String bg) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE Gia = ?";   // edit
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, bg);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<Phong> getPhongByTinhTrang(String bt) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE PhongConTrong = ?";   // edit
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, bt);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
    }

    public List<Phong> getPhongForLoaiPhong() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT DISTINCT LoaiPhong FROM Phong";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String LoaiPhong = rs.getString("LoaiPhong");
                Phong phong = new Phong(LoaiPhong);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Phongs;
    }

    public List<Phong> getPhongForGia() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT DISTINCT Gia FROM Phong";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int Gia = rs.getInt("Gia");
                Phong phong = new Phong(Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Phongs;
    }

    public List<Phong> getPhongForTinhTrang() {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT DISTINCT PhongConTrong FROM Phong";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongConTrong = rs.getInt("PhongConTrong");
                Phong phong = new Phong(PhongConTrong, true);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<ThietBi> getAllThietBi(int offset, int limit) {
        List<ThietBi> ThietBi = new ArrayList<>();
        String sql = "select * from ThietBi ORDER BY ThietBiID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1, offset);
        ps.setInt(2, limit);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ThietBiID = rs.getInt("ThietBiID");
                int PhongID = rs.getInt("PhongID");
                String Name = rs.getString("Name");
                int SoLuong = rs.getInt("SoLuong");
                String TinhTrang = rs.getString("TinhTrang");
                int Gia = rs.getInt("Gia");
                ThietBi thietbi = new ThietBi(ThietBiID, PhongID, Name, SoLuong, TinhTrang, Gia);
                ThietBi.add(thietbi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ThietBi;
    }
    
    public int getTotalThietBiCount() {
    int count = 0;
    try {
        String sql = "SELECT COUNT(*) FROM ThietBi";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return count;
}
    
public List<ThietBi> getAllThietBiGia() {
    List<ThietBi> thietBiList = new ArrayList<>();
    String sql = "SELECT DISTINCT Gia FROM ThietBi";
    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            int gia = rs.getInt("Gia");
            ThietBi thietBi = new ThietBi();
            thietBi.setGia(gia);
            thietBiList.add(thietBi);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return thietBiList;
}
public static void main(String[] args) {
        // Tạo một đối tượng của lớp chứa phương thức getAllThietBiGia()
        // ở đây mình giả sử lớp chứa phương thức là ThietBiDAO
        DAO thietBiDAO = new DAO();
        
        // Gọi phương thức và nhận danh sách kết quả trả về
        List<ThietBi> thietBiList = thietBiDAO.getAllThietBi(0, 20);
        
        // In ra các giá trị trong danh sách
        for (ThietBi thietBi : thietBiList) {
            System.out.println(thietBi);
        }
    }


//public List<ThietBi> searchListThietBi(int accountID, int khuID, int phongID, String name, String tinhTrang, int gia, int offset, int limit) {
//    List<ThietBi> tb = new ArrayList<>();
//    String sql = "select tb.* from ThietBi tb " +
//                 "join Phong p on p.PhongID = tb.PhongID " +
//                 "join Khu k on k.KhuID = p.KhuID " +
//                 "join Accounts a on a.AccountID = k.AccountID " +
//                 "where 1=1";
//
//    List<Object> parameters = new ArrayList<>();
//    if (accountID != 0) {
//        sql += " AND a.AccountID = ?";
//        parameters.add(accountID);
//    }
//    if (khuID != 0) {
//        sql += " AND k.KhuID = ?";
//        parameters.add(khuID);
//    }
//    if (phongID != 0) {
//        sql += " AND tb.PhongID = ?";
//        parameters.add(phongID);
//    }
//    if (name != null && !name.isEmpty()) {
//        sql += " AND tb.Name LIKE ?";
//        parameters.add("%" + name + "%");
//    }
//    if (tinhTrang != null && !tinhTrang.isEmpty()) {
//        sql += " AND tb.TinhTrang LIKE ?";
//        parameters.add("%" + tinhTrang + "%");
//    }
//    if (gia != 0) {
//        sql += " AND tb.Gia = ?";
//        parameters.add(gia);
//    }
//    sql += " ORDER BY ThietBiID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
//
//    parameters.add(offset);
//    parameters.add(limit);
//
//    try (PreparedStatement ps = con.prepareStatement(sql)) {
//        for (int i = 0; i < parameters.size(); i++) {
//            ps.setObject(i + 1, parameters.get(i));
//        }
//
//        try (ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                ThietBi tbs = new ThietBi(
//                        rs.getInt("ThietBiID"),
//                        rs.getInt("PhongID"),
//                        rs.getString("Name"),
//                        rs.getInt("SoLuong"),
//                        rs.getString("TinhTrang"),
//                        rs.getInt("Gia"));
//                tb.add(tbs);
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return tb;
//}

  public List<ThietBi> searchListThietBi(int accountID, int khuID, int phongID, String name, String tinhTrang, int gia) {
    List<ThietBi> tb = new ArrayList<>();
    String sql = "select tb.* from ThietBi tb " +
                 "join Phong p on p.PhongID = tb.PhongID " +
                 "join Khu k on k.KhuID = p.KhuID " +
                 "join Accounts a on a.AccountID = k.AccountID " +
                 "where 1=1";

    List<Object> parameters = new ArrayList<>();
    if (accountID != 0) {
        sql += " AND a.AccountID = ?";
        parameters.add(accountID);
    }
    if (khuID != 0) {
        sql += " AND k.KhuID = ?";
        parameters.add(khuID);
    }
    if (phongID != 0) {
        sql += " AND tb.PhongID = ?";
        parameters.add(phongID);
    }
    if (name != null && !name.isEmpty()) {
        sql += " AND tb.Name LIKE ?";
        parameters.add("%" + name + "%");
    }
    if (tinhTrang != null && !tinhTrang.isEmpty()) {
        sql += " AND tb.TinhTrang LIKE ?";
        parameters.add("%" + tinhTrang + "%");
    }
    if (gia != 0) {
        sql += " AND tb.Gia = ?";
        parameters.add(gia);
    }

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThietBi tbs = new ThietBi(
                        rs.getInt("ThietBiID"),
                        rs.getInt("PhongID"),
                        rs.getString("Name"),
                        rs.getInt("SoLuong"),
                        rs.getString("TinhTrang"),
                        rs.getInt("Gia"));
                tb.add(tbs);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tb;
}

  
    public int getTotalThietBiCount1() {
    int count = 0;
    try {
        String sql = "SELECT COUNT(*) FROM ThietBi tb " +
                     "JOIN Phong p ON p.PhongID = tb.PhongID " +
                     "JOIN Khu k ON k.KhuID = p.KhuID " +
                     "JOIN Accounts a ON a.AccountID = k.AccountID";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return count;
}

    
    public List<ThietBi> getAllThietBiByAccountID() {
        List<ThietBi> ThietBi = new ArrayList<>();
        String sql = "select tb.* from ThietBi tb\n"
                + "join Phong p on p.PhongID =  tb.PhongID\n"
                + "join Khu k on k.KhuID = p.KhuID\n"
                + "join Accounts a on a.AccountID = k.AccountID\n"
                + "where a.AccountID = ?\n"
                + "ORDER BY PhongID ";
        try {
            ps = con.prepareStatement(sql);
//            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ThietBiID = rs.getInt("ThietBiID");
                int PhongID = rs.getInt("PhongID");
                String Name = rs.getString("Name");
                int SoLuong = rs.getInt("SoLuong");
                String TinhTrang = rs.getString("TinhTrang");
                int Gia = rs.getInt("Gia");
                ThietBi thietbi = new ThietBi(ThietBiID, PhongID, Name, SoLuong, TinhTrang, Gia);
                ThietBi.add(thietbi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean checkExistingThietBiID(String tbid) {
        String query = "SELECT ThietBiID FROM ThietBi WHERE ThietBiID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tbid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public List<HoaDonDetail> getHoaDonDetail(String id) {
        List<HoaDonDetail> hoaDonDetail = new ArrayList<>();
        String query = "SELECT * FROM HoaDonDetail\n"
                + "where HoaDonID = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonDetailID = rs.getInt("HoaDonDetailID");
                int hoaDonID = rs.getInt("HoaDonID");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongSo = rs.getInt("TongSo");
                int heSo = rs.getInt("HeSo");
                int thanhTien = rs.getInt("ThanhTien");
                int dichVuID = rs.getInt("DichVuID");

                HoaDonDetail hoaDonDetails = new HoaDonDetail(hoaDonDetailID, hoaDonID, tuNgay, denNgay, tongSo, heSo, thanhTien, dichVuID);
                hoaDonDetail.add(hoaDonDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonDetail;
    }

    public HoaDonDetail getHoaDonDetailByID(String id) {
        String sql = "select * from HoaDonDetail where HoaDonDetailID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int hoaDonDetailID = rs.getInt("HoaDonDetailID");
                int hoaDonID = rs.getInt("HoaDonID");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongSo = rs.getInt("TongSo");
                int heSo = rs.getInt("HeSo");
                int thanhTien = rs.getInt("ThanhTien");
                int dichVuID = rs.getInt("DichVuID");

                // Assuming Truyen is your custom class
                HoaDonDetail hoadondetails = new HoaDonDetail(hoaDonDetailID, hoaDonID, tuNgay, denNgay, tongSo, heSo, thanhTien, dichVuID);
                return hoadondetails;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editHoaDonDetail(String TuNgay, String DenNgay, String TongSo, String HeSo, String ThanhTien, String DichVuID, String HoaDonChiTietID) {
        String query = "UPDATE HoaDonDetail SET TuNgay = ?, DenNgay = ?, TongSo = ? , HeSo = ?, ThanhTien = ?, DichVuID = ? WHERE HoaDonDetailID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TuNgay);
            ps.setString(2, DenNgay);
            ps.setString(3, TongSo);      
            ps.setString(4, HeSo);
            ps.setString(5, ThanhTien);
            ps.setString(6, DichVuID);
            ps.setString(7, HoaDonChiTietID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HoaDon> getIDByHoaDonID(String hdid) {
        List<HoaDon> hoaDon = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE HoaDonID = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, hdid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                Date NgayThanhToan = rs.getDate("NgayThanhToan");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");
                HoaDon hoaDons = new HoaDon(hoaDonID, hopDongID, tuNgay, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                hoaDon.add(hoaDons);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDon;
    }

   public void insertHoaDonDetail(String hddid, String hdid, String tungay, String denngay, String tongso, String heso, String thanhtien, String dichvuid) {
        String query = "insert into HoaDonDetail values(?,?,?,?,?,?,?,?)";
        try {
           ps = con.prepareStatement(query);
            ps.setString(1, hddid);
            ps.setString(2, hdid);
            ps.setString(3, tungay);
            ps.setString(4, denngay);
            ps.setString(5, tongso);
            ps.setString(6, heso);
            ps.setString(7, thanhtien);
            ps.setString(8, dichvuid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
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
                String CCCD = rs.getString("CCCD");
                String DiaChi = rs.getString("DiaChi");

                Accounts Accounts = new Accounts(AccountID, TaiKhoan, Password, Role, HoVaTen, Email, CCCD, DiaChi);
                Account.add(Accounts);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Account;
    }

    public List<Phong> getPhongByPhongID(String id) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE PhongID = ?";   // edit
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                String GhiChu = rs.getString("GhiChu");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return Phongs;
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

    

}
