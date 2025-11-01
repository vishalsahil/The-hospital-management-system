package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info(){
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1366,768);
        panel.setBorder(new LineBorder(Color.WHITE, 13));
        panel.setBackground(new Color(160, 196, 202));
        panel.setLayout(null);
        add(panel);

        JTable table =new JTable();
        table.setBounds(10,34,980,600);
        table.setBackground(new Color(160, 196, 202));
        table.setFont(new Font("Tahoma",Font.BOLD, 12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(180,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(350,9,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(550,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(730,9,70,20);
        label5.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label5);

        JLabel label6 = new JLabel("CNICE Number");
        label6.setBounds(830,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(label6);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/doctor1234.jpeg"));
        Image image = imageIcon.getImage().getScaledInstance(320,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(965,160,320,400);
        panel.add(label);


        JButton button = new JButton("BACK");
        button.setBounds(400,650,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
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
        new Employee_info();
    }

}
