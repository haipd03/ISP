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
import model.Khu;
import model.Phong;

/**
 *
 * @author admin
 */
public class DAO extends MyDAO {

    // New searchbySoPhong method
    public List<Phong> searchbySoPhong(String soPhong) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE SoPhong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Retrieve data from the result set
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                // Create a Phong object from the retrieved data
                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                // Add the Phong object to the list
                Phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exceptions that occur
        }
        return Phongs; // Return the list of Phong objects
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
                int PhongID = rs.getInt("PhongID");   //edit dua vao thuoc tinh
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
                int Gia = rs.getInt("Gia");
                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
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
                int PhongID = rs.getInt("PhongID");   //edit dua vao thuoc tinh
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

    public List<Phong> getPhongByTinhTrang(String bt) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE PhongConTrong = ?";   // edit
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, bt);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");   //edit dua vao thuoc tinh
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


    public static void main(String[] args) {
        DAO dao = new DAO();
        String bt = "0";
        
        List<Phong> account = dao.getPhongByTinhTrang(bt);

        for (Phong Account : account) {
            System.out.println(Account);
        }
    }
}
