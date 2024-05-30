package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDon;
import model.HopDong;
import model.KhachThue;
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

    public List<Phong> getPhongByPhongID(String id) {
        List<Phong> Phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE PhongID = ?";
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
            e.printStackTrace();
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
                int TinhTrang = rs.getInt("TinhTrang");
                KhachThue khachThue = new KhachThue(KhachID, HoVaTen, CCCD, SDT, QueQuan, TenNguoiThan, SDTNguoiThan, QuanHeVoiNguoiThan, PhongID, TinhTrang);
                KhachThues.add(khachThue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KhachThues;
    }
    
    public List<KhachThue> getKhachThueByPhongIDAndTinhTrangLa1(String id) {
        List<KhachThue> KhachThues = new ArrayList<>();
        String sql = "Select * from khachthue k where k.PhongID= ? and k.TinhTrang = 1";
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

    public HopDong getHopDongByHopDongID(String id) {
        String sql = "select * from HopDong hd where hd.HopDongID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
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
                return hopDong;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HopDong> getHopDongByPhongID(String id) {
        List<HopDong> HopDongs = new ArrayList<>();
        String sql = "select * from HopDong hd where hd.PhongID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
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

    public boolean checkHopDongIDcoHoaDon(String hdid) {
        String query = "select distinct hp.* from HopDong hp join HoaDon hd on hd.HopDongID = hp.HopDongID where hp.HopDongID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hdid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void DeleteHopDong(String hdid) {
        String sql = "DELETE FROM [dbo].[HopDong] WHERE HopDong.HopDongID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hdid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkKhachThueIDcoHopDong(String ktid) {
        String query = "select distinct hd.* from KhachThue kt join HopDong hd on hd.KhachID = kt.KhachID where hd.KhachID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ktid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void DeleteKhachThue(String ktid) {
        String sql = "DELETE FROM [dbo].[KhachThue] WHERE KhachThue.KhachID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ktid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void updateHopDong(String HopDongID, String KhachID, String PhongID, String TienCoc, String NgayThue, String NgayTra, String SoKhachThue, String GhiChu, String CCCD, String SDT, String HoVaTen, String TinhTrang) {
        String query = "UPDATE [dbo].[HopDong] SET [HopDongID] = ?,[KhachID] = ?,[PhongID] = ?,[TienCoc] = ?,[NgayThue] = ?,[NgayTra] = ?,[SoKhachThue] = ?,[GhiChu] = ?,[CCCD] = ?,[SDT] = ?,[HoVaTen] = ?,[TinhTrang] = ? WHERE [HopDongID] = ?";
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
            ps.setString(13, HopDongID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
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

    public void insertkhachthue(String KhachID, String HoVaTen, String CCCD, String SDT, String QueQuan, String TenNguoiThan, String SDTNguoiThan, String QuanHeVoiNguoiThan, String PhongID, String TinhTrang) {
        String sql = "INSERT INTO [dbo].[KhachThue]([KhachID],[HoVaTen],[CCCD],[SDT],[QueQuan],[TenNguoiThan],[SDTNguoiThan],[QuanHeVoiNguoiThan],[PhongID],[TinhTrang]) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        SonDAO dao = new SonDAO();

        // Test the insertHopDong method
        String hopDongID = "885454";
        String khachID = "66688";
        String phongID = "1111112";
        String tienCoc = "1000000";
        String ngayThue = "2024-01-01";
        String ngayTra = "2024-12-31";
        String soKhachThue = "2";
        String ghiChu = "Ghi chú";
        String cccd = "1126484355";
        String sdt = "79430258";
        String hoVaTen = "Nguyen Van A";
        String tinhTrang = "1";

        dao.insertHopDong(hopDongID, khachID, phongID, tienCoc, ngayThue, ngayTra, soKhachThue, ghiChu, cccd, sdt, hoVaTen, tinhTrang);

        // Retrieve and print the list of contracts to verify insertion
        List<HopDong> listC = dao.getHopDong();
        for (HopDong category : listC) {
            System.out.println(category);
        }
    }

    public boolean checkKhachIDExists(String KhachID) {
        String sql = "SELECT * FROM KhachThue WHERE KhachID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KhachID);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkHopDongIDExists(String HopDongID) {
        String sql = "SELECT * FROM HopDong hp WHERE hp.HopDongID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, HopDongID);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
