import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class test extends JFrame{
    private static test view;

    private static File file = null;

    private static GroupOfStaff tmpGroup;
    private static Staff tmpStaff;

    private static JPanel panelStart;

        private static JPanel buttonsStart;
            private static MyJButton buttonNew;
            private static MyJButton buttonOpen;
            private static MyJButton buttonChoose;
            private static MyJButton buttonSave;

        private static JPanel imageStart;
            private static JLabel imageDD;


    private static JPanel panelWork;
        private static JPanel search;
            private static JTextField searchField;
            private static MyJButton searchButton;

        private static JPanel workSection;
            private static JPanel panelGroups;
                private static MyJButton addGroups;
                private static MyJButton editGroups;
                private static MyJButton deleteGroups;

            private static JPanel panelGoods;
                private static MyJButton addGood;
                private static MyJButton editGood;
                private static MyJButton deleteGood;

            private static JPanel rightSection;
                private static JPanel screen;
                private static MyJButton countPlus;
                private static MyJButton countMinus;

        private static JPanel toMenu;
            private static JButton goToMenu;


    public test() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1,1));
        this.setSize(1280, 720);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon("mj.jpg");
        this.setIconImage(icon.getImage());

    }

    public static void main(String[] args) {
      createTheme();

        view = new test();

        //setStartView();
        setWorkView();
        view.setVisible(true);
    }

    private static void setWorkView() {
        panelWork = new JPanel(new FlowLayout());

            search = new JPanel(new FlowLayout());
                searchField = new JTextField();
                searchField.setCaretColor(Color.GREEN);
                searchField.setForeground(Color.BLACK);
                searchField.setPreferredSize(new Dimension(1100,60));
                searchField.setFont(new Font("Arial", Font.PLAIN, 18));
                searchButton = new MyJButton("SEARCH","Search");
            search.add(searchField);
            search.add(searchButton);
        panelWork.add(search);


            workSection = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5));
                panelGroups = new JPanel(new FlowLayout());
                panelGroups.setBackground(Color.LIGHT_GRAY);
                panelGroups.setPreferredSize(new Dimension(460,500));
                panelGroups.setBorder(new EmptyBorder(0, 0, 0, 0));

                    ArrayList<GroupOfStaff> g = new ArrayList<GroupOfStaff>();
                    g.add(new GroupOfStaff("Group1","no description,  means "));
                    g.add(new GroupOfStaff("Group2","no description,  means "));
                    g.add(new GroupOfStaff("Group3","no description,  means "));

                    JList<GroupOfStaff> groupsList = new JList<GroupOfStaff>(g.toArray(new GroupOfStaff[g.size()]));
                    groupsList.setBackground(Color.GRAY);
                    groupsList.setFont(new Font("Arial", Font.PLAIN, 18));
                    groupsList.setPreferredSize(new Dimension(420,0));
                    JScrollPane s = new JScrollPane(groupsList);

                    s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    s.setPreferredSize(new Dimension(450,440));
                panelGroups.add(s);
                    addGroups = new MyJButton("ADD","UnderJList");
                panelGroups.add(addGroups);
                    editGroups = new MyJButton("EDIT","UnderJList");
                panelGroups.add(editGroups);
                    deleteGroups = new MyJButton("DELETE","UnderJList");
                panelGroups.add(deleteGroups);

       groupsList.addListSelectionListener (new ListSelectionListener() {

           @Override
                public void valueChanged (ListSelectionEvent evt) {
               tmpGroup = groupsList.getSelectedValue();
               addGroups.setEnabled(true);
               editGroups.setEnabled(true);
               deleteGroups.setEnabled(true);
                }
       }
       );



                panelGoods = new JPanel(new FlowLayout());
                panelGoods.setBackground(Color.LIGHT_GRAY);
                panelGoods.setPreferredSize(new Dimension(460,500));
                panelGoods.setBorder(new EmptyBorder(0, 0, 0, 0));

                ArrayList<Staff> g2 = new ArrayList<Staff>();
                g2.add(new Staff("Staff1","no description,  means ","",56,56));
                g2.add(new Staff("Staff2","no description,  means ","",56,56));
                g2.add(new Staff("Staff3","no description,  means ","",56,56));

                JList<Staff> goodsList = new JList<Staff>(g2.toArray(new Staff[g2.size()]));
                goodsList.setBackground(Color.GRAY);
                goodsList.setFont(new Font("Arial", Font.PLAIN, 18));
                goodsList.setPreferredSize(new Dimension(420,0));
                JScrollPane s2 = new JScrollPane(goodsList);

                s2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                s2.setPreferredSize(new Dimension(450,440));
                panelGoods.add(s2);
                addGood = new MyJButton("ADD","UnderJList");
                panelGoods.add(addGood);
                editGood = new MyJButton("EDIT","UnderJList");
                panelGoods.add(editGood);
                deleteGood = new MyJButton("DELETE","UnderJList");
                panelGoods.add(deleteGood);

                rightSection = new JPanel(new FlowLayout());
                rightSection.setBackground(Color.LIGHT_GRAY);
                rightSection.setPreferredSize(new Dimension(300,500));
                    screen = new JPanel(new FlowLayout());
                    screen.setBackground(Color.DARK_GRAY);
                    screen.setPreferredSize(new Dimension(290,325));
                rightSection.add(screen);
                    countPlus = new MyJButton("ADD THIS STAFF","addStaff");
                rightSection.add(countPlus);
                    countMinus = new MyJButton("TAKE OFF THIS STAFF","takeOffStaff");
                rightSection.add(countMinus);

        goodsList.addListSelectionListener (new ListSelectionListener() {

            @Override
            public void valueChanged (ListSelectionEvent evt) {
                screen.removeAll();
                tmpStaff = goodsList.getSelectedValue();
                addGood.setEnabled(true);
                editGood.setEnabled(true);
                deleteGood.setEnabled(true);
                countPlus.setEnabled(true);
                countMinus.setEnabled(true);
                JLabel info = new JLabel(tmpStaff.info());
                screen.add(info);
                screen.updateUI();
            }
        }
        );

            workSection.add(panelGroups);
            workSection.add(panelGoods);
            workSection.add(rightSection);
        panelWork.add(workSection);

            toMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT,100,15));
                goToMenu = new MyJButton("toMENU","toMenu");
                toMenu.add(goToMenu);
        panelWork.add(toMenu);



        view.add(panelWork);

        goToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                panelWork.removeAll();
                panelWork.setVisible(false);
                view.remove(panelWork);
                setStartView();
            }
        });
    }

    private static void setStartView() {
        panelStart = new JPanel(new GridLayout(1,2));

            buttonsStart = new JPanel(new FlowLayout(FlowLayout.CENTER,100,15));
            buttonsStart.setBorder(new EmptyBorder(100, 10, 10, 10));
                buttonNew = new MyJButton("NEW STORAGE","Menu");
                buttonChoose = new MyJButton("CHOOSE","Menu");
                buttonOpen = new MyJButton("OPEN","Menu");
                buttonSave = new MyJButton("SAVE","Menu");
                buttonsStart.add(buttonNew);
                buttonsStart.add(buttonChoose);
                buttonsStart.add(buttonOpen);
                buttonsStart.add(buttonSave);
                buttonsStart.setAlignmentY(SwingConstants.CENTER);
                buttonsStart.setAlignmentX(SwingConstants.CENTER);
        panelStart.add(buttonsStart);

            imageStart = new JPanel(new FlowLayout());
                ImageIcon dD = new ImageIcon("DD.jpg");
                JLabel dd = new JLabel();
                dd.setIcon(dD);
            imageStart.add(dd);
            imageStart.setVisible(true);
        panelStart.add(imageStart);

        view.add(panelStart);

        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


            }
        });

        buttonChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        file = fileChooser.getSelectedFile();
                        throw new NotStorageException();
                    } catch (NotStorageException e) {
                        e.printStackTrace();
                        JWindowsDilog er = new JWindowsDilog("NoFile",view,true);
                        er.setVisible(true);
                    }
                }
            }
        });


        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


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
        UIManager.put( "nimbusLightBackground", new Color(248, 255, 237) );
        UIManager.put( "nimbusOrange", new Color(191,98,4) );
        UIManager.put( "nimbusRed", new Color(169,46,34) );
        UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
        UIManager.put( "nimbusSelectionBackground", new Color(0, 173, 7) );
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
