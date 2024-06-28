package dal;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Accounts;
import model.DichVu;
import model.HoaDon;
import model.HopDong;
import model.KhachThue;

/**
 *
 * @author admin
 */
public class HaiDao extends MyDAO {

    public class HoaDonWithSoPhong {

        private HoaDon hoaDon;
        private int soPhong;

        public HoaDonWithSoPhong(HoaDon hoaDon, int soPhong) {
            this.hoaDon = hoaDon;
            this.soPhong = soPhong;
        }

        public HoaDon getHoaDon() {
            return hoaDon;
        }

        public void setHoaDon(HoaDon hoaDon) {
            this.hoaDon = hoaDon;
        }

        public int getSoPhong() {
            return soPhong;
        }

        public void setSoPhong(int soPhong) {
            this.soPhong = soPhong;
        }

        @Override
        public String toString() {
            return "HoaDonWithSoPhong{"
                    + "hoaDon=" + hoaDon
                    + ", soPhong=" + soPhong
                    + '}';
        }
    }

    public List<HoaDonWithSoPhong> getAllHoaDon() {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT DISTINCT hd.*, p.SoPhong "
                + "FROM HoaDon hd "
                + "JOIN HopDong hdg ON hdg.HopDongID = hd.HopDongID "
                + "JOIN Phong p ON p.PhongID = hdg.PhongID";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                Date NgayThanhToan = rs.getDate("NgayThanhToan");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");
                int soPhong = rs.getInt("SoPhong"); // Lấy thông tin SoPhong từ bảng Phong

                // Tạo đối tượng HoaDon
                HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);

