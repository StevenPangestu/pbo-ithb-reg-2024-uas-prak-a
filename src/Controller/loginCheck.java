package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class loginCheck {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean Check(String pw, String phoneNum) {
        String query = "SELECT cust_id,phone,password FROM customer";

        String phone = "";
        String pass = "";
        int id = 0;
        boolean succeed = false;

        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                phone = rs.getString("phone");
                pass = rs.getString("password");
                id = rs.getInt("cust_id");
             
                if (phoneNum.equals(phone) && pw.equals(pass)) {    
                    LoginSingleton.getInstance().setID(id);
                    succeed = true;
                    break;
                } else {
                    succeed = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            conn.disconnect();
        }
        return succeed;
    }

}
