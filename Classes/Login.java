package Classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton btnLogin, btnCancel, btnSignup;

    Login() {
        setTitle("Arogya Healthcare Login");
        getContentPane().setBackground(new Color(23, 95, 127));
        setLayout(null);

        JLabel heading = new JLabel("Arogya Healthcare");
        heading.setBounds(60, 10, 300, 30);
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Username:");
        name.setBounds(60, 60, 120, 30);
        name.setFont(new Font("SansSerif", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        add(name);

        JLabel password = new JLabel("Password:");
        password.setBounds(60, 110, 120, 30);
        password.setFont(new Font("SansSerif", Font.BOLD, 16));
        password.setForeground(Color.WHITE);
        add(password);

        textField = new JTextField();
        textField.setBounds(180, 60, 200, 30);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 110, 200, 30);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(passwordField);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image image1 = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image1));
        imageLabel.setBounds(420, 60, 150, 150);
        add(imageLabel);

        // --- Login Button ---
        btnLogin = new JButton("Login");
        btnLogin.setBounds(60, 170, 150, 40);
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(0, 150, 136)); // Dark Teal
        btnLogin.setFocusPainted(false);
        add(btnLogin);

        // --- Cancel Button ---
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(230, 170, 150, 40);
        btnCancel.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(new Color(220, 53, 69)); // Soft Red
        btnCancel.setFocusPainted(false);
        add(btnCancel);

        // --- Frame Settings ---
        setSize(650, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            try {
                ConnectSql connectSql = new ConnectSql();
                String username = textField.getText();
                String password = String.valueOf(passwordField.getPassword());

                String query = "SELECT * FROM login WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
                ResultSet resultSet = connectSql.statement.executeQuery(query);

                if (resultSet.next()) {
                    new Reception();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnCancel) {
            System.exit(0);
        } else if (e.getSource() == btnSignup) {
            new Signup();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
