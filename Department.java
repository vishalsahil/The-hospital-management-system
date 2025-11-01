package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1366,768);
        panel.setBorder(new LineBorder(Color.WHITE, 13));
        panel.setLayout(null);
        panel.setBackground(new Color(160, 196, 202));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(160, 196, 202));
        table.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/department3.png"));
        Image image = imageIcon.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(800,150,450,350);
        panel.add(label);

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Hospital Department");
        label3.setBounds(870,140,400,25);
        label3.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label3);


        JButton b1 = new JButton("BACK");
        b1.setBounds(400,600,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Department();
    }
}
