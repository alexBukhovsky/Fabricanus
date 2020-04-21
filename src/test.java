import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class test extends JFrame{

    private static GroupOfStaff locTempG ;
    private static Staff locTempS ;

    private static test view;

    private static File file = null;

    private static GroupOfStaff tmpGroup;
    private static Staff tmpStaff;

    private static Storage tmpStorage;

    private static JPanel panelStart;

        private static JPanel buttonsStart;
            private static MyJButton buttonNew;
            private static MyJButton buttonOpen;
            private static MyJButton buttonChoose;
            private static MyJButton buttonSave;
            private static MyJButton buttonExit;

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
                private static JList<GroupOfStaff> groupsList;
                private static JScrollPane s;
                private static JList<GroupOfStaff> finalGroupsList;
                private static DefaultListModel  modelGroups = new DefaultListModel();

            private static JPanel panelGoods;
                private static MyJButton addGood;
                private static MyJButton editGood;
                private static MyJButton deleteGood;
                private static JList<Staff> goodsList;
                private static JScrollPane s2;
                private static JList<GroupOfStaff> finalGoodsList;
                private static DefaultListModel modelGoods;

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
        Storage st = new Storage();
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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              String searchedGood = searchField.getText();
              if (searchedGood == null) searchedGood = "Nothing";
               /*
               ТУТ тіп должен бутьб пошук НО Я ХУЙ ЗНА КАК РАБОТАТЬ З КЛАСОМ СТОРАГЕ НЕ СТВОРЮЮЧИ ЙОГО ОТАКІ ПИРОГИ =(
                display.setPreferredSize(new Dimension(270, 310));
                display.setLineWrap(true);
                display.setBackground(Color.BLACK);
                JScrollPane scrolDis = new JScrollPane(display);
                scrolDis.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrolDis.setPreferredSize(new Dimension(270,310));
                screen.add(scrolDis);
                */
            }
        });

            workSection = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5));
                panelGroups = new JPanel(new FlowLayout());
                panelGroups.setBackground(Color.LIGHT_GRAY);
                panelGroups.setPreferredSize(new Dimension(460,500));
                panelGroups.setBorder(new EmptyBorder(0, 0, 0, 0));
        groupsList = new JList<GroupOfStaff>();
        try {
            groupsList = new JList<GroupOfStaff>(Storage.groups.toArray(new GroupOfStaff[Storage.groups.size()]));
        }
        catch (NullPointerException e) {
            //e.printStackTrace();
        }
        groupsList.setBackground(Color.GRAY);
        groupsList.setFont(new Font("Arial", Font.PLAIN, 18));
        groupsList.setPreferredSize(new Dimension(420,Storage.groups.size()*26));
        s = new JScrollPane(groupsList);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(450,440));
        panelGroups.add(s);
        addGroups = new MyJButton("ADD","UnderJList");
        addGroups.setEnabled(true);
        panelGroups.add(addGroups);
        editGroups = new MyJButton("EDIT","UnderJList");
        panelGroups.add(editGroups);
        deleteGroups = new MyJButton("DELETE","UnderJList");
        panelGroups.add(deleteGroups);

        addGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JWindowsDilog dg = new JWindowsDilog("getGroupData",view,true);
                dg.setVisible(true);

                if (locTempG != null){
                    Storage.groups.add(locTempG);
                    modelGroups.addElement(locTempG);
                }

                locTempG = null;



                    groupsList.setPreferredSize(new Dimension(420,Storage.groups.size()*26));
                    groupsList.setModel(modelGroups);

                    editGroups.setEnabled(false);
                    deleteGroups.setEnabled(false);
                    addGood.setEnabled(false);
                    editGood.setEnabled(false);
                    deleteGood.setEnabled(false);
                    countPlus.setEnabled(false);
                    countMinus.setEnabled(false);

            }
        });
        deleteGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                GroupOfStaff locTemp = groupsList.getSelectedValue();
                try {
                    Storage.groups.remove(locTemp);
                    System.out.println(modelGroups.removeElement(locTemp));
                }
                catch (NullPointerException e) {
                    //e.printStackTrace();
                }
                finally {
                    groupsList.setModel(modelGroups);
                    addGood.setEnabled(false);
                    editGood.setEnabled(false);
                    deleteGood.setEnabled(false);
                    countPlus.setEnabled(false);
                    countMinus.setEnabled(false);
                    editGroups.setEnabled(false);
                    deleteGroups.setEnabled(false);
                }
            }
        });
        groupsList.addListSelectionListener (new ListSelectionListener() {
                                                 @Override
                                                 public void valueChanged(ListSelectionEvent evt) {
                                                     tmpGroup = groupsList.getSelectedValue();
                                                     editGroups.setEnabled(true);
                                                     deleteGroups.setEnabled(true);
                                                     addGood.setEnabled(true);
                                                     editGood.setEnabled(false);
                                                     deleteGood.setEnabled(false);
                                                     countPlus.setEnabled(false);
                                                     countMinus.setEnabled(false);
                                                     modelGoods = new DefaultListModel();
                                                     try {
                                                         modelGoods.addAll(tmpGroup.staffs);
                                                     }
                                                     catch (NullPointerException e) {

                                                     }
                                                     finally {
                                                         goodsList.setModel(modelGoods);
                                                     }
                                                 }
                                             }
        );


                panelGoods = new JPanel(new FlowLayout());
                panelGoods.setBackground(Color.LIGHT_GRAY);
                panelGoods.setPreferredSize(new Dimension(460,500));
                panelGoods.setBorder(new EmptyBorder(0, 0, 0, 0));
        goodsList = new JList<Staff>();
        modelGoods = new DefaultListModel();
        try {
            goodsList = new JList<Staff>(tmpGroup.staffs.toArray(new Staff[tmpGroup.staffs.size()]));
        }
        catch (NullPointerException e) {
            //e.printStackTrace();
        }
        goodsList.setBackground(Color.GRAY);
        goodsList.setFont(new Font("Arial", Font.PLAIN, 18));
        goodsList.setPreferredSize(new Dimension(420,0));
        s2 = new JScrollPane(goodsList);

        s2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s2.setPreferredSize(new Dimension(450,440));
        panelGoods.add(s2);
        addGood = new MyJButton("ADD","UnderJList");
        panelGoods.add(addGood);
        editGood = new MyJButton("EDIT","UnderJList");
        panelGoods.add(editGood);
        deleteGood = new MyJButton("DELETE","UnderJList");
        panelGoods.add(deleteGood);
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
                                                    if(tmpStaff!=null) {
                                                        //Panel with INFO about good
                                                        JTextArea display = new JTextArea(tmpStaff.getInfo());
                                                        display.setPreferredSize(new Dimension(270, 310));
                                                        display.setLineWrap(true);
                                                        display.setBackground(Color.BLACK);
                                                        JScrollPane scrolDis = new JScrollPane(display);
                                                        scrolDis.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                                                        scrolDis.setPreferredSize(new Dimension(270,310));
                                                        screen.add(scrolDis);
                                                    }
                                                    screen.updateUI();
                                                }
                                            }
        );
        addGood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JWindowsDilog dg = new JWindowsDilog("getStaffData",view,true);
                dg.setVisible(true);

                if (locTempS != null){
                    tmpGroup.addStaffToGroup(locTempS);
                    modelGoods.addElement(locTempS);
                    goodsList.setPreferredSize(new Dimension(420,tmpGroup.staffs.size()*26));
                }

                locTempS = null;
                    goodsList.setModel(modelGoods);
                    editGood.setEnabled(false);
                    deleteGood.setEnabled(false);
                    countPlus.setEnabled(false);
                    countMinus.setEnabled(false);

            }
        });
        deleteGood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                tmpGroup.staffs.remove(goodsList.getSelectedValue());
                try {
                    modelGoods.removeElement(goodsList.getSelectedValue());
                    goodsList.setModel(modelGoods);
                    editGood.setEnabled(false);
                    deleteGood.setEnabled(false);
                    countPlus.setEnabled(false);
                    countMinus.setEnabled(false);
                }
                catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        });


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

            buttonsStart = new JPanel(new FlowLayout(FlowLayout.CENTER,50,15));
            buttonsStart.setBorder(new EmptyBorder(40, 10, 10, 10));
                buttonNew = new MyJButton("NEW STORAGE","Menu");
                buttonChoose = new MyJButton("CHOOSE","Menu");
                buttonOpen = new MyJButton("OPEN","Menu");
                buttonSave = new MyJButton("SAVE","Menu");
                buttonExit = new MyJButton("EXIT","Menu");
                buttonExit.setBackground(new Color(173, 6, 7) );
                buttonsStart.add(buttonNew);
                buttonsStart.add(buttonChoose);
                buttonsStart.add(buttonOpen);
                buttonsStart.add(buttonSave);
                buttonsStart.add(buttonExit);
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
                panelStart.removeAll();
                panelStart.setVisible(false);
                view.remove(panelStart);
                setWorkView();
            }
        });

        buttonChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setBackground(Color.BLACK);
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
                try {
                    showSaveDialog(Storage.makeSave());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });


    }

    private static void createTheme() {
        UIManager.put( "control", new Color( 255, 255, 255) );
        UIManager.put( "info", new Color(128,128,128) );
        UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
        UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
        UIManager.put( "nimbusDisabledText", new Color(122, 4, 5) );
        UIManager.put( "nimbusFocus", new Color(115,164,209) );
        UIManager.put( "nimbusGreen", new Color(176,179,50) );
        UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
        UIManager.put( "nimbusLightBackground", new Color(84, 88, 109) );
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

    public static void showSaveDialog(File file) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setForeground(Color.BLACK);
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(view);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileAddress = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileAddress.getAbsolutePath());
            Files.copy(file.toPath(), fileAddress.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }


    private static class JWindowsDilog extends JDialog {
        public JWindowsDilog(String type, Frame owner, boolean modal) {
            super(owner, modal);
            initInterface(type);
            txt = new JLabel();
            name.setForeground(Color.BLACK);
            prod.setForeground(Color.BLACK);
            description.setForeground(Color.BLACK);
            count.setForeground(Color.BLACK);
            price.setForeground(Color.BLACK);
        }

        private JLabel txt;

         JTextField name = new JTextField("");
         JTextArea description = new JTextArea("");
         JTextField prod = new JTextField("");
         JTextField count = new JTextField("");
         JTextField price = new JTextField("");


        private void initInterface(String type) {
            this.setLocation(500, 200);
            this.setSize(350, 300);


            if(type.equals("NoFile")){
                this.setLayout(new GridLayout(1, 1));
                this.setTitle("Error 0");
                txt.setText("Error 0: No file or file is not storage file ");
                add(txt);
            }
            else if(type.equals("getGroupData")) {
                this.setLayout(new GridLayout(5, 1));
                this.setTitle( " Group constructor  ");
                JLabel txt1 = new JLabel("Name of group: ");
                txt1.setForeground(Color.BLACK);
                this.add(txt1);
                this.add(name);
                JLabel txt2 = new JLabel("Description: ");
                txt2.setForeground(Color.BLACK);
                this.add(txt2);
                this.add(description);
                MyJButton submit1 = new MyJButton("ADD GROUP","Dialog");
                this.add(submit1);

                submit1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                      if(name.getText() != null && description.getText() != null) {
                          locTempG = new GroupOfStaff(name.getText(),description.getText());
                          setVisible(false);
                          dispose();
                      }
                    }
                });

            }

            else if(type.equals("getStaffData")) {
                this.setLocation(500, 200);
                this.setSize(350, 630);
                this.setLayout(new GridLayout(11, 1));
                this.setTitle( " Staff constructor  ");
                JLabel txt1 = new JLabel("Name of staff: ");
                txt1.setForeground(Color.BLACK);
                this.add(txt1);
                this.add(name);
                JLabel txt2 = new JLabel("Description: ");
                txt2.setForeground(Color.BLACK);
                this.add(txt2);
                this.add(description);
                JLabel txt3 = new JLabel("Producer: ");
                txt3.setForeground(Color.BLACK);
                this.add(txt3);
                this.add(prod);
                JLabel txt4 = new JLabel("Count: ");
                txt4.setForeground(Color.BLACK);
                this.add(txt4);
                this.add(count);
                JLabel txt5 = new JLabel("Price: ");
                txt5.setForeground(Color.BLACK);
                this.add(txt5);
                this.add(price);
                MyJButton submit2 = new MyJButton("ADD STAFF","Dialog");
                this.add(submit2);

                submit2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if(name.getText() != null && description.getText() != null && prod.getText() != null && isCount(price.getText()) == true && isCount(count.getText()) == true ) {
                            locTempS = new Staff(name.getText(),description.getText(),prod.getText(),Integer.parseInt(count.getText()),Integer.parseInt(price.getText()));
                            setVisible(false);
                            dispose();
                        }
                    }
                });

            }

            else if(type.equals("NosdafdsafFile")) {
                txt.setText("Youre right! ");
            }
            else if(type.equals("NoFsFDSFile")) {
                txt.setText("Youre wrong! ");
            }


        }

        private boolean isCount(String s){
            boolean res = true;
            for(int i = 0; i<s.length() ; i++){
                if(s.charAt(i)<0 || s.charAt(i)>9) res = false;
            }
            return res;
         }

    }
}
