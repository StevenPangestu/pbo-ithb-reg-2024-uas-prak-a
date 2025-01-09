package View;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.AddDetailPengiriman;
import Model.Enumeration.Status;

public class AddDetailPengirimanView {
    public AddDetailPengirimanView() {
        init();
    }

    public void init() {
        JFrame frame = new JFrame("Tambah Detail Transaksi Pengiriman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel transactionIdLabel = new JLabel("Transaction ID:");
        transactionIdLabel.setBounds(20, 20, 150, 20);
        frame.add(transactionIdLabel);

        JTextField transactionIdField = new JTextField();
        transactionIdField.setBounds(180, 20, 150, 20);
        frame.add(transactionIdField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(20, 60, 150, 20);
        frame.add(statusLabel);

        JTextField statusField = new JTextField();
        statusField.setBounds(180, 60, 150, 20);
        frame.add(statusField);

        JLabel currentPositionLabel = new JLabel("Current Position:");
        currentPositionLabel.setBounds(20, 100, 150, 20);
        frame.add(currentPositionLabel);

        JTextField currentPositionField = new JTextField();
        currentPositionField.setBounds(180, 100, 150, 20);
        frame.add(currentPositionField);

        JLabel evidenceLabel = new JLabel("Evidence:");
        evidenceLabel.setBounds(20, 140, 150, 20);
        frame.add(evidenceLabel);

        JTextField evidenceField = new JTextField();
        evidenceField.setBounds(180, 140, 150, 20);
        frame.add(evidenceField);

        JLabel updatedByLabel = new JLabel("Updated By:");
        updatedByLabel.setBounds(20, 180, 150, 20);
        frame.add(updatedByLabel);

        JTextField updatedByField = new JTextField();
        updatedByField.setBounds(180, 180, 150, 20);
        frame.add(updatedByField);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(50, 240, 100, 30);
        frame.add(saveButton);

        saveButton.addActionListener(e -> {
            Status statusEnum;
            Date date = new Date();
            int transactionId = Integer.parseInt(transactionIdField.getText());
            String getStatusField = statusField.getText();
            Status status = Status.valueOf(getStatusField);
            String currentPosition = currentPositionField.getText();
            String evidence = evidenceField.getText();
            String updatedBy = updatedByField.getText();

            if (transactionIdField == null || getStatusField.isEmpty() || currentPosition.isEmpty() || evidence.isEmpty()
                    || updatedBy.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Jangan ada yang kosong", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (new AddDetailPengiriman().AddDetail(transactionId,status,currentPosition,evidence,date,updatedBy)) {
                    JOptionPane.showMessageDialog(null, "BERHASIL ADD DETAIL");
                }
            }
            frame.dispose();
            new MainMenu();
        });
        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 240, 100, 30);
        frame.add(backButton);

        frame.setVisible(true);
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
    }
}
