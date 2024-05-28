package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        String sql = "SELECT DISTINCT hd.*, dv.SoPhong " +
                     "FROM HoaDon hd " +
                     "JOIN HoaDonDetail hdd ON hdd.HoaDonID = hd.HoaDonID " +
                     "JOIN DichVu dv ON dv.DichVuID = hdd.DichVuID";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int hoaDonID = rs.getInt("HoaDonID");
                int hopDongID = rs.getInt("HopDongID");
                String tinhTrangThanhToan = rs.getString("TinhTrangThanhToan");
                Date tuNgay = rs.getDate("TuNgay");
                Date denNgay = rs.getDate("DenNgay");
                int tongTien = rs.getInt("TongTien");
                int soPhong = rs.getInt("SoPhong"); // Lấy thông tin SoPhong từ bảng DichVu

                // Tạo đối tượng HoaDon
                HoaDon hoaDon = new HoaDon(hoaDonID, hopDongID, tinhTrangThanhToan, tuNgay, denNgay, tongTien);

                // Tạo đối tượng HoaDonWithSoPhong
                HoaDonWithSoPhong hoaDonWithSoPhong = new HoaDonWithSoPhong(hoaDon, soPhong);
                hoaDonWithSoPhongList.add(hoaDonWithSoPhong);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return hoaDonWithSoPhongList;
    }

    public void addHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (HoaDonID, HopDongID, TinhTrangThanhToan, TuNgay, DenNgay, TongTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hoaDon.getHoaDonID());
            ps.setInt(2, hoaDon.getHopDongID());
            ps.setString(3, hoaDon.getTinhTrangThanhToan());
            ps.setDate(4, new java.sql.Date(hoaDon.getTuNgay().getTime()));
            ps.setDate(5, new java.sql.Date(hoaDon.getDenNgay().getTime()));
            ps.setInt(6, hoaDon.getTongTien());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully added HoaDon: " + hoaDon);
            } else {
                System.out.println("Failed to add HoaDon: " + hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        HaiDao dao = new HaiDao();
//
//        HoaDon hoaDon = new HoaDon(21, 9, "Paid", new java.util.Date(), new java.util.Date(), 1000);
//        
//        dao.addHoaDon(hoaDon);
        
     
        List<HoaDonWithSoPhong> listC = dao.getAllHoaDon();
        for (HoaDonWithSoPhong category : listC) {
            System.out.println(category);
        }
    }
}
