package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import Model.Enumeration.Status;

public class AddDetailPengiriman {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean AddDetail(int trans_id, Status status, String position, String evidence, Date date,
            String updatedBy) {
        Timestamp timestamp = new Timestamp(date.getTime());
        String query = "INSERT INTO shipment_details (transaction_id,status,current_position,evidence,date,updated_by) VALUES (?,?,?,?,?,?)";

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setInt(1, trans_id);
            stmt.setString(2, status.name());
            stmt.setString(3, position);
            stmt.setString(4, evidence);
            stmt.setTimestamp(5, timestamp);
            stmt.setString(6, updatedBy);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }

    }
}
