import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class test extends JFrame{
    private static test view;

    File File = null;

    private static JPanel panelStart;

        private static JPanel buttonsStart;
            private static MyJButton buttonOpen;
            private static MyJButton buttonChoose;
            private static MyJButton buttonSave;

        private static JPanel imageStart;
            private static JLabel imageDD;


    private static JPanel panelWork;
        private static JPanel search;

        private static JPanel workSection;

        private static JPanel toMenu;





    public test() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1,1));
        this.setSize(1280, 720);
        ImageIcon icon = new ImageIcon("mj.jpg");
        this.setIconImage(icon.getImage());

    }







    public static void main(String[] args) {
      createTheme();

        view = new test();

        setStartView();
        view.setVisible(true);
    }

    private static void setStartView() {
        panelStart = new JPanel(new GridLayout(1,2));
        buttonsStart = new JPanel(new FlowLayout(FlowLayout.CENTER,100,15));
        buttonsStart.setBorder(new EmptyBorder(150, 10, 10, 10));
        buttonChoose = new MyJButton("CHOOSE","Menu");
        buttonChoose.setBorder(null);
        buttonOpen = new MyJButton("OPEN","Menu");
        buttonSave = new MyJButton("SAVE","Menu");
        buttonsStart.add(buttonChoose);
        buttonsStart.add(buttonOpen);
        buttonsStart.add(buttonSave);
        buttonsStart.setAlignmentY(SwingConstants.CENTER);
        buttonsStart.setAlignmentX(SwingConstants.CENTER);

        imageStart = new JPanel(new FlowLayout());
        ImageIcon dD = new ImageIcon("DD.jpg");
        JLabel dd = new JLabel();
        dd.setIcon(dD);
        imageStart.add(dd);
        imageStart.setVisible(true);

        panelStart.add(buttonsStart);
        panelStart.add(imageStart);

        view.add(panelStart);



        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


            }
        });

        buttonChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileChooser = new JFileChooser();
                int returnValue =  fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File File = fileChooser.getSelectedFile();

                }
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


            }
        });


    }

    private static void createTheme() {
        UIManager.put( "control", new Color( 255, 255, 255) );
        UIManager.put( "info", new Color(128,128,128) );
        UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
        UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
        UIManager.put( "nimbusDisabledText", new Color(205, 205, 205) );
        UIManager.put( "nimbusFocus", new Color(115,164,209) );
        UIManager.put( "nimbusGreen", new Color(176,179,50) );
        UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
        UIManager.put( "nimbusLightBackground", new Color( 18, 30, 49) );
        UIManager.put( "nimbusOrange", new Color(191,98,4) );
        UIManager.put( "nimbusRed", new Color(169,46,34) );
        UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
        UIManager.put( "nimbusSelectionBackground", new Color(0, 0, 0) );
        UIManager.put( "text", new Color(244, 255, 243) );
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
