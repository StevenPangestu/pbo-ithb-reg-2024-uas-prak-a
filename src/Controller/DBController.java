package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Classes.ShipmentDetail;
import Model.Classes.Transaction;
import Model.Enumeration.Status;

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

    public static List<Transaction> getTransaksi() {
        List<Transaction> transaksis = new ArrayList<>();
        Map<Integer, ShipmentDetail> shipmentDetailsMap = new HashMap<>();
        String transaksiQuery = "SELECT transaction_id, package_type, package_weight, total_cost, created_at FROM transaction ORDER BY created_at DESC";
        String shipquery = "SELECT transaction_id, date FROM shipment_details ORDER BY date DESC";

        try (PreparedStatement psTransaksi = conn.con.prepareStatement(transaksiQuery);
                ResultSet rsTransaksi = psTransaksi.executeQuery();
                PreparedStatement psShip = conn.con.prepareStatement(shipquery);
                ResultSet rsShip = psShip.executeQuery()) {

            while (rsTransaksi.next()) {
                Transaction transaksi = new Transaction();
                transaksi.setId(rsTransaksi.getInt("transaction_id"));
                transaksi.setPackageType(rsTransaksi.getString("package_type"));
                transaksi.setPackageWeight(rsTransaksi.getDouble("package_weight"));
                transaksi.setTotalCost(rsTransaksi.getInt("total_cost"));
                transaksi.setCreatedAt(rsTransaksi.getDate("created_at"));
                transaksis.add(transaksi);
            }

            while (rsShip.next()) {
                ShipmentDetail ship = new ShipmentDetail();
                ship.setId(rsShip.getInt("transaction_id"));
                ship.setDate(rsShip.getDate("date"));
                shipmentDetailsMap.put(ship.getId(), ship);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaksis;
    }

    public List<ShipmentDetail> getDetailTransaksi() {

        List<ShipmentDetail> ships = new ArrayList<>();
        String shipquery = "SELECT status, evidence, date, updated_by FROM shipment_detailS ORDER BY date DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.con.prepareStatement(shipquery);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShipmentDetail ship = new ShipmentDetail(0, 0, null, shipquery, shipquery, null, shipquery);
                ship.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                ship.setEvidence(rs.getString("evidence"));
                ship.setDate(rs.getDate("date"));
                ship.setUpdatedBy(rs.getString("updated_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ships;
    }
}
