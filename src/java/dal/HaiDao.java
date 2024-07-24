package dal;

import dal.HaiDao.HoaDonWithSoPhong;
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

    public int getTotalHoaDonRecords1(int accountID) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM HoaDon hd "
                    + "JOIN HopDong hdong ON hdong.HopDongID = hd.HopDongID "
                    + "JOIN Phong p ON p.PhongID = hdong.PhongID "
                    + "JOIN Khu k ON p.KhuID = k.KhuID "
                    + "JOIN Accounts a ON a.AccountID = k.AccountID "
                    + "WHERE a.AccountID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<HoaDonWithSoPhong> getHoaDonByCriteria(String soPhong, String tinhTrangThanhToan, String tuNgay, String denNgay) {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT hd.*, p.SoPhong "
                + "FROM HoaDon hd "
                + "JOIN HopDong hdg ON hdg.HopDongID = hd.HopDongID "
                + "JOIN Phong p ON p.PhongID = hdg.PhongID WHERE 1=1";

        if (soPhong != null && !soPhong.trim().isEmpty()) {
            sql += " AND p.SoPhong = ?";
        }
        if (tinhTrangThanhToan != null && !tinhTrangThanhToan.trim().isEmpty()) {
            sql += " AND hd.TinhTrangThanhToan LIKE ?";
        }
        if (tuNgay != null && !tuNgay.trim().isEmpty()) {
            sql += " AND hd.tuNgay >= ?";
        }
        if (denNgay != null && !denNgay.trim().isEmpty()) {
            sql += " AND hd.denNgay <= ?";
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int paramIndex = 1;

            if (soPhong != null && !soPhong.trim().isEmpty()) {
                ps.setString(paramIndex++, soPhong);
            }
            if (tinhTrangThanhToan != null && !tinhTrangThanhToan.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + tinhTrangThanhToan + "%");
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

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int hoaDonID = rs.getInt("HoaDonID");
                    int hopDongID = rs.getInt("HopDongID");
                    Date ngayThanhToan = rs.getDate("NgayThanhToan");
                    String tinhTrangThanhToanFromDb = rs.getString("TinhTrangThanhToan");  // Lấy giá trị từ ResultSet
                    Date tuNgayDate = rs.getDate("TuNgay");
                    Date denNgayDate = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");
                    String soPhongFromDb = rs.getString("SoPhong");  // Đảm bảo rằng `SoPhong` là một String từ ResultSet

                    // Tạo đối tượng HoaDon
                    HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, ngayThanhToan, tinhTrangThanhToanFromDb, tuNgayDate, denNgayDate, tongTien);

                    // Tạo đối tượng HoaDonWithSoPhong
                    HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, Integer.parseInt(soPhongFromDb));
                    hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonWithSoPhongList;
    }

    public List<HoaDonWithSoPhong> getHoaDonByCriteria1(String soPhong, String tinhTrangThanhToan, String tuNgay, String denNgay, int accountId) {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT hd.*, p.SoPhong "
                + "FROM HoaDon hd "
                + "JOIN HopDong hdong ON hdong.HopDongID = hd.HopDongID "
                + "JOIN Phong p ON p.PhongID = hdong.PhongID "
                + "JOIN Khu k ON p.KhuID = k.KhuID "
                + "JOIN Accounts a ON a.AccountID = k.AccountID "
                + "WHERE a.AccountID = ?";

        if (soPhong != null && !soPhong.trim().isEmpty()) {
            sql += " AND p.SoPhong = ?";
        }
        if (tinhTrangThanhToan != null && !tinhTrangThanhToan.trim().isEmpty()) {
            sql += " AND hd.TinhTrangThanhToan LIKE ?";
        }
        if (tuNgay != null && !tuNgay.trim().isEmpty()) {
            sql += " AND hd.tuNgay >= ?";
        }
        if (denNgay != null && !denNgay.trim().isEmpty()) {
            sql += " AND hd.denNgay <= ?";
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int paramIndex = 1;

            // Set AccountID
            ps.setInt(paramIndex++, accountId);

            // Set other parameters based on provided criteria
            if (soPhong != null && !soPhong.trim().isEmpty()) {
                ps.setString(paramIndex++, soPhong);
            }
            if (tinhTrangThanhToan != null && !tinhTrangThanhToan.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + tinhTrangThanhToan + "%");
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

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int hoaDonID = rs.getInt("HoaDonID");
                    int hopDongID = rs.getInt("HopDongID");
                    Date ngayThanhToan = rs.getDate("NgayThanhToan");
                    String tinhTrangThanhToanFromDb = rs.getString("TinhTrangThanhToan");
                    Date tuNgayDate = rs.getDate("TuNgay");
                    Date denNgayDate = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");
                    String soPhongFromDb = rs.getString("SoPhong");

                    // Tạo đối tượng HoaDon
                    HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, ngayThanhToan, tinhTrangThanhToanFromDb, tuNgayDate, denNgayDate, tongTien);

                    // Tạo đối tượng HoaDonWithSoPhong
                    HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, Integer.parseInt(soPhongFromDb));
                    hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonWithSoPhongList;
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

    public List<KhachThue> searchKhachThueByCriteria1(int accountID, String name, String sdt, String cccd) {
        List<KhachThue> list = new ArrayList<>();
        String sql = "SELECT Kh.* FROM KhachThue Kh "
                + "JOIN Phong P ON P.PhongID = Kh.PhongID "
                + "JOIN Khu K ON K.KhuID = P.KhuID "
                + "JOIN Accounts a ON a.AccountID = K.AccountID "
                + "WHERE a.AccountID = ?";

        if (name != null && !name.trim().isEmpty()) {
            sql += " AND Kh.HoVaTen LIKE ?";
        }
        if (sdt != null && !sdt.trim().isEmpty()) {
            sql += " AND Kh.SDT LIKE ?";
        }
        if (cccd != null && !cccd.trim().isEmpty()) {
            sql += " AND Kh.CCCD LIKE ?";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int paramIndex = 1;

            ps.setInt(paramIndex++, accountID);

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

    public List<HopDong> getHopDongByCriteria1(String soKhachThue, String hoVaTen, Date ngayThue, Date ngayTra, int accountId) {
        List<HopDong> hopDongSearch = new ArrayList<>();
        String sql = "SELECT hp.* FROM HopDong hp "
                + "JOIN Phong p ON p.PhongID = hp.PhongID "
                + "JOIN Khu k ON k.KhuID = p.KhuID "
                + "JOIN Accounts a ON a.AccountID = k.AccountID "
                + "WHERE a.AccountID = ?";

        if (soKhachThue != null && !soKhachThue.trim().isEmpty()) {
            sql += " AND hp.SoKhachThue = ?";
        }
        if (hoVaTen != null && !hoVaTen.trim().isEmpty()) {
            sql += " AND hp.HoVaTen LIKE ?";
        }
        if (ngayThue != null) {
            sql += " AND hp.NgayThue >= ?";
        }
        if (ngayTra != null) {
            sql += " AND hp.NgayTra <= ?";
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int paramIndex = 1;
            ps.setInt(paramIndex++, accountId);

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

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
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
                    hopDongSearch.add(hopDong);
                }
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

    public HoaDon getHoaDonByIdAndAccountID(int hoaDonID) {
        HoaDon hoaDon = null;
        String sql = "SELECT hd.* \n"
                + "FROM HoaDon hd\n"
                + "WHERE HoaDonID = ? ";
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

    public List<HoaDon> getHoaDonDV(int dichVuID) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT hd.* "
                + "FROM Dichvu dv "
                + "JOIN HoaDonDetail hdd ON hdd.DichVuID = dv.DichVuID "
                + "JOIN HoaDon hd ON hd.HoaDonID = hdd.HoaDonID "
                + "WHERE hd.TinhTrangThanhToan = N'Đã thanh toán' AND dv.DichVuID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dichVuID); // Set the DichVuID parameter

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int hoaDonID = rs.getInt("HoaDonID");
                    int hopDongID = rs.getInt("HopDongID");
                    Date ngayThanhToan = rs.getDate("NgayThanhToan");
                    String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                    Date tuNgay = rs.getDate("TuNgay");
                    Date denNgay = rs.getDate("DenNgay");
                    int tongTien = rs.getInt("TongTien");

                    // Create HoaDon object
                    HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, ngayThanhToan, tinhTrangThanhToan, tuNgay, denNgay, tongTien);
                    hoaDonList.add(hoaDon); // Add each HoaDon object to the list
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList; // Return the list of HoaDon objects
    }

    public int countUnreadRequests(int accountId) {
        int count = 0;
        String query = "SELECT COUNT(*) FROM Request WHERE AccountNhan =? AND TinhTrang ='0' ";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<HopDong> getHopDonghethan() {
    List<HopDong> hopDongs = new ArrayList<>();
    String sql = "SELECT * FROM HopDong h " +
                 "WHERE (" +
                     "DATEDIFF(day, h.NgayTra, GETDATE()) <= 3 " +
                     "AND DATEDIFF(day, h.NgayTra, GETDATE()) < 0 " +
                     "AND DATEDIFF(MONTH, h.NgayTra, GETDATE()) = 0 " +
                     "AND DATEDIFF(year, h.NgayTra, GETDATE()) = 0 " +
                 ") " +
                 "OR (" +
                     "DATEDIFF(day, h.NgayTra, GETDATE()) <= 3 " +
                     "AND DATEDIFF(MONTH, h.NgayTra, GETDATE()) > 0 " +
                     "AND DATEDIFF(year, h.NgayTra, GETDATE()) = 0 " +
                 ") " +
                 "OR (" +
                     "DATEDIFF(day, h.NgayTra, GETDATE()) <= 3 " +
                     "AND DATEDIFF(year, h.NgayTra, GETDATE()) > 0 " +
                 ") " +
                 "AND h.TinhTrang = 1;";

    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

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
            hopDongs.add(hopDong);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return hopDongs;
}

public List<DichVu> getDichVuTrong() {
    List<DichVu> dichVuList = new ArrayList<>();
    String sql = "SELECT * FROM Dichvu dv " +
                 "LEFT JOIN HoaDonDetail hdd ON hdd.DichVuID = dv.DichVuID " +
                 "WHERE hdd.HoaDonID IS NULL";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
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
    } finally {
        // Always close resources to avoid leaks
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
    return dichVuList;
}



    public static void main(String[] args) throws SQLException {
        HaiDao dao = new HaiDao();
        List<DichVu> dichVu = dao.getDichVuTrong();
        for (DichVu phong : dichVu) {
            System.out.println(phong);
        }
//        List<HoaDon> hoaDons = dao.getHoaDonDV(1);
//
//        // Print the retrieved HoaDon objects
//        for (HoaDon hd : hoaDons) {
//            System.out.println(hd);
//        }
    }
}
