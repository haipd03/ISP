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
     
   
   
   
    public List<Phong> getPhongDetailsByAccountID(int accountID) {
        List<Phong> phongDetailsList = new ArrayList<>();
        String sql = "SELECT p.* " +
                     "FROM Phong p " +
                     "JOIN Khu k ON p.KhuID = k.KhuID " +
                     "JOIN Accounts a ON a.AccountID = k.AccountID " +
                     "WHERE a.AccountID = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accountID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Extract data from result set
                    int phongID = rs.getInt("PhongID");
            int soPhong = rs.getInt("SoPhong");
            int khuId = rs.getInt("KhuID");
            String loaiPhong = rs.getString("LoaiPhong");
            int phongConTrong = rs.getInt("PhongConTrong");
            int gia = rs.getInt("Gia");
            
            // Create a Phong object from the retrieved information
            Phong phong = new Phong(phongID, soPhong, khuId, loaiPhong, phongConTrong, gia);
            // Add the Phong object to the list
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
                rs.getInt("CCCD"),
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
            int cccd = rs.getInt("CCCD");
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


    public void editMyAccount(String accountID, String hoVaTen, String email, int cccd, String diaChi) {
    String query = "UPDATE Accounts\n"
            + "SET HoVaTen = ?,\n"
            + "Email = ?,\n"
            + "CCCD = ?,\n"
            + "DiaChi = ?\n"
            + "WHERE AccountID = ?";
    try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, hoVaTen);
        ps.setString(2, email);
        ps.setInt(3, cccd);
        ps.setString(4, diaChi);
        ps.setString(5, accountID);  // Use the correct parameter index
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
                int CCCD = rs.getInt("CCCD");
                String DiaChi = rs.getString("DiaChi");

                Accounts account = new Accounts(AccountID, TaiKhoan, Password, Role, HoVaTen, Email, CCCD, DiaChi);
                accounts.add(account);
            }
        } catch (SQLException e) {
        } 
        return accounts;
    }
     

     
    public static void main(String[] args) {
    DAO dao = new DAO();
  
//    Accounts account = dao.getAccountsByID(1);
//    
//        System.out.println( account);
  

List<Accounts> listC = dao.getAllAccounts();

        for (Accounts category : listC) {
            System.out.println(category);
        }
}

}
