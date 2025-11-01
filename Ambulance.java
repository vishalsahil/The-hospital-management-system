package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame{
    Ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1366,768);
        panel.setBorder(new LineBorder(Color.WHITE, 13));
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
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel jLabel1 = new JLabel("Name");
        jLabel1.setBounds(31,11,100,14);
        jLabel1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel1);

        JLabel jLabel2 = new JLabel("Gender");
        jLabel2.setBounds(264,11,100,14);
        jLabel2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel2);

        JLabel jLabel3 = new JLabel("Car name");
        jLabel3.setBounds(366,11,100,14);
        jLabel3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel3);

        JLabel jLabel4 = new JLabel("Available");
        jLabel4.setBounds(520,11,100,14);
        jLabel4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel4);

        JLabel jLabel5 = new JLabel("Location");
        jLabel5.setBounds(730,11,100,14);
        jLabel5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(jLabel5);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/amb2.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,310,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(900,150,400,310);
        panel.add(label);

        JButton button = new JButton("Back");
        button.setBounds(450,600,120,30);
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
        new Ambulance();


    }
}
