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

/**
 *
 * @author admin
 */
public class DAO extends MyDAO {
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

     
    public static void main(String[] args) {
    DAO dao = new DAO();
//    String username = "hai"; // Replace "your_username" with the actual username
//    String password = "123"; // Replace "your_password" with the actual password
//    Accounts account = dao.login(username, password);
//    if (account != null) {
//        System.out.println("Login successful: " + account);
//    } else {
//        System.out.println("Login failed. Invalid username or password.");
//    }
List<Phong> listC = dao.getPhong();

        for (Phong category : listC) {
            System.out.println(category);
        }
}

}
