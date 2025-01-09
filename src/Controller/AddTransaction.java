package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AddTransaction {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean AddTransactionUser(String package_type, double package_weight, Date createdAt, String receiptName,
        String receiptAddress, String receiptPhone) {
        int cust_id = LoginSingleton.getInstance().getID();
        Timestamp timestamp = new Timestamp(createdAt.getTime());
        int total_cost = totalCost(package_weight);
        String query = "INSERT INTO transaction (cust_id, package_type, package_weight, total_cost, created_at, receipt_name, receipt_address, receipt_phone) VALUES(?,?,?,?,?,?,?,?)";
        int type = getCategory(package_type);

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setInt(1, cust_id);
            stmt.setInt(2, type);
            stmt.setDouble(3, package_weight);
            stmt.setDouble(4, total_cost);
            stmt.setTimestamp(5, timestamp );
            stmt.setString(6, receiptName);
            stmt.setString(7, receiptAddress);
            stmt.setString(8, receiptPhone);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }

    }

    public int totalCost(double weight) {
        int cost = 0;

        cost = (int) Math.ceil(weight);
        return cost;
    }

    public int getCategory(String package_type) {
        if (package_type.equals("Regular")) {
            return 1;
        } else if (package_type.equals("Fast")) {
            return 2;
        }
        return 3;
    }
}
