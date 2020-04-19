/*import javax.swing.*;
import java.awt.*;

public class JWindowsDilog extends JDialog {

    protected JPanel contentPane;

    public JWindowsDilog(String text) {
        super(text,true);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setModal(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(new JLabel(text));

        this.setVisible(true);

    }

}*/
import javax.swing.*;
        import java.awt.*;

public class JWindowsDilog extends JDialog {
    public JWindowsDilog(String type, Frame owner, boolean modal) {
        super(owner, modal);
        initInterface(type);

    }

    private JLabel txt;

    private void initInterface(String type) {
        this.setLayout(new GridLayout(1, 1));
        this.setLocation(500, 200);
        this.setSize(350, 100);

        txt = new JLabel();

        if(type.equals("NoFile")){
            this.setTitle("Error 0");
            txt.setText("Error 0: No file or file is not storage file ");
        }
        else if(type.equals("NosdfsdfaFile")) {
            txt.setText("Error 1: Max number that you know can't be less than 2. ");
        }
        else if(type.equals("NosdafdsafFile")) {
            txt.setText("Youre right! ");
        }
        else if(type.equals("NoFsFDSFile")) {
            txt.setText("Youre wrong! ");
        }

        add(txt);
    }
}