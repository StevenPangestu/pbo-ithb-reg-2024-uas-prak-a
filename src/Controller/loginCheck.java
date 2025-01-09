package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class loginCheck {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean Check(String pw, String phoneNum) {
        String query = "SELECT phone,passwordd FROM customer";

        String phone = "";
        String pass = "";

        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                phone = rs.getString("phone");
                pass = rs.getString("passwordd");

                if (phoneNum.equals(phone) && pass.equals(pw)) {
                    JOptionPane.showMessageDialog(null, "Welcome!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            conn.disconnect();
        }
        return false;
    }

}
