package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RegistrasiCheck {
    static DatabaseHandler conn = new DatabaseHandler();

    public void Regis(String phone, String nama, String alamat, String pw) {
        String queryAdd = "INSERT INTO customer (password,name, address, phone) VALUES (?,?, ?, ?)";

        System.out.println(Check(phone, nama));
        if (Check(phone, nama)) {
            try {
                System.out.println("masuk regis2");
                conn.connect();
                PreparedStatement statement = conn.con.prepareStatement(queryAdd);
                statement.setString(1, pw);
                statement.setString(2, nama);
                statement.setString(3, alamat);
                statement.setString(4, phone);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "BERHASIL REGISTER!");

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Phone & name sudah dipakai");

            } finally {
                conn.disconnect();
            }
        }

    }

    public boolean Check(String phone, String name) {

        String query = "SELECT phone,name FROM customer";
        String phoneDatabase = "";
        String nameDatabase = "";

        try {
          
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                phoneDatabase = rs.getString("phone");
                nameDatabase = rs.getString("name");

                if (phone.equals(phoneDatabase) && nameDatabase.equals(nameDatabase)) {
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
