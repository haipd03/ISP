package dal;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DichVu;
import model.HoaDon;

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
            return "HoaDonWithSoPhong{" +
                    "hoaDon=" + hoaDon +
                    ", soPhong=" + soPhong +
                    '}';
        }
    }

    public List<HoaDonWithSoPhong> getAllHoaDon() {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT DISTINCT hd.*, p.SoPhong " +
                     "FROM HoaDon hd " +
                     "JOIN HopDong hdg ON hdg.HopDongID = hd.HopDongID " +
                     "JOIN Phong p ON p.PhongID = hdg.PhongID";
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
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hoaDonWithSoPhongList;
    }

    public List<HoaDonWithSoPhong> getHoaDonWithPagination(int limit, int offset) {
        List<HoaDonWithSoPhong> hoaDonWithSoPhongList = new ArrayList<>();
        String sql = "SELECT hd.*, p.SoPhong " +
                     "FROM HoaDon hd " +
                     "JOIN HopDong hdg ON hdg.HopDongID = hd.HopDongID " +
                     "JOIN Phong p ON p.PhongID = hdg.PhongID " +
                     "ORDER BY hd.HoaDonID " +
                     "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
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

    public int getTotalHoaDonRecords() {
        String sql = "SELECT COUNT(*) AS total FROM HoaDon";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
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
    
    

    public static void main(String[] args) throws SQLException {
        HaiDao dao = new HaiDao();
//
//        HoaDon hoaDon = new HoaDon(21, 9, new java.util.Date(), "Paid", new java.util.Date(), new java.util.Date(), 1000);
//        
//        dao.addHoaDon(hoaDon);
        
    
        List<HoaDonWithSoPhong> listC = dao.getAllHoaDon();
       for (HoaDonWithSoPhong category : listC) {
            System.out.println(category);
        }


    }
}