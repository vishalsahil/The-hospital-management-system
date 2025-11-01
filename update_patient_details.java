package hospital.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1366,768);
        panel.setBorder(new LineBorder(Color.WHITE, 13));
        panel.setBackground(new Color(160, 196, 202));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,90,450,450);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(100,70,330,28);
        label1.setFont(new Font("Tahoma",Font.BOLD,26));
        label1.setBackground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,165,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,16));
        label2.setBackground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,165,140,27);
        panel.add(choice);

        try{
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,207,180,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,16));
        label3.setBackground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,207,140,22);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,249,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,16));
        label4.setBackground(Color.white);
        panel.add(label4);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(248,249,140,22);
        panel.add(textFieldINTIme);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,291,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,16));
        label5.setBackground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,291,140,22);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Paid (Rs) :");
        label6.setBounds(25,333,150,17);
        label6.setFont(new Font("Tahoma",Font.PLAIN,16));
        label6.setBackground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,333,140,22);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,450,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from Patient_Info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTIme.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,450,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTIme.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient_Info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'" );
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(true);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }

        });

        JButton back = new JButton("BACK");
        back.setBounds(168,450,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1950,1050);
        setLayout(null);
//        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new update_patient_details();
    }
}