package View;

import javax.swing.*;

import Controller.LoginSingleton;

import java.awt.*;

public class MainMenu {
    private JFrame frame;

    public MainMenu() {
        showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("UAS PBO");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton logiButton = new JButton("LOGIN");
        logiButton.setBounds(43, 80, 300, 50);
        logiButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        logiButton.addActionListener(e -> {
            frame.dispose();
            new loginView();
        });

        JButton regisButton = new JButton("REGISTRASI");
        regisButton.setBounds(43, 150, 300, 50);
        regisButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        regisButton.addActionListener(e -> {
            frame.dispose();
            new RegisterView();
        });

        JButton transaksiButton = new JButton("TRANSAKSI PENGIRIMAN");
        transaksiButton.setBounds(43, 220, 300, 50);
        transaksiButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        transaksiButton.addActionListener(e -> {
            if (LoginSingleton.getInstance().getID() == 0) {

                JOptionPane.showMessageDialog(null, "LOGIN DULU", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new AddTransactionView();
            }

        });

        JButton historyButton = new JButton("HISTORY PAKET");
        historyButton.setBounds(43, 290, 300, 50);
        historyButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        historyButton.addActionListener(e -> {
            frame.dispose();
            new lihatHistoryView();
        });

        JButton addDetailButton = new JButton("TAMBAH DETAIL PENGIRIMAN");
        addDetailButton.setBounds(40, 360, 330, 50);
        addDetailButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        addDetailButton.addActionListener(e -> {
            if (LoginSingleton.getInstance().getID() == 0) {
                JOptionPane.showMessageDialog(null, "LOGIN DULU", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new AddDetailPengirimanView();
            }

        });

        panel.add(logiButton);
        panel.add(regisButton);
        panel.add(transaksiButton);
        panel.add(historyButton);
        panel.add(addDetailButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}