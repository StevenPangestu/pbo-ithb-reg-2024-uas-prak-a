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

        JLabel title1 = new JLabel("UAS PBO");
        title1.setBounds(140, 10, 450, 50);
        title1.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title1);

        JLabel title2 = new JLabel("PESAWAT");
        title2.setBounds(135, 50, 450, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(43, 140, 300, 50);
        addButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        addButton.addActionListener(e -> {
            frame.dispose();
        });

        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(43, 210, 300, 50);
        searchButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        searchButton.addActionListener(e -> {
            frame.dispose();
        });

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(43, 280, 300, 50);
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        exitButton.addActionListener(e -> {
            frame.dispose();
        });


        panel.add(addButton);
        panel.add(searchButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}