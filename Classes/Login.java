package Classes;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {

    JTextField textField;
    JPasswordField passwordField;
    JButton btn1, btn2;

    Login() {
        setTitle("Arogya Healthcare Login");

        // --- Set solid teal background ---
        getContentPane().setBackground(new Color(23, 95, 127));
        setLayout(null);

        // --- Heading Label ---
        JLabel heading = new JLabel("Arogya Healthcare");
        heading.setBounds(60, 10, 300, 30);
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        add(heading);

        // --- Username Label ---
        JLabel name = new JLabel("Username:");
        name.setBounds(60, 60, 120, 30);
        name.setFont(new Font("SansSerif", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        add(name);

        // --- Password Label ---
        JLabel password = new JLabel("Password:");
        password.setBounds(60, 110, 120, 30);
        password.setFont(new Font("SansSerif", Font.BOLD, 16));
        password.setForeground(Color.WHITE);
        add(password);

        // --- Username Field ---
        textField = new JTextField();
        textField.setBounds(180, 60, 200, 30);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        add(textField);

        // --- Password Field ---
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 110, 200, 30);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passwordField.setForeground(Color.BLACK);
        passwordField.setBackground(Color.WHITE); 
        add(passwordField);

        // --- Logo Image ---
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image image1 = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image1));
        imageLabel.setBounds(420, 60, 150, 150);
        add(imageLabel);

        // --- Login Button ---
        btn1 = new JButton("Login");
        btn1.setBounds(60, 170, 150, 40);
        btn1.setFont(new Font("SansSerif", Font.BOLD, 16));
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(0, 150, 136)); // Dark Teal
        btn1.setFocusPainted(false);
        add(btn1);

        // --- Cancel Button --- 
        btn2 = new JButton("Cancel");
        btn2.setBounds(230, 170, 150, 40);
        btn2.setFont(new Font("SansSerif", Font.BOLD, 16));
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(220, 53, 69)); // Soft Red
        btn2.setFocusPainted(false);
        add(btn2);

        // --- Frame Settings --- 
        setSize(650, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
