package dal;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Phong;

public class PhongDAO extends MyDAO {

    public List<Phong> getAllPhong() {
        List<Phong> phongs = new ArrayList<>();
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
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongs;
    }

    public List<Phong> getPhongByKhuID(int khuID) {
        List<Phong> phongs = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE KhuID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, khuID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int PhongID = rs.getInt("PhongID");
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
                phongs.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongs;
    }
    
public List<Phong> getPhongBySoPhong(int soPhong) {
    List<Phong> phongs = new ArrayList<>();
    String sql = "SELECT * FROM Phong WHERE SoPhong = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, soPhong);
        rs = ps.executeQuery();
        while (rs.next()) {
            int PhongID = rs.getInt("PhongID");
            int SoPhongResult = rs.getInt("SoPhong");
            int KhuID = rs.getInt("KhuID");
            String LoaiPhong = rs.getString("LoaiPhong");
            int PhongConTrong = rs.getInt("PhongConTrong");
            int Gia = rs.getInt("Gia");

            Phong phong = new Phong(PhongID, SoPhongResult, KhuID, LoaiPhong, PhongConTrong, Gia);
            phongs.add(phong);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
    return phongs;
}


  public List<Phong> addPhong(Phong phong) {
    String sql = "INSERT INTO Phong (PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia) VALUES (?, ?, ?, ?, ?, ?)";
    List<Phong> phongList = new ArrayList<>();
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, phong.getPhongID());
        ps.setInt(2, phong.getSoPhong());
        ps.setInt(3, phong.getKhuID());
        ps.setString(4, phong.getLoaiPhong());
        ps.setInt(5, phong.getPhongConTrong());
        ps.setInt(6, phong.getGia());
        ps.executeUpdate();
        phongList = getAllPhong();
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần thiết
    }
    return phongList;
}

public void deletePhongByPhongID(int phongID) {
    String sql = "DELETE FROM Phong WHERE PhongID = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, phongID);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public List<Phong> getPhongByPhongID(int phongID) {
    List<Phong> phongs = new ArrayList<>();
    String sql = "SELECT * FROM Phong WHERE PhongID = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, phongID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int PhongID = rs.getInt("PhongID");
            int SoPhong = rs.getInt("SoPhong");
            int KhuID = rs.getInt("KhuID");
            String LoaiPhong = rs.getString("LoaiPhong");
            int PhongConTrong = rs.getInt("PhongConTrong");
            int Gia = rs.getInt("Gia");

            Phong phong = new Phong(PhongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
            phongs.add(phong);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return phongs;
}
    public List<Phong> updatePhong(Phong phong) {
        String sql = "UPDATE Phong SET SoPhong = ?, KhuID = ?, LoaiPhong = ?, PhongConTrong = ?, Gia = ? WHERE PhongID = ?";
        List<Phong> phongList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, phong.getSoPhong());
            ps.setInt(2, phong.getKhuID());
            ps.setString(3, phong.getLoaiPhong());
            ps.setInt(4, phong.getPhongConTrong());
            ps.setInt(5, phong.getGia());
            ps.setInt(6, phong.getPhongID());
            ps.executeUpdate();
            phongList = getAllPhong();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return phongList;
    }

    public Phong getPhongByID(int phongID) {
        Phong phong = null;
        String sql = "SELECT * FROM Phong WHERE PhongID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, phongID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int SoPhong = rs.getInt("SoPhong");
                int KhuID = rs.getInt("KhuID");
                String LoaiPhong = rs.getString("LoaiPhong");
                int PhongConTrong = rs.getInt("PhongConTrong");
                int Gia = rs.getInt("Gia");

                phong = new Phong(phongID, SoPhong, KhuID, LoaiPhong, PhongConTrong, Gia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return phong;
    }
public boolean isPhongIDExists(int phongID) {
    String sql = "SELECT PhongID FROM Phong WHERE PhongID = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, phongID);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public boolean isSoPhongExists(int soPhong) {
    String sql = "SELECT SoPhong FROM Phong WHERE SoPhong = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, soPhong);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


}
