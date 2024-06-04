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

    public List<HoaDon> getIDByHoaDonIDByPhongID(String id) {
        List<HoaDon> hoaDon = new ArrayList<>();
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
                HoaDon hoaDons = new HoaDon(hoaDonID, hopDongID, tuNgay, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                hoaDon.add(hoaDons);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDon;
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
    
    public static void main(String[] args) throws SQLException {
        SonDAO dao = new SonDAO();

        String dvid = "98";
        String soPhong = "1";
        String name = "ra";
        String giaTien = "1111111";
        String tuNgay = "2024-06-05";
        String denNgay = "2024-07-05";
        String chiSoCu = "50";
        String chiSoMoi = "60";
        
        dao.insertDichVu(dvid, soPhong, name, giaTien, tuNgay, denNgay, chiSoCu, chiSoMoi);
    }
}
