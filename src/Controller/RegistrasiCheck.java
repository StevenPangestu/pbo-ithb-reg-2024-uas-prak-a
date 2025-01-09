package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RegistrasiCheck {
    static DatabaseHandler conn = new DatabaseHandler();

    public void Regis(String phone, String email, String nama, String alamat, String pw) {
        String queryAdd = "INSERT INTO customer (passwordd, email,name, address, phone) VALUES (?, ?,?, ?, ?)";

        if (Check(phone, nama)) {
            try {
                    
                conn.connect();
                PreparedStatement statement = conn.con.prepareStatement(queryAdd);
                statement.setString(1, pw);
                statement.setString(2, email);
                statement.setString(3, nama);
                statement.setString(4, alamat);
                statement.setString(5, phone);

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Phone & name sudah dipakai");

            } finally {
                conn.disconnect();
            }
        }

    }

    public boolean Check(String phone, String email) {

        String query = "SELECT phone,email FROM customer";
        String phoneDatabase = "";
        String nameDatabase = "";

        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                phoneDatabase = rs.getString("phone");
                nameDatabase = rs.getString("email");

                if (phone.equals(phoneDatabase) && nameDatabase.equals(email)) {
                    return false;
                } else {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            conn.disconnect();
        }
        return false;

    }
}
