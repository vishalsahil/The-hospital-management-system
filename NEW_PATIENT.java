
package hospital.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame  implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite, textFieldRoom;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1366, 768);
        panel.setBorder(new LineBorder(Color.WHITE, 13));
        panel.setBackground(new Color(160, 196, 202));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(650, 90, 450,450);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 22, 330, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 27));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(50, 105, 200, 20);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"CNICE","Driving License","Voter Id"});
        comboBox.setBounds(271, 105, 150, 20);
        comboBox.setBackground(new Color(160, 196, 202));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 135, 200, 20);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 135, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35, 165, 200, 20);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 165, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 195, 200, 20);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 15));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(160, 196, 202));
        r1.setBounds(271, 195, 70, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 15));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(160, 196, 202));
        r2.setBounds(340, 195, 93, 20);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 225, 200, 20);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 225, 150, 20);
        panel.add(textFieldDisease);



        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 255, 200, 20);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);





        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271,255,165,20);
        c1.setFont(new Font("Tahoma",Font.BOLD, 14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);



        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35, 285, 200, 20);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 285, 250, 20);
        date.setForeground(Color.black);
        date.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35, 320, 200, 20);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 320, 150, 20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(90, 460, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 460, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(1950, 1050);
        setLayout(null);
//        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()){
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";

            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try{
                String q = "insert into Patient_Info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no = "+s6;
                c. statement. executeUpdate(q);
                c. statement. executeUpdate (q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(true);
            } catch (Exception E) {
                E.printStackTrace();

            }



        }else {
            setVisible(false);
        }
    }
}