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
    }
}
