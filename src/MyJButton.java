import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyJButton extends JButton {
    public MyJButton(String g) {
        super(g);
        this.setPreferredSize(new Dimension(400, 100));
        this.setBorderPainted(false);
        this.setBackground(Color.BLACK);
        this.setFont(new Font("Arial", Font.PLAIN, 28));
    }
}
