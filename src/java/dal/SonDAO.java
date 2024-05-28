package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDon;
import model.HopDong;
import model.Phong;

public class SonDAO extends MyDAO {

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

    public List<HopDong> getHopDong() {
        List<HopDong> HopDongs = new ArrayList<>();
        String sql = "SELECT * FROM HopDong";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hopDongID = rs.getInt("HopDongID");
                int khachID = rs.getInt("KhachID");
                int phongID = rs.getInt("PhongID");
                int tienCoc = rs.getInt("TienCoc");
                java.sql.Date ngayThue = rs.getDate("NgayThue");
                java.sql.Date ngayTra = rs.getDate("NgayTra");
                int soKhachThue = rs.getInt("SoKhachThue");
                String ghiChu = rs.getString("GhiChu");
                int cccd = rs.getInt("CCCD");
                int sdt = rs.getInt("SDT");
                String hoVaTen = rs.getString("HoVaTen");
                int tinhTrang = rs.getInt("TinhTrang");
                HopDong hopDong = new HopDong(hopDongID, khachID, phongID, tienCoc, ngayThue, ngayTra, soKhachThue, ghiChu, cccd, sdt, hoVaTen, tinhTrang);
                HopDongs.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HopDongs;
    }

    public List<HopDong> getHopDong1(int accountID) {
        List<HopDong> HopDongs = new ArrayList<>();
        String sql = "SELECT hp.* FROM HopDong hp JOIN Phong p ON p.PhongID = hp.PhongID JOIN Khu k ON k.KhuID = p.KhuID JOIN Accounts a ON a.AccountID = k.AccountID WHERE a.AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hopDongID = rs.getInt("HopDongID");
                int khachID = rs.getInt("KhachID");
                int phongID = rs.getInt("PhongID");
                int tienCoc = rs.getInt("TienCoc");
                java.sql.Date ngayThue = rs.getDate("NgayThue");
                java.sql.Date ngayTra = rs.getDate("NgayTra");
                int soKhachThue = rs.getInt("SoKhachThue");
                String ghiChu = rs.getString("GhiChu");
                int cccd = rs.getInt("CCCD");
                int sdt = rs.getInt("SDT");
                String hoVaTen = rs.getString("HoVaTen");
                int tinhTrang = rs.getInt("TinhTrang");
                HopDong hopDong = new HopDong(hopDongID, khachID, phongID, tienCoc, ngayThue, ngayTra, soKhachThue, ghiChu, cccd, sdt, hoVaTen, tinhTrang);
                HopDongs.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HopDongs;
    }

    public void insertHopDong(String HopDongID, String KhachID, String PhongID, String TienCoc, String NgayThue, String NgayTra, String SoKhachThue, String GhiChu, String CCCD, String SDT, String HoVaTen, String TinhTrang) {
        String query = "INSERT INTO [dbo].[HopDong] ([HopDongID],[KhachID],[PhongID],[TienCoc],[NgayThue],[NgayTra],[SoKhachThue],[GhiChu],[CCCD],[SDT],[HoVaTen],[TinhTrang]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, HopDongID);
            ps.setString(2, KhachID);
            ps.setString(3, PhongID);
            ps.setString(4, TienCoc);
            ps.setString(5, NgayThue);
            ps.setString(6, NgayTra);
            ps.setString(7, SoKhachThue);
            ps.setString(8, GhiChu);
            ps.setString(9, CCCD);
            ps.setString(10, SDT);
            ps.setString(11, HoVaTen);
            ps.setString(12, TinhTrang);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public static void main(String[] args) throws SQLException {

        SonDAO dao = new SonDAO();
        List<HopDong> listC = dao.getHopDong();

        for (HopDong category : listC) {
            System.out.println(category);
        }
    }

}
