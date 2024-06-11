package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DichVu;
import model.HoaDon;
import model.HoaDonDetail;
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

    public List<KhachThue> getKhachThue() {
        List<KhachThue> KhachThues = new ArrayList<>();
        String sql = "Select * from khachthue";
        try {
            ps = con.prepareStatement(sql);
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

    public List<KhachThue> getKhachThueByAccountID(int aid) {
        List<KhachThue> KhachThues = new ArrayList<>();
        String sql = "SELECT Kh.* FROM KhachThue Kh JOIN Phong P ON P.PhongID = Kh.PhongID JOIN Khu K ON K.KhuID = P.KhuID JOIN Accounts a ON a.AccountID = k.AccountID WHERE a.AccountID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
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

    public HoaDon getIDByHoaDonIDByPhongID(String id) {
        String query = "SELECT TOP 1 hdon.*\n"
                + "FROM HoaDon hdon\n"
                + "JOIN HopDong hdong ON hdong.HopDongID = hdon.HopDongID\n"
                + "WHERE hdong.PhongID = ?\n"
                + "ORDER BY hdon.HoaDonID DESC;";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                Date NgayThanhToan = rs.getDate("NgayThanhToan");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");
                HoaDon hoaDons = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                return hoaDons;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDon getHoaDonByHoaDonID(String id) {
        String query = "SELECT * FROM HoaDon WHERE HoaDonID = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                Date NgayThanhToan = rs.getDate("NgayThanhToan");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");
                HoaDon hoaDons = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                return hoaDons;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Phong getPhongByHoaDonID(String id) {
        String sql = "SELECT * FROM Phong p join HopDong hdong on hdong.PhongID = p.PhongID join HoaDon hdon on hdon.HopDongID = hdong.HopDongID WHERE hdon.HoaDonID = ?";
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

                Phong phongs = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, GhiChu, Gia);
                return phongs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HopDong getHopDongByPhongIDandTinhTrang1(String id) {
        String sql = "select * from HopDong hd where hd.PhongID = ? and hd.TinhTrang = 1";
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

    public void insertHoaDon(String HoaDonID, String HopDongID, String NgayThanhToan, String TinhTrangThanhToan, String TuNgay, String DenNgay, String TongTien) {
        String sql = "INSERT INTO [dbo].[HoaDon] ([HoaDonID],[HopDongID],[NgayThanhToan],[TinhTrangThanhToan],[TuNgay],[DenNgay],[TongTien]) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, HoaDonID);
            ps.setString(2, HopDongID);
            ps.setString(3, NgayThanhToan);
            ps.setString(4, TinhTrangThanhToan);
            ps.setString(5, TuNgay);
            ps.setString(6, DenNgay);
            ps.setString(7, TongTien);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDichVu(String dvid, String soPhong, String name, String giaTien, String tuNgay, String denNgay, String chiSoCu, String chiSoMoi) {
        String sql = "INSERT INTO DichVu (DichVuID, SoPhong, Name, GiaTien, TuNgay, DenNgay, ChiSoCu, ChiSoMoi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dvid);
            ps.setString(2, soPhong);
            ps.setString(3, name);
            ps.setString(4, giaTien);
            ps.setString(5, tuNgay);
            ps.setString(6, denNgay);
            ps.setString(7, chiSoCu);
            ps.setString(8, chiSoMoi);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHoaDon(HoaDon hoadon) {
        String sql = "UPDATE HoaDon SET HopDongID = ?,NgayThanhToan= ?, TinhTrangThanhToan = ?, TuNgay = ?, DenNgay = ?, TongTien = ? WHERE HoaDonID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hoadon.getHopDongID());
            ps.setDate(2, new java.sql.Date(hoadon.getNgayThanhToan().getTime()));
            ps.setString(3, hoadon.getTinhTrangThanhToan());
            ps.setDate(4, new java.sql.Date(hoadon.getTuNgay().getTime()));
            ps.setDate(5, new java.sql.Date(hoadon.getDenNgay().getTime()));
            ps.setInt(6, hoadon.getTongTien());
            ps.setInt(7, hoadon.getHoaDonID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public int getNextHoaDonID() {
        String sql = "SELECT MAX(HoaDonID) FROM HoaDon";
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

    public int getNextDichVuID() {
        String sql = "SELECT MAX(DichVuID) FROM DichVu";
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

    public int getNextHoaDonDetailID() {
        String sql = "SELECT MAX(HoaDonDetailID) FROM HoaDonDetail";
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

    public int getNextThietBiID() {
        String sql = "SELECT MAX(ThietBiID) FROM ThietBi";
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

    public int getNextKhachID() {
        String sql = "SELECT MAX(KhachID) FROM KhachThue";
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

    public int getNextHopDongID() {
        String sql = "SELECT MAX(HopDongID) FROM HopDong";
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

    public int getNextPhongID() {
        String sql = "SELECT MAX(PhongID) FROM Phong";
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

    public int getNextKhuID() {
        String sql = "SELECT MAX(KhuID) FROM Khu";
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

    public int getNextAccountID() {
        String sql = "SELECT MAX(AccountID) FROM Accounts";
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

    public int countKhachThueByPhongID(String phongID) {
        String sql = "SELECT COUNT(*) AS SoLuongKhachThue FROM KhachThue WHERE PhongID = ? and TinhTrang = 1";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, phongID);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("SoLuongKhachThue");
                return count;
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
        return 0;
    }

    public boolean checkPhongIDcoHopDongConThue(String pid) {
        String query = "select distinct p.* from Phong p join HopDong hdong on hdong.PhongID = p.PhongID where p.PhongID = ? and hdong.TinhTrang = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
    SonDAO dao = new SonDAO();
    boolean result = dao.checkPhongIDcoHopDongConThue("2014");
    if (result) {
        System.out.println("true");
    } else {
        System.out.println("false");
    }
}
}
