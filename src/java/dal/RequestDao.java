package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Request;
import model.Accounts;

public class RequestDao extends MyDAO {

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM Request";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public List<Request> searchRequests(int accountID, String title, Date submittedAt) {
    List<Request> requests = new ArrayList<>();
    String sql = "SELECT * FROM Request WHERE 1=1";

    List<Object> parameters = new ArrayList<>();

    if (accountID != 0) {
        sql += " AND AccountID = ?";
        parameters.add(accountID);
    }

    if (title != null && !title.isEmpty()) {
        sql += " AND Title LIKE ?";
        parameters.add("%" + title + "%");
    }

    if (submittedAt != null) {
        sql += " AND CAST(CONVERT(VARCHAR, SubmittedAt, 120) AS DATE) = ?";
        parameters.add(new java.sql.Date(submittedAt.getTime()));
    }

    try (PreparedStatement ps = con.prepareStatement(sql)) {

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
                requests.add(request);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return requests;
}

public List<Request> searchRequestsGui(int accountNhan, String title, Date submittedAt) {
    List<Request> requests = new ArrayList<>();
    String sql = "SELECT * FROM Request WHERE 1=1";

    List<Object> parameters = new ArrayList<>();

    if (accountNhan != 0) {
        sql += " AND AccountNhan = ?";
        parameters.add(accountNhan);
    }

    if (title != null && !title.isEmpty()) {
        sql += " AND Title LIKE ?";
        parameters.add("%" + title + "%");
    }

    if (submittedAt != null) {
        sql += " AND CAST(CONVERT(VARCHAR, SubmittedAt, 120) AS DATE) = ?";
        parameters.add(new java.sql.Date(submittedAt.getTime()));
    }

    try {
        ps = con.prepareStatement(sql);

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        rs = ps.executeQuery();
        while (rs.next()) {
            Request request = new Request(
                    rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
            requests.add(request);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return requests;
}

    public List<Request> getAllRequestNhan(int accountID) {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT r.* FROM Request r JOIN Accounts a ON a.AccountID = r.AccountNhan WHERE a.AccountID = ? ORDER BY r.RequestID DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public List<Request> getAllRequestGui(int accountID) {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT r.* FROM Request r JOIN Accounts a ON a.AccountID = r.AccountID WHERE a.AccountID = ? ORDER BY r.RequestID DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public List<Request> getAllRequestByRequestID(int requestID) {
        List<Request> requests = new ArrayList<>();
        String sql = "select * from Request\n"
                + "where RequestID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, requestID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("RequestID"),
                        rs.getInt("AccountID"),
                        rs.getString("Title"),

                        rs.getTimestamp("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("PhanHoi"),
                        rs.getInt("AccountNhan"),
                        rs.getInt("TinhTrang"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public void updateTinhTrang(int requestID, String tinhTrang) {
        String sql = "UPDATE [Request] SET [TinhTrang] = ? WHERE [RequestID] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tinhTrang);
            ps.setInt(2, requestID);
            ps.executeUpdate(); // Thực thi câu lệnh UPDATE
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public void updateTinhTrangPhanHoi(int requestID, String tinhTrang, String phanHoi) {
        String sql = "UPDATE [Request] SET [TinhTrang] = ?,[PhanHoi] = ? WHERE [RequestID] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tinhTrang);
            ps.setString(2, phanHoi);
            ps.setInt(3, requestID);
            ps.executeUpdate(); // Thực thi câu lệnh UPDATE
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void addRequest(int accountID, String title, String requestText, String tinhTrang, int accountNhan) {
//        String sql = "INSERT INTO Request (AccountID, Title, RequestText, TinhTrang, AccountNhan) VALUES (?, ?, ?, ?, ?)";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, accountID);
//            ps.setString(2, title);
//            ps.setString(3, requestText);
//            ps.setString(4, tinhTrang);
//            ps.setInt(5, accountNhan);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
public void addRequest(int accountID, String title, String requestText, int tinhTrang, int accountNhan, String phanHoi) {
    String sql = "INSERT INTO Request (AccountID, Title, RequestText, TinhTrang, AccountNhan, PhanHoi) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, accountID);
        ps.setString(2, title);
        ps.setString(3, requestText);
        ps.setInt(4, tinhTrang);
        ps.setInt(5, accountNhan);
        
        if (phanHoi != null) {
            ps.setString(6, phanHoi);
        } else {
            ps.setNull(6, java.sql.Types.VARCHAR);
        }
        
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void deleteRequestByRequestID(int requestID) {
        String sql = "DELETE FROM Request WHERE RequestID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, requestID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
