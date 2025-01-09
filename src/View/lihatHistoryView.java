package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.DBController;
import Model.Classes.ShipmentDetail;
import Model.Classes.Transaction;

public class lihatHistoryView {
    private List<Transaction> rowData;

    public lihatHistoryView() {
        HistoryView();
    }

    public void HistoryView() {
        
        JFrame frame = new JFrame("Lihat History Paket");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
String[] columnNames = { "Transaction ID", "Package Type", "Package Weight", "Total Cost", "Created At",
                "Updated At" };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        List<Transaction> transaksis = DBController.getTransaksi();
        Map<Integer, ShipmentDetail> shipmentDetailsMap = new HashMap<>();
        for (Transaction transaksi : transaksis) {
            ShipmentDetail ship = shipmentDetailsMap.get(transaksi.getId());
            model.addRow(new Object[]{
                    transaksi.getId(),
                    transaksi.getPackageType(),
                    transaksi.getPackageWeight(),
                    transaksi.getTotalCost(),
                    transaksi.getCreatedAt(),
                    (ship != null) ? ship.getDate() : null 
            });
        }

        JTable table = new JTable(model);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(new Color(56, 243, 240));
                } else {
                    c.setBackground(new Color(102, 204, 255));
                }

                return c;
            }
        };
        for (int i = 0; i < table.getColumnCount(); i++) {
            
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 80, 600, 100);

        frame.add(scrollPane, BorderLayout.CENTER);
    }
}
