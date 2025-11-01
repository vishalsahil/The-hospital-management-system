package hospital.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    login() {

        // Main panel with white border
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(160, 196, 202));
        mainPanel.setBorder(new LineBorder(Color.WHITE, 7));
        mainPanel.setBounds(0, 0, 750, 350);
        add(mainPanel);

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 60, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        namelabel.setForeground(Color.BLACK);
        mainPanel.add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 120, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 19));
        password.setForeground(Color.BLACK);
        mainPanel.add(password);

        textField = new JTextField();
        textField.setBounds(150, 60, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField.setBackground(Color.WHITE);
        mainPanel.add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 120, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        jPasswordField.setBackground(Color.WHITE);
        mainPanel.add(jPasswordField);

        ImageIcon imageIcon22 = new ImageIcon(ClassLoader.getSystemResource("icon/LOGO.png"));
        Image i122 = imageIcon22.getImage().getScaledInstance(160, 180, Image.SCALE_DEFAULT);
        JLabel label22 = new JLabel(new ImageIcon(i122));
        label22.setBounds(340, 60, 180, 180);
        mainPanel.add(label22);

        ImageIcon imageIcon11 = new ImageIcon(ClassLoader.getSystemResource("icon/sahil1.png"));
        Image i11 = imageIcon11.getImage().getScaledInstance(180, 370, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(i11));
        label1.setBounds(550, -5, 180, 370);
        mainPanel.add(label1);

        b1 = new JButton("Login");
        b1.setBounds(40, 235, 120, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        mainPanel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 235, 120, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        mainPanel.add(b2);

        // Frame settings
        setUndecorated(true);
        setSize(750, 350);
        setLocation(300, 123);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "SELECT * FROM login WHERE ID = '" + user + "' AND PW = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }
}
