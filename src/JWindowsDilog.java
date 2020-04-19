import javax.swing.*;
import java.awt.*;

public class JWindowsDilog extends JDialog {

    protected JPanel contentPane;

    public JWindowsDilog() {
        super();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setModal(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(new JLabel("ERROR"));

    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}