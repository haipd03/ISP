/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DichVu;
import model.Khu;
import model.ThietBiChung;
import java.sql.ResultSet;

/**
 *
 * @author Ngoc Lan
 */
public class LanDao extends MyDAO {

    public List<ThietBiChung> getAllThietBiChung() {
        List<ThietBiChung> listThietBichung = new ArrayList<>();
        String sql = "select * from ThietBichung";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int thietBiChungID = rs.getInt("ThietBiChungID");
                int khuID = rs.getInt("KhuID");
                String ten = rs.getString("Ten");
                int soLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                ThietBiChung thietBiChung = new ThietBiChung(thietBiChungID, khuID, ten, soLuong, tinhTrang, gia);
                listThietBichung.add(thietBiChung);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return listThietBichung;
    }

    public List<ThietBiChung> getAllThietBiChungByAccountID(int aid) {
        List<ThietBiChung> dichVuListByID = new ArrayList<>();
        String sql = "SELECT tbc.*\n"
                + "FROM ThietBichung tbc\n"
                + "JOIN Khu k ON k.KhuID = tbc.KhuID\n"
                + "JOIN Accounts acc ON k.AccountID = acc.AccountID\n"
                + "WHERE acc.AccountID = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int thietBiChungID = rs.getInt("ThietBiChungID");
                int khuID = rs.getInt("KhuID");
                String ten = rs.getString("Ten");
                int soLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                ThietBiChung thietBiChung = new ThietBiChung(thietBiChungID, khuID, ten, soLuong, tinhTrang, gia);
                dichVuListByID.add(thietBiChung);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return dichVuListByID;
    }

    public void insertthietBiChung(String tbcid, String khuid, String ten, String soluong, String tinhtrang, String gia) {
        String sql = "insert into ThietBiChung values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tbcid);
            ps.setString(2, khuid);
            ps.setString(3, ten);
            ps.setString(4, soluong);
            ps.setString(5, tinhtrang);
            ps.setString(6, gia);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNextthietBiChungID() {
        String sql = "SELECT MAX(ThietBiChungID) FROM ThietBiChung";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int maxID = rs.getInt(1);
                return maxID + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public ThietBiChung getThietBiChungbyID(String id) {
        String sql = "select * from ThietBiChung where ThietBiChungID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int thietBiChungID = rs.getInt("ThietBiChungID");
                int khuID = rs.getInt("KhuID");
                String ten = rs.getString("Ten");
                int soLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                int gia = rs.getInt("Gia");

                ThietBiChung thietbichung = new ThietBiChung(thietBiChungID, khuID, ten, soLuong, tinhTrang, gia);
                return thietbichung;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Khu> getKhuIDByAccountID(int accountID) {
        List<Khu> Khus = new ArrayList<>();
        String sql = "select k.*\n"
                + "from Khu k \n"
                + "join Accounts a on a.AccountID =k.AccountID\n"
                + "where a.AccountID = 2";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int KhuID = rs.getInt("KhuID");
                String Name = rs.getString("Name");
                int AccountID = rs.getInt("AccountID");

                Khu khu = new Khu(KhuID, Name, AccountID);
                Khus.add(khu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Khus;
    }

    public void deleteThietBiChung(int thietBiChungID) throws SQLException {
        String sql = "DELETE FROM ThietBiChung WHERE ThietBiChungID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, thietBiChungID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting thiet bi chung failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error deleting thiet bi chung: " + e.getMessage(), e);
        }
    }

    public void editThietBiChung(String id, String khuID, String ten, String soLuong, String tinhTrang, String gia) {
        String query = "UPDATE ThietBiChung\n"
                + "                SET KhuID = ?,\n"
                + "				Ten = ?,\n"
                + "				Soluong = ?,\n"
                + "				TinhTrang = ?,\n"
                + "				Gia = ?\n"
                + "                WHERE ThietBiChungID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, khuID);
            ps.setString(2, ten);
            ps.setString(3, soLuong);
            ps.setString(4, tinhTrang); // Use setString for String parameters
            ps.setString(5, gia); // Use setString for String parameters
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ThietBiChung> getThietbiChungByCriteria(String ten, String soLuong, String tinhTrang, String gia) {
        List<ThietBiChung> thietbiChungSearch = new ArrayList<>();
        String sql = "SELECT * FROM ThietbiChung WHERE 1=1";

        if (ten != null && !ten.trim().isEmpty()) {
            sql += " AND Ten LIKE ?";
        }
        if (soLuong != null && !soLuong.trim().isEmpty()) {
            sql += " AND SoLuong = ?";
        }
        if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
            sql += " AND TinhTrang LIKE ?";
        }
        if (gia != null && !gia.trim().isEmpty()) {
            sql += " AND Gia = ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;

            if (ten != null && !ten.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + ten + "%");
            }
            if (soLuong != null && !soLuong.trim().isEmpty()) {
                ps.setString(paramIndex++, soLuong);
            }
            if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + tinhTrang + "%");
            }
            if (gia != null && !gia.trim().isEmpty()) {
                ps.setString(paramIndex++, gia);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thietBiChungID = rs.getInt("ThietBiChungID");
                int khuID = rs.getInt("KhuID");
                String tenResult = rs.getString("Ten");
                int soLuongResult = rs.getInt("SoLuong");
                String tinhTrangResult = rs.getString("TinhTrang");
                int giaResult = rs.getInt("Gia");

                ThietBiChung thietbiChung = new ThietBiChung(thietBiChungID, khuID, tenResult, soLuongResult, tinhTrangResult, giaResult);
                thietbiChungSearch.add(thietbiChung);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error if any
        }
        return thietbiChungSearch;
    }

