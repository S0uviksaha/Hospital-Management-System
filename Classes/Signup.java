package Classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton btnRegister, btnBack;

    Signup() {
        setTitle("Arogya Healthcare Signup");
        getContentPane().setBackground(new Color(36, 123, 160));
        setLayout(null);

        JLabel heading = new JLabel("Create New Account");
        heading.setBounds(60, 20, 300, 30);
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(60, 70, 120, 30);
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        usernameLabel.setForeground(Color.WHITE);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 70, 200, 30);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 120, 120, 30);
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 120, 200, 30);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(passwordField);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(60, 180, 150, 40);
        btnRegister.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnRegister.setBackground(new Color(40, 167, 69));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.addActionListener(this);
        add(btnRegister);

        btnBack = new JButton("Back to Login");
        btnBack.setBounds(230, 180, 150, 40);
        btnBack.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnBack.setBackground(new Color(255, 193, 7));
        btnBack.setForeground(Color.BLACK);
        btnBack.addActionListener(this);
        add(btnBack);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty");
                return;
            }

            try {
                ConnectSql connectSql = new ConnectSql();
                String checkQuery = "SELECT * FROM login WHERE USERNAME = '" + username + "'";
                ResultSet rs = connectSql.statement.executeQuery(checkQuery);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already exists");
                } else {
                    String insertQuery = "INSERT INTO login (USERNAME, PASSWORD) VALUES ('" + username + "', '" + password + "')";
                    connectSql.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Signup successful! Redirecting to login.");
                    new Login();
                    this.setVisible(false);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == btnBack) {
            new Login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }
}