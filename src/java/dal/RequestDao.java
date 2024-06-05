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
                        rs.getDate("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("TinhTrang"),
                        rs.getInt("AccountNhan"));
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
        sql += " AND CONVERT(VARCHAR, SubmittedAt, 120) LIKE ?";
        parameters.add("%" + new SimpleDateFormat("MM-dd-yyyy").format(submittedAt) + "%");
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
                    rs.getDate("SubmittedAt"),
                    rs.getString("RequestText"),
                    rs.getString("TinhTrang"),
                    rs.getInt("AccountNhan"));
            requests.add(request);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return requests;
}
public static void main(String[] args) {
        RequestDao requestDao = new RequestDao();

        // Test the searchRequests method
        int accountID = 2;
        String title = "s";
        Date submittedAt = null;
        try {
            submittedAt = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2024").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Request> requests = requestDao.searchRequests(accountID, title, submittedAt);
        System.out.println("Search results:");
        for (Request request : requests) {
            System.out.println(request);
        }
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
        sql += " AND SubmittedAt = ?";
        parameters.add(submittedAt);
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
                    rs.getDate("SubmittedAt"),
                    rs.getString("RequestText"),
                    rs.getString("TinhTrang"),
                    rs.getInt("AccountNhan"));
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
                        rs.getDate("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("TinhTrang"),
                        rs.getInt("AccountNhan"));
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
                        rs.getDate("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("TinhTrang"),
                        rs.getInt("AccountNhan"));
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
                        rs.getDate("SubmittedAt"),
                        rs.getString("RequestText"),
                        rs.getString("TinhTrang"),
                        rs.getInt("AccountNhan"));
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

    public void addRequest(int accountID, String title, String requestText, String tinhTrang, int accountNhan) {
        String sql = "INSERT INTO Request (AccountID, Title, RequestText, TinhTrang, AccountNhan) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setString(2, title);
            ps.setString(3, requestText);
            ps.setString(4, tinhTrang);
            ps.setInt(5, accountNhan);
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

//    public static void main(String[] args) {
//        RequestDao requestDao = new RequestDao();
//
//        // Test deleting a request by its ID
//        int requestIDToDelete = 9; // Replace with the ID of the request you want to delete
//        requestDao.deleteRequestByRequestID(requestIDToDelete);
//        System.out.println("Deleted request with ID: " + requestIDToDelete);
//
//        // Display all requests after deletion to confirm
//        System.out.println("All requests after deletion:");
//        List<Request> allRequests = requestDao.getAllRequests();
//        for (Request request : allRequests) {
//            System.out.println(request);
//        }
//    }
//public static void main(String[] args) {
//    RequestDao requestDao = new RequestDao();
//
//    // Hiển thị tất cả các yêu cầu trước khi cập nhật
//    System.out.println("Tất cả các yêu cầu trước khi cập nhật:");
//    List<Request> allRequestsBeforeUpdate = requestDao.getAllRequests();
//    for (Request request : allRequestsBeforeUpdate) {
//        System.out.println(request);
//    }
//
//    // Cập nhật trạng thái của một yêu cầu cụ thể
//    int requestIDToUpdate = 1; // Thay thế bằng ID của yêu cầu bạn muốn cập nhật
//    String newTinhTrang = "Đã sửa";
//    requestDao.updateTinhTrang(requestIDToUpdate, newTinhTrang);
//    System.out.println("Cập nhật trạng thái của yêu cầu có ID " + requestIDToUpdate + " thành công.");
//
//    // Hiển thị tất cả các yêu cầu sau khi cập nhật
//    System.out.println("Tất cả các yêu cầu sau khi cập nhật:");
//    List<Request> allRequestsAfterUpdate = requestDao.getAllRequests();
//    for (Request request : allRequestsAfterUpdate) {
//        System.out.println(request);
//    }
//}

//     public static void main(String[] args) {
//    RequestDao requestDao = new RequestDao();
//
//    // Testing getAllRequests
//    List<Request> allRequests = requestDao.getAllRequests();
//    for (Request request : allRequests) {
//        System.out.println(request);
//    }
//
//    // Testing updateTinhTrang for a specific account ID
//    int requestID = 1; // Replace with the desired account ID
//    String tinhTrang = "Đã sửa";
//    requestDao.updateTinhTrang(requestID, tinhTrang);
//    List<Request> allRequests = requestDao.getAllRequests();
//
//}
}