    public List<ThietBiChung> getThietbiChungByCriteria1(String ten, String soLuong, String tinhTrang, String gia, int accountID) {
        List<ThietBiChung> thietbiChungSearch = new ArrayList<>();
        String sql = "SELECT tbc.* FROM ThietBiChung tbc JOIN Khu k ON tbc.KhuID = k.KhuID JOIN Accounts a ON a.AccountID = k.AccountID WHERE 1=1 and a.AccountID=?";

        if (ten != null && !ten.trim().isEmpty()) {
            sql += " AND Ten LIKE ?";
        }
        if (soLuong != null && !soLuong.trim().isEmpty()) {
            sql += " AND SoLuong = ?";
        }
        if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
            sql += " AND TinhTrang LIKE ?";
        }
        if (gia != null && !gia.trim().isEmpty()) {
            sql += " AND Gia = ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;
            ps.setInt(paramIndex++, accountID);
            if (ten != null && !ten.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + ten + "%");
            }
            if (soLuong != null && !soLuong.trim().isEmpty()) {
                ps.setString(paramIndex++, soLuong);
            }
            if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + tinhTrang + "%");
            }
            if (gia != null && !gia.trim().isEmpty()) {
                ps.setString(paramIndex++, gia);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thietBiChungID = rs.getInt("ThietBiChungID");
                int khuID = rs.getInt("KhuID");
                String tenResult = rs.getString("Ten");
                int soLuongResult = rs.getInt("SoLuong");
                String tinhTrangResult = rs.getString("TinhTrang");
                int giaResult = rs.getInt("Gia");

                ThietBiChung thietbiChung = new ThietBiChung(thietBiChungID, khuID, tenResult, soLuongResult, tinhTrangResult, giaResult);
                thietbiChungSearch.add(thietbiChung);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error if any
        }
        return thietbiChungSearch;
    }

    public static void main(String[] args) {
        LanDao u = new LanDao();
        
//        String id = "6"; // Set this to 2 to test the specific case
//        String khuID = "2";
//        String ten = "ha";
//        String soLuong = "1";
//        String tinhTrang = "Tốt";
//        String gia = "10";
//        u.editThietBiChung(id, khuID, ten, soLuong, tinhTrang, gia);
//        u.insertthietBiChung("45", "1", "Máy chiếu", "10", "Tốt", "2000000");

        List<ThietBiChung> tbc = u.getThietbiChungByCriteria1("m", null, null, null, 2);
        for (ThietBiChung thietBiChung : tbc) {
            System.out.println(thietBiChung);
        }
    }
}
