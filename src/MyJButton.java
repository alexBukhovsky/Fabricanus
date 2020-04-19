import javax.swing.*;
import java.awt.*;

public class MyJButton extends JButton {
    public MyJButton(String text, String type) {
        super(text);
        this.setBorderPainted(false);
        this.setBackground(Color.BLACK);

        if (type.equals("Menu")) {
            this.setFont(new Font("Old English Text M", Font.PLAIN, 28));
            this.setPreferredSize(new Dimension(400, 100));
        }

        else if(type.equals("Search")) {
            this.setFont(new Font("Arial", Font.PLAIN, 18));
            this.setPreferredSize(new Dimension(150, 60));
        }
        else if(type.equals("UnderJList")) {
            this.setFont(new Font("Arial", Font.PLAIN, 18));
            this.setPreferredSize(new Dimension(147, 40));
            this.setEnabled(false);
        }
        else if(type.equals("addStaff")) {
            this.setBackground( new Color(0, 173, 7) );
            this.setFont(new Font("Arial", Font.PLAIN, 18));
            this.setPreferredSize(new Dimension(290, 75));
            this.setEnabled(false);
        }
        else if(type.equals("takeOffStaff")) {
            this.setBackground( new Color(173, 6, 7) );
            this.setFont(new Font("Arial", Font.PLAIN, 18));
            this.setPreferredSize(new Dimension(290, 75));
            this.setEnabled(false);
        }
        else if (type.equals("toMenu")) {
            this.setBackground( new Color(209, 147, 0) );
            this.setFont(new Font("Arial", Font.PLAIN, 18));
            this.setPreferredSize(new Dimension(150, 60));
        }
    }
}
