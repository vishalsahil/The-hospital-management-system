package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/intro.jpeg"));
        Image image = imageIcon.getImage().getScaledInstance(900,550,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,900,550);
        add(label);

        setSize(900,550);
        setLocation(100,70);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(2000);
            setVisible(false);
            new login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();

    }
}
