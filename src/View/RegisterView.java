package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.RegistrasiCheck;
import Controller.loginCheck;

public class RegisterView {

    public RegisterView() {
        init();
    }

    public void init() {
        JFrame frame = new JFrame();
        frame.setSize(400, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel labelTitle = new JLabel("Pratama Group");
        labelTitle.setBounds(150, 40, 130, 45);
        frame.add(labelTitle);

        JLabel nomorLabel = new JLabel("nomor telepon : ");
        nomorLabel.setBounds(30, 90, 150, 45);
        frame.add(nomorLabel);

        JTextField nomorField = new JTextField();
        nomorField.setBounds(140, 90, 150, 30);
        frame.add(nomorField);

        JLabel namaLabel = new JLabel("Nama : ");
        namaLabel.setBounds(30, 130, 150, 45);
        frame.add(namaLabel);

        JTextField namaField = new JTextField();
        namaField.setBounds(140, 130, 150, 30);
        frame.add(namaField);

        JLabel emaiLabel = new JLabel("EMAIL : ");
        emaiLabel.setBounds(30, 170, 150, 45);
        frame.add(emaiLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(140, 170, 150, 30);
        frame.add(emailField);

        JLabel alamatLabel = new JLabel("Alamat : ");
        alamatLabel.setBounds(30, 230, 150, 45);
        frame.add(alamatLabel);

        JTextField alamatField = new JTextField();
        alamatField.setBounds(140, 230, 150, 30);
        frame.add(alamatField);

        JLabel passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(30, 270, 150, 45);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 270, 150, 30);
        frame.add(passwordField);

        JButton buttonLogin = new JButton("REGISTRASI");
        buttonLogin.setBounds(140, 340, 150, 30);
        frame.add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomor = nomorField.getText();
                String nama = namaField.getText();
                String alamat = alamatField.getText();
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());

                new RegistrasiCheck().Regis(nomor, email,nama, alamat, password);

            }
        });
        JButton buttonBack = new JButton("BACK");
        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.setVisible(true);
    }
}