                // Tạo đối tượng HoaDonWithSoPhong
                HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, soPhong);
                hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        } finally {
            // Đóng tài nguyên
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
        return hoaDonWithSoPhongList;
    }

    public List<HoaDonWithSoPhong> getHoaDonWithPagination(int limit, int offset) {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT hd.*, p.SoPhong "
                + "FROM HoaDon hd "
                + "JOIN HopDong hdg ON hdg.HopDongID = hd.HopDongID "
                + "JOIN Phong p ON p.PhongID = hdg.PhongID "
                + "ORDER BY hd.HoaDonID "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int hoaDonID = rs.getInt("HoaDonID");
                    int hopDongID = rs.getInt("HopDongID");
                    Date NgayThanhToan = rs.getDate("NgayThanhToan");
                    String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                    Date tuNgay = rs.getDate("TuNgay");
                    Date denNgay = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");
                    int soPhong = rs.getInt("SoPhong");

                    HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                    HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, soPhong);
                    hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonWithSoPhongList;
    }

    public List<HoaDonWithSoPhong> getHoaDonWithPaginationAndAccountID(int aid, int limit, int offset) {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT hd.*, p.SoPhong \n"
                + "FROM HoaDon hd \n"
                + "JOIN HopDong hdong ON hdong.HopDongID = hd.HopDongID\n"
                + "JOIN Phong p ON p.PhongID = hdong.PhongID\n"
                + "JOIN Khu k ON p.KhuID = k.KhuID \n"
                + "JOIN Accounts a ON a.AccountID = k.AccountID \n"
                + "WHERE a.AccountID = ?\n"
                + "ORDER BY hd.HoaDonID \n"
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, aid);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int hoaDonID = rs.getInt("HoaDonID");
                    int hopDongID = rs.getInt("HopDongID");
                    Date NgayThanhToan = rs.getDate("NgayThanhToan");
                    String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                    Date tuNgay = rs.getDate("TuNgay");
                    Date denNgay = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");
                    int soPhong = rs.getInt("SoPhong");

                    HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                    HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, soPhong);
                    hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonWithSoPhongList;
    }

    public int getTotalHoaDonRecords() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM HoaDon";
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

    public void addHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (HoaDonID, HopDongID,NgayThanhToan, TinhTrangThanhToan, TuNgay, DenNgay, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hoaDon.getHoaDonID());
            ps.setInt(2, hoaDon.getHopDongID());
            ps.setDate(3, hoaDon.getNgayThanhToan() != null ? new java.sql.Date(hoaDon.getNgayThanhToan().getTime()) : null);
            ps.setString(4, hoaDon.getTinhTrangThanhToan());
            ps.setDate(5, hoaDon.getTuNgay() != null ? new java.sql.Date(hoaDon.getTuNgay().getTime()) : null);
            ps.setDate(6, hoaDon.getDenNgay() != null ? new java.sql.Date(hoaDon.getDenNgay().getTime()) : null);
            ps.setInt(7, hoaDon.getTongTien());
            int rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonById(int hoaDonID) {
        HoaDon hoaDon = null;
        String sql = "SELECT * FROM HoaDon WHERE HoaDonID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hoaDonID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int hopDongID = rs.getInt("HopDongID");
                    Date NgayThanhToan = rs.getDate("NgayThanhToan");

                    String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                    Date tuNgay = rs.getDate("TuNgay");
                    Date denNgay = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");

                    hoaDon = new HoaDon(hoaDonID, hopDongID, NgayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDon;
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

    public void deleteHoaDon(String HoaDonID) throws SQLException {
        String sql = "DELETE FROM HoaDon WHERE HoaDonID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, HoaDonID);
            ps.executeUpdate();
        }
    }

    public void deleteHoaDonDetail(String HoaDonDetailID) throws SQLException {
        String sql = "DELETE FROM HoaDonDetail WHERE HoaDonDetailID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, HoaDonDetailID);
            ps.executeUpdate();
        }
    }

    public List<KhachThue> searchKhachThueByCriteria(String name, String sdt, String cccd) {
        List<KhachThue> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachThue WHERE 1=1";

        if (name != null && !name.trim().isEmpty()) {
            sql += " AND HoVaTen LIKE ?";
        }
        if (sdt != null && !sdt.trim().isEmpty()) {
            sql += " AND SDT LIKE ?";
        }
        if (cccd != null && !cccd.trim().isEmpty()) {
            sql += " AND CCCD LIKE ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;

            if (name != null && !name.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
            }
            if (sdt != null && !sdt.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + sdt + "%");
            }
            if (cccd != null && !cccd.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + cccd + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachThue kt = new KhachThue(
                        rs.getInt("KhachID"),
                        rs.getString("HoVaTen"),
                        rs.getString("CCCD"),
                        rs.getString("SDT"),
                        rs.getString("QueQuan"),
                        rs.getString("TenNguoiThan"),
                        rs.getString("SDTNguoiThan"),
                        rs.getString("QuanHeVoiNguoiThan"),
                        rs.getInt("PhongID"),
                        rs.getInt("TinhTrang")
                );
                list.add(kt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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

    public List<HopDong> getHopDongByCriteria(String soKhachThue, String hoVaTen, Date ngayThue, Date ngayTra) {
        List<HopDong> hopDongSearch = new ArrayList<>();
        String sql = "SELECT * FROM HopDong WHERE 1=1";

        if (soKhachThue != null && !soKhachThue.trim().isEmpty()) {
            sql += " AND SoKhachThue = ?";
        }
        if (hoVaTen != null && !hoVaTen.trim().isEmpty()) {
            sql += " AND HoVaTen LIKE ?";
        }
        if (ngayThue != null) {
            sql += " AND NgayThue >= ?";
        }
        if (ngayTra != null) {
            sql += " AND NgayTra <= ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;
            if (soKhachThue != null && !soKhachThue.trim().isEmpty()) {
                ps.setString(paramIndex++, soKhachThue);
            }
            if (hoVaTen != null && !hoVaTen.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + hoVaTen + "%");
            }
            if (ngayThue != null) {
                ps.setDate(paramIndex++, new java.sql.Date(ngayThue.getTime()));
            }
            if (ngayTra != null) {
                ps.setDate(paramIndex++, new java.sql.Date(ngayTra.getTime()));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Create HopDong object from ResultSet
                HopDong hopDong = new HopDong(
                        rs.getInt("HopDongID"),
                        rs.getInt("KhachID"),
                        rs.getInt("PhongID"),
                        rs.getInt("TienCoc"),
                        rs.getDate("NgayThue"),
                        rs.getDate("NgayTra"),
                        rs.getInt("SoKhachThue"),
                        rs.getString("GhiChu"),
                        rs.getString("CCCD"),
                        rs.getString("SDT"),
                        rs.getString("HoVaTen"),
                        rs.getInt("TinhTrang")
                );
                // Add HopDong object to the list
                hopDongSearch.add(hopDong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return hopDongSearch;
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
                String cccd = rs.getString("CCCD");
                String sdt = rs.getString("SDT");
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

    public List<HopDong> getHopDong(int offset, int limit) {
        List<HopDong> HopDongs = new ArrayList<>();
        String sql = "SELECT * FROM HopDong ORDER BY HopDongID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
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
                String cccd = rs.getString("CCCD");
                String sdt = rs.getString("SDT");
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

    public int getTotalHopDongCount() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM HopDong";
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

    public Accounts getAccountByEmail(String email) {
        Accounts account = null;
        String sql = "SELECT * FROM Accounts WHERE Email = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int accountID = rs.getInt("AccountID");
                    String taiKhoan = rs.getString("TaiKhoan");
                    String password = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String hoVaTen = rs.getString("HoVaTen");
                    String cccd = rs.getString("CCCD");
                    String diaChi = rs.getString("DiaChi");

                    account = new Accounts(accountID, taiKhoan, password, role, hoVaTen, email, cccd, diaChi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public static void main(String[] args) throws SQLException {
        HaiDao dao = new HaiDao();
        Accounts Accounts = dao.getAccountByEmail("phanhai@gmail.com");
        System.out.println(Accounts);

    }
}
