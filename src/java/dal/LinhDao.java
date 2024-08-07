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
import model.DichVuChung;
import model.Khu;
import model.Phong;

/*
 *
 * @author vulin
 */
public class LinhDao extends MyDAO {

    public List<DichVu> getAllDichVu(int offset, int limit) {
        List<DichVu> dichVuList = new ArrayList<>();
        String sql = "SELECT * FROM DichVu ORDER BY DichVuID "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY"; // Assuming the table in the database is "DichVu"
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int phongID = rs.getInt("PhongID");
                String name = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                String urlAnh = rs.getString("UrlAnh");

                DichVu dichVu = new DichVu(dichVuID, phongID, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi, urlAnh);
                dichVuList.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error if any
        }
        return dichVuList;
    }

    public int getTotalDichVuRecords() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM DichVu";
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

    public int getTotalDichVuRecords1(int accountID) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM DichVu dv\n"
                + "JOIN Phong p ON p.PhongID = dv.PhongID\n"
                + "JOIN Khu k ON p.KhuID = k.KhuID \n"
                + "JOIN Accounts a ON a.AccountID = k.AccountID \n"
                + "WHERE a.AccountID = ?";

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, accountID);
            rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<DichVu> getDichVuByCriteria(String phongID, String name, String tuNgay, String denNgay) {
        List<DichVu> dichVuSearch = new ArrayList<>();
        String sql = "SELECT * FROM DichVu WHERE 1=1";

        if (phongID != null && !phongID.trim().isEmpty()) {
            sql += " AND PhongID = ?";
        }
        if (name != null && !name.trim().isEmpty()) {
            sql += " AND Name LIKE ?";
        }
        if (tuNgay != null && !tuNgay.trim().isEmpty()) {
            sql += " AND TuNgay >= ?";
        }
        if (denNgay != null && !denNgay.trim().isEmpty()) {
            sql += " AND DenNgay <= ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;

            if (phongID != null && !phongID.trim().isEmpty()) {
                ps.setString(paramIndex++, phongID);
            }
            if (name != null && !name.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
            }
            if (tuNgay != null && !tuNgay.trim().isEmpty()) {
                try {
                    ps.setDate(paramIndex++, java.sql.Date.valueOf(tuNgay));
                } catch (IllegalArgumentException e) {
                    // Handle invalid date format
                    throw new SQLException("Invalid 'tuNgay' format, expected 'yyyy-[m]m-[d]d'.");
                }
            }
            if (denNgay != null && !denNgay.trim().isEmpty()) {
                try {
                    ps.setDate(paramIndex++, java.sql.Date.valueOf(denNgay));
                } catch (IllegalArgumentException e) {
                    // Handle invalid date format
                    throw new SQLException("Invalid 'denNgay' format, expected 'yyyy-[m]m-[d]d'.");
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int phongID1 = rs.getInt("PhongID");
                String nameResult = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgayResult = rs.getDate("TuNgay");
                Date denNgayResult = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                String urlAnh = rs.getString("UrlAnh");

                DichVu dichVu = new DichVu(dichVuID, phongID1, nameResult, giaTien, tuNgayResult, denNgayResult, chiSoCu, chiSoMoi, urlAnh);
                dichVuSearch.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error if any
        }
        return dichVuSearch;
    }

    public List<DichVu> getDichVuByCriteria1(String phongID, String name, String tuNgay, String denNgay, int accountID) {
        List<DichVu> dichVuSearch = new ArrayList<>();
        String sql = "SELECT dv.*\n"
                + "FROM DichVu dv\n"
                + "JOIN Phong p ON p.PhongID = dv.PhongID\n"
                + "JOIN Khu k ON p.KhuID = k.KhuID \n"
                + "JOIN Accounts a ON a.AccountID = k.AccountID \n"
                + "WHERE a.AccountID = ?";

        if (phongID != null && !phongID.trim().isEmpty()) {
            sql += " AND dv.PhongID = ?";
        }
        if (name != null && !name.trim().isEmpty()) {
            sql += " AND dv.Name LIKE ?";
        }
        if (tuNgay != null && !tuNgay.trim().isEmpty()) {
            sql += " AND dv.TuNgay >= ?";
        }
        if (denNgay != null && !denNgay.trim().isEmpty()) {
            sql += " AND dv.DenNgay <= ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;

            // Set accountID parameter
            ps.setInt(paramIndex++, accountID);

            // Set other parameters if provided
            if (phongID != null && !phongID.trim().isEmpty()) {
                ps.setString(paramIndex++, phongID);
            }
            if (name != null && !name.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
            }
            if (tuNgay != null && !tuNgay.trim().isEmpty()) {
                try {
                    ps.setDate(paramIndex++, java.sql.Date.valueOf(tuNgay));
                } catch (IllegalArgumentException e) {
                    throw new SQLException("Invalid 'tuNgay' format, expected 'yyyy-[m]m-[d]d'.");
                }
            }
            if (denNgay != null && !denNgay.trim().isEmpty()) {
                try {
                    ps.setDate(paramIndex++, java.sql.Date.valueOf(denNgay));
                } catch (IllegalArgumentException e) {
                    throw new SQLException("Invalid 'denNgay' format, expected 'yyyy-[m]m-[d]d'.");
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuID = rs.getInt("DichVuID");
                int phongID1 = rs.getInt("PhongID");
                String nameResult = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgayResult = rs.getDate("TuNgay");
                Date denNgayResult = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                String urlAnh = rs.getString("UrlAnh");

                DichVu dichVu = new DichVu(dichVuID, phongID1, nameResult, giaTien, tuNgayResult, denNgayResult, chiSoCu, chiSoMoi, urlAnh);
                dichVuSearch.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                int phongID = rs.getInt("PhongID");
                String name = rs.getString("Name");
                int giaTien = rs.getInt("GiaTien");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                String urlAnh = rs.getString("UrlAnh");

                DichVu dichVu = new DichVu(dichVuID, phongID, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi, urlAnh);
                return dichVu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editDichVu(String id, String phongID, String name, String giaTien, Date tuNgay, Date denNgay, String chiSoCu, String chiSoMoi, String urlAnh) {
        String query = "UPDATE DichVu\n"
                + "SET PhongID = ?,\n"
                + "    Name = ?,\n"
                + "    GiaTien = ?,\n"
                + "    TuNgay = ?,\n"
                + "    DenNgay = ?,\n"
                + "    ChiSoCu = ?,\n"
                + "    ChiSoMoi = ?,\n"
                + "    UrlAnh = ?\n"
                + "WHERE DichVuID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, phongID);
            ps.setString(2, name);
            ps.setString(3, giaTien); // Use setString for String parameters
            ps.setDate(4, new java.sql.Date(tuNgay.getTime())); // Convert java.util.Date to java.sql.Date
            ps.setDate(5, new java.sql.Date(denNgay.getTime())); // Convert java.util.Date to java.sql.Date
            ps.setString(6, chiSoCu); // Use setString for String parameters
            ps.setString(7, chiSoMoi); // Use setString for String parameters
            ps.setString(8, urlAnh);
            ps.setString(9, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDichVu(String dvid, String phongid, String name, String giaTien, String tuNgay, String denNgay, String chiSoCu, String chiSoMoi, String urlAnh) {
        String sql = "INSERT INTO DichVu (DichVuID, PhongID, Name, GiaTien, TuNgay, DenNgay, ChiSoCu, ChiSoMoi, UrlAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setString(9, urlAnh);
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

    public boolean dichVuIdExists(String dvid) {
        String query = "SELECT COUNT(*) FROM DichVu WHERE DichVuID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dvid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void insertDichVuChung(String dichVuChungID, String khuID, String dichVuChungName, String ten, String sdt, String gia, String tuNgay, String denNgay, String tinhTrang, String ghiChu) {
        String sql = "INSERT INTO DichVuChung (DichVuChungID, KhuID, DichVuChungName, Ten, Sdt, Gia, TuNgay, DenNgay, TinhTrang, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dichVuChungID);
            ps.setString(2, khuID);
            ps.setString(3, dichVuChungName);
            ps.setString(4, ten);
            ps.setString(5, sdt);
            ps.setString(6, gia);
            ps.setString(7, tuNgay);
            ps.setString(8, denNgay);
            ps.setString(9, tinhTrang);
            ps.setString(10, ghiChu);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDichVuChung(int dichVuChungID) throws SQLException {
        String sql = "DELETE FROM DichVuChung WHERE dichVuChungID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dichVuChungID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Xóa dịch vụ chung không thành công, không có bản ghi nào bị ảnh hưởng.");
            }
        } catch (SQLException e) {
            throw new SQLException("Lỗi khi xóa dịch vụ chung: " + e.getMessage(), e);
        }
    }
    
    public void editDichVuChung(int dichVuChungID, int khuID, String dichVuChungName, String ten, String sdt, int gia, Date tuNgay, Date denNgay, String tinhTrang, String ghiChu) {
        String query = "UPDATE DichVuChung\n"
                + "SET KhuID = ?,\n"
                + "    DichVuChungName = ?,\n"
                + "    Ten = ?,\n"
                + "    Sdt = ?,\n"
                + "    Gia = ?,\n"
                + "    TuNgay = ?,\n"
                + "    DenNgay = ?,\n"
                + "    TinhTrang = ?,\n"
                + "    GhiChu = ?\n"
                + "WHERE DichVuChungID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, khuID);
            ps.setString(2, dichVuChungName);
            ps.setString(3, ten);
            ps.setString(4, sdt);
            ps.setInt(5, gia);
            ps.setDate(6, new java.sql.Date(tuNgay.getTime()));
            ps.setDate(7, new java.sql.Date(denNgay.getTime()));
            ps.setString(8, tinhTrang);
            ps.setString(9, ghiChu);
            ps.setInt(10, dichVuChungID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Khu> getKhuByAccountID(int accountID) {
        List<Khu> khus = new ArrayList<>();
        String sql = "select k.*\n"
                + "from khu k\n"
                + "join Accounts a on a.AccountID = k.AccountID\n"
                + "where a.AccountID=?";
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
    
    public DichVuChung getDichVuChungByID(String id) {
        String sql = "SELECT * FROM DichVuChung WHERE DichVuChungID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int dichVuChungID = rs.getInt("DichVuChungID");
                int khuID = rs.getInt("KhuID");
                String dichVuChungName = rs.getString("DichVuChungName");
                String ten = rs.getString("Ten");
                String sdt = rs.getString("Sdt");
                int gia = rs.getInt("Gia");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                String tinhTrang = rs.getString("TinhTrang");
                String ghiChu = rs.getString("GhiChu");

                DichVuChung dichVuChung = new DichVuChung(dichVuChungID, khuID, dichVuChungName, ten, sdt, gia, tuNgay, denNgay, tinhTrang, ghiChu);
                return dichVuChung;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

public List<DichVuChung> getAllDichVuChung() {
        List<DichVuChung> dichVuChungList = new ArrayList<>();
        String sql = "SELECT * FROM DichVuChung";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuChungID = rs.getInt("DichVuChungID");
                int khuID = rs.getInt("KhuID");
                String dichVuChungName = rs.getString("DichVuChungName");
                String ten = rs.getString("Ten");
                String sdt = rs.getString("SDT");
                int gia = rs.getInt("Gia");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                String tinhTrang = rs.getString("TinhTrang");
                String ghiChu = rs.getString("GhiChu");

                DichVuChung dichVuChung = new DichVuChung(dichVuChungID, khuID, dichVuChungName, ten, sdt, gia, tuNgay, denNgay, tinhTrang, ghiChu);
                dichVuChungList.add(dichVuChung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception or rethrowing it
        }

        return dichVuChungList;
    }

public List<DichVuChung> getDichVuChungByCriteria(String dichVuChungName, String ten, String sdt, Integer gia, String tuNgay, String denNgay, String tinhTrang, int accountID, int role, Integer khuID) {
        List<DichVuChung> dichVuChungList = new ArrayList<>();
        String sql = "SELECT dvc.* FROM DichVuChung dvc JOIN Khu k ON dvc.KhuID = k.KhuID JOIN Accounts a ON a.AccountID = k.AccountID WHERE 1=1";

        if (role == 1) {
            sql += " AND a.AccountID = ?";
        }
        if (role == 0 && khuID != null) {
            sql += " AND k.KhuID = ?";
        }

        if (dichVuChungName != null && !dichVuChungName.trim().isEmpty()) {
            sql += " AND dvc.DichVuChungName LIKE ?";
        }
        if (ten != null && !ten.trim().isEmpty()) {
            sql += " AND dvc.Ten LIKE ?";
        }
        if (sdt != null && !sdt.trim().isEmpty()) {
            sql += " AND dvc.SDT LIKE ?";
        }
        if (gia != null) {
            sql += " AND dvc.Gia = ?";
        }
        if (tuNgay != null && !tuNgay.trim().isEmpty()) {
            sql += " AND dvc.TuNgay >= ?";
        }
        if (denNgay != null && !denNgay.trim().isEmpty()) {
            sql += " AND dvc.DenNgay <= ?";
        }
        if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
            sql += " AND dvc.TinhTrang LIKE ?";
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int paramIndex = 1;

            if (role == 1) {
                ps.setInt(paramIndex++, accountID);
            }
            if (role == 0 && khuID != null) {
                ps.setInt(paramIndex++, khuID);
            }

            if (dichVuChungName != null && !dichVuChungName.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + dichVuChungName + "%");
            }
            if (ten != null && !ten.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + ten + "%");
            }
            if (sdt != null && !sdt.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + sdt + "%");
            }
            if (gia != null) {
                ps.setInt(paramIndex++, gia);
            }
            if (tuNgay != null && !tuNgay.trim().isEmpty()) {
                ps.setDate(paramIndex++, java.sql.Date.valueOf(tuNgay));
            }
            if (denNgay != null && !denNgay.trim().isEmpty()) {
                ps.setDate(paramIndex++, java.sql.Date.valueOf(denNgay));
            }
            if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + tinhTrang + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dichVuChungID = rs.getInt("DichVuChungID");
                int khuIDResult = rs.getInt("KhuID");
                String dichVuChungNameResult = rs.getString("DichVuChungName");
                String tenResult = rs.getString("Ten");
                String sdtResult = rs.getString("SDT");
                int giaResult = rs.getInt("Gia");
                Date tuNgayResult = rs.getDate("TuNgay");
                Date denNgayResult = rs.getDate("DenNgay");
                String tinhTrangResult = rs.getString("TinhTrang");
                String ghiChu = rs.getString("GhiChu");

                DichVuChung dichVuChung = new DichVuChung(dichVuChungID, khuIDResult, dichVuChungNameResult, tenResult, sdtResult, giaResult, tuNgayResult, denNgayResult, tinhTrangResult, ghiChu);
                dichVuChungList.add(dichVuChung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dichVuChungList;
    }


public List<Khu> getKhuBy() {
        List<Khu> khus = new ArrayList<>();
        String sql = "select k.*\n"
                + "from khu k\n";
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


    public static void main(String[] args) throws SQLException {
        LinhDao u = new LinhDao();
        List<DichVu> dichVu = u.getDichVuByCriteria("1001", null, null, null);
        for (DichVu phong : dichVu) {
            System.out.println(phong);
        }
    }
}