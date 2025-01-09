package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.loginCheck;

public class loginView {

    public loginView() {
        showForm();
    }

    public void showForm() {
        JFrame frame = new JFrame();
        frame.setSize(400, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        String imagePath = "C:/steven/UAS PBO-1123019-StevenPangestu/src/logo.jpg";
        ImageIcon icon = new ImageIcon(imagePath);

        JLabel labelIcon = new JLabel(icon);
        labelIcon.setBounds(150, 20, 60, 60);
        frame.add(labelIcon);

        JLabel labelTitle = new JLabel("Pratama Group");
        labelTitle.setBounds(150, 70, 130, 45);
        frame.add(labelTitle);

        JLabel nomorLabel = new JLabel("nomor telepon : ");
        nomorLabel.setBounds(30, 140, 150, 45);
        frame.add(nomorLabel);

        JTextField nomorField = new JTextField();
        nomorField.setBounds(140, 150, 150, 30);
        frame.add(nomorField);
        
        JLabel passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(30, 210, 150, 45);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 210, 150, 30);
        frame.add(passwordField);
        
        JButton buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(140,280,150,30);
        frame.add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomor = nomorField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (!new loginCheck().Check(password, nomor)) {
                     JOptionPane.showMessageDialog(null, "LOGIN GAGAL !");
                }
                else {
                    JOptionPane.showMessageDialog(null, "BERHASIL LOGIN");
                    new MainMenu();
                }
            }
        });
        JButton buttonBack = new JButton("BACK");
        buttonBack.setBounds(30,20, 90, 30);
        frame.add(buttonBack);

        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        frame.setVisible(true);
    }
}
