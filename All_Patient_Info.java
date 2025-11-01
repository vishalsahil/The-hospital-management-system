package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {

    All_Patient_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1366,768);
        panel.setBorder(new LineBorder(Color.WHITE, 15));
        panel.setBackground(new Color(160, 196, 202));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,459);
        table.setBackground(new Color(160, 196, 202));
        panel.setFont(new Font("tahoma",Font.BOLD,12));

        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel jLabel1 = new JLabel("ID");
        jLabel1.setBounds(31,11,100,14);
        jLabel1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel1);

        JLabel jLabel2 = new JLabel("Number");
        jLabel2.setBounds(150,11,100,14);
        jLabel2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel2);

        JLabel jLabel3 = new JLabel("Name");
        jLabel3.setBounds(270,11,100,14);
        jLabel3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel3);

        JLabel jLabel4 = new JLabel("Gender");
        jLabel4.setBounds(360,11,100,14);
        jLabel4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel4);

        JLabel jLabel5 = new JLabel("Disease");
        jLabel5.setBounds(480,11,100,14);
        jLabel5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel5);

        JLabel jLabel6 = new JLabel("Room");
        jLabel6.setBounds(600,11,100,14);
        jLabel6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel6);

        JLabel jLabel7 = new JLabel("Time");
        jLabel7.setBounds(700,11,100,14);
        jLabel7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel7);

        JLabel jLabel8 = new JLabel("Deposit");
        jLabel8.setBounds(800,11,100,14);
        jLabel8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel8);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/info.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(900,120,400,450);
        panel.add(label);

        JButton button = new JButton("Black");
        button.setBounds(450,600,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground( Color.white);
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
        new All_Patient_Info();
    }
}

