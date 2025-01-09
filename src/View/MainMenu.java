package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JFrame frame;

    public MainMenu() {
        showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("UAS PBO");
        frame.setSize(400, 420);
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
            frame.dispose();
        });

        JButton historyButton = new JButton("HISTORY PAKET");
        historyButton.setBounds(43, 290, 300, 50);
        historyButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        historyButton.addActionListener(e -> {
            frame.dispose();
        });

        panel.add(logiButton);
        panel.add(regisButton);
        panel.add(transaksiButton);

        panel.add(historyButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}