package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBController {

    static DatabaseHandler conn = new DatabaseHandler();

    public String[] getPackageType() {
        ArrayList<String> packageType = new ArrayList<>();
    
        String query = "SELECT category_type FROM category";
        try {
           
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
         
            while (rs.next()) {
                System.out.println(rs.getString("category_type"));
                packageType.add(rs.getString("category_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        return packageType.toArray(new String[0]);
    }
}
