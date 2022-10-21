package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TicTacToe extends JFrame {

    //public static int znak_nr = 0;
   // public static String znak_znak = "X";
    public static int status_gry = 0;
    static String plejer1="Human";
    static String plejer2="Human";
    static boolean czyGramy =false;

    static int trybGry = 1;


    public static JLabel LabelStatus;
    public static JLabel LabelStatus_temp;
    JButton ButtonA1= new JButton();
    JButton ButtonA2= new JButton();
    JButton ButtonA3= new JButton();
    JButton ButtonB1= new JButton();
    JButton ButtonB2= new JButton();
    JButton ButtonB3= new JButton();
    JButton ButtonC1= new JButton();
    JButton ButtonC2= new JButton();
    JButton ButtonC3= new JButton();

    Board board = new Board();
    Status statusPanel = new Status();
    JPanel headerPanel = new JPanel();


    JButton ButtonPlayer1= new JButton("ButtonPlayer1");
    JButton ButtonStartReset= new JButton("Start");
    JButton ButtonPlayer2= new JButton("ButtonPlayer2");

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    JButton[] buttony=null;
    String currentLetter;
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    Game gra;


    JMenuBar menuBar;
    JMenu jMenu;

    JMenuItem MenuHumanHuman;
    JMenuItem MenuHumanRobot;
    JMenuItem MenuRobotHuman;
    JMenuItem MenuRobotRobot;
    JMenuItem MenuExit;

    public TicTacToe() {


        menuBar = new JMenuBar();
        jMenu = new JMenu("Game");
        jMenu.setMnemonic(KeyEvent.VK_G);
        jMenu.setName("MenuGame");
        MenuHumanHuman = new JMenuItem("Human vs Human", KeyEvent.VK_H);
        MenuHumanHuman.setName("MenuHumanHuman");
        MenuHumanRobot = new JMenuItem("Human vs Robot", KeyEvent.VK_R);
        MenuHumanRobot.setName("MenuHumanRobot");
        MenuRobotHuman = new JMenuItem("Robot vs Human", KeyEvent.VK_U);
        MenuRobotHuman.setName("MenuRobotHuman");
        MenuRobotRobot = new JMenuItem("Robot vs Robot", KeyEvent.VK_O);
        MenuRobotRobot.setName("MenuRobotRobot");
        MenuExit = new JMenuItem("Exit", KeyEvent.VK_X);
        MenuExit.setName("MenuExit");

        jMenu.add(MenuHumanHuman);
        jMenu.add(MenuHumanRobot);
        jMenu.add(MenuRobotHuman);
        jMenu.add(MenuRobotRobot);
        jMenu.addSeparator();
        jMenu.add(MenuExit);

        menuBar.add(jMenu);

        MenuHumanHuman.addActionListener(e -> {
                    plejer1 = "Human";
                    plejer2 = "Human";
                    //plejer1= "Robot";
                    czyGramy = true;
            ButtonStartReset.setText("Reset");
            rozpocznij_gre();
            LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");
            ButtonPlayer1.setText("Human");
            ButtonPlayer2.setText("Human");
            ButtonPlayer1.setEnabled(false);
            ButtonPlayer2.setEnabled(false);
            //rozpocznij_gre();
        });
        MenuHumanRobot.addActionListener(e -> {
            plejer1 = "Human";
            plejer2 = "Robot";
            //plejer1= "Robot";
            czyGramy = true;
            ButtonStartReset.setText("Reset");
            rozpocznij_gre();
            LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");
            ButtonPlayer1.setText("Human");
            ButtonPlayer2.setText("Robot");
            //ButtonPlayer2.setText("Human");
            //ButtonPlayer1.setText("Robot");

            ButtonPlayer1.setEnabled(false);
            ButtonPlayer2.setEnabled(false);

            ButtonA1.setEnabled(true);
            ButtonA2.setEnabled(true);
            ButtonA3.setEnabled(true);
            ButtonB1.setEnabled(true);
            ButtonB2.setEnabled(true);
            ButtonB3.setEnabled(true);
            ButtonC1.setEnabled(true);
            ButtonC2.setEnabled(true);
            ButtonC3.setEnabled(true);


            //rozpocznij_gre();
        });
        MenuRobotHuman.addActionListener(e -> {
            plejer1 = "Robot";
            plejer2 = "Human";
            //plejer1= "Robot";
            czyGramy = true;
            ButtonStartReset.setText("Reset");
            rozpocznij_gre();
            LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");
            ButtonPlayer1.setText("Robot");
            ButtonPlayer2.setText("Human");
            ButtonPlayer1.setEnabled(false);
            ButtonPlayer2.setEnabled(false);



            LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");

        });
        MenuRobotRobot.addActionListener(e -> {
            plejer1 = "Robot";
            plejer2 = "Robot";
            //plejer1= "Robot";
            czyGramy = true;
            ButtonStartReset.setText("Reset");
            LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");
            ButtonPlayer1.setText("Robot");
            ButtonPlayer2.setText("Robot");
            ButtonPlayer1.setEnabled(false);
            ButtonPlayer2.setEnabled(false);
            rozpocznij_gre();
        });
        MenuExit.addActionListener(e -> {
            System.exit(0);
        });


        LabelStatus = new JLabel("Game is not started");
        LabelStatus_temp = new JLabel("temp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(300, 300);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 450);
        this.setLayout(new BorderLayout());

       //------------ board -----------------------------------
        ButtonA1.setName("ButtonA1");
        ButtonA2.setName("ButtonA2");
        ButtonA3.setName("ButtonA3");
        ButtonB1.setName("ButtonB1");
        ButtonB2.setName("ButtonB2");
        ButtonB3.setName("ButtonB3");
        ButtonC1.setName("ButtonC1");
        ButtonC2.setName("ButtonC2");
        ButtonC3.setName("ButtonC3");

        ButtonA1.setFocusPainted(false);
        ButtonA2.setFocusPainted(false);
        ButtonA3.setFocusPainted(false);
        ButtonB1.setFocusPainted(false);
        ButtonB2.setFocusPainted(false);
        ButtonB3.setFocusPainted(false);
        ButtonC1.setFocusPainted(false);
        ButtonC2.setFocusPainted(false);
        ButtonC3.setFocusPainted(false);

        ButtonA1.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonA2.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonA3.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonB1.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonB2.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonB3.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonC1.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonC2.setFont(new Font("Arial", Font.BOLD, 40));
        ButtonC3.setFont(new Font("Arial", Font.BOLD, 40));
        // ButtonC3.setFont(new Font("Arial", Font.PLAIN, 40));

        ButtonA1.setMinimumSize(new Dimension( 80,80));

        resetuj();


        //-----------------  aktions for buttoniki
        ButtonA1.addActionListener(e->{
            // ----> 7
            ButtonA1.setEnabled(false);
            ButtonA1.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 7);
            akcjaPoPrzycisnieciu();


        });
        ButtonA2.addActionListener(e->{
            // ----> 4
            ButtonA2.setEnabled(false);
            ButtonA2.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 4);
            akcjaPoPrzycisnieciu();



        });
        ButtonA3.addActionListener(e->{
            // ----> 1
            ButtonA3.setEnabled(false);
            ButtonA3.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 1);
            akcjaPoPrzycisnieciu();



        });

        ButtonB1.addActionListener(e->{
            // ----> 8
            ButtonB1.setEnabled(false);
            ButtonB1.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 8);
            akcjaPoPrzycisnieciu();


        });
        ButtonB2.addActionListener(e->{
            // ----> 5
            ButtonB2.setEnabled(false);
            currentLetter = gra.currentLetter;
            ButtonB2.setText(currentLetter);
            gra.wstaw(currentLetter, 5);
            akcjaPoPrzycisnieciu();

        });
        ButtonB3.addActionListener(e->{
                // ----> 2
            ButtonB3.setEnabled(false);
            ButtonB3.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 2);
            akcjaPoPrzycisnieciu();




        });
        ButtonC1.addActionListener(e->{
            // ----> 9
            ButtonC1.setEnabled(false);
            ButtonC1.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 9);
            akcjaPoPrzycisnieciu();




        });
        ButtonC2.addActionListener(e->{
            // ----> 6
            ButtonC2.setEnabled(false);
            ButtonC2.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 6);
            akcjaPoPrzycisnieciu();




        });
        ButtonC3.addActionListener(e->{
            // ----> 3
            ButtonC3.setEnabled(false);
            ButtonC3.setText(gra.currentLetter);
            gra.wstaw(gra.currentLetter, 3);
            akcjaPoPrzycisnieciu();



        });

        //-----------------  aktions for buttoniki
        ButtonPlayer1.addActionListener(e->{

            if (plejer1 == "Human"){
                plejer1= "Robot";
            }else {
                plejer1= "Human";
            }
            ButtonPlayer1.setText(plejer1);
        });


        ButtonPlayer2.addActionListener(e->{
            if (plejer2 == "Human"){
                plejer2= "Robot";
            }else {
                plejer2= "Human";
            }
            ButtonPlayer2.setText(plejer2);
        });

       //-----------------  aktions for buttoniki

        board.add(ButtonA3);
        board.add(ButtonB3);
        board.add(ButtonC3);

        board.add(ButtonA2);
        board.add(ButtonB2);
        board.add(ButtonC2);

        board.add(ButtonA1);
        board.add(ButtonB1);
        board.add(ButtonC1);

        //------------ board -----------------------------------
        //------------- hader ----------------------------------


        //------------- hader ----------------------------------

        headerPanel.setLayout(new GridLayout(1,3));
        ButtonPlayer1.setName("ButtonPlayer1");
        ButtonStartReset.setName("ButtonStartReset");
        ButtonPlayer2.setName("ButtonPlayer2");
        headerPanel.add(ButtonPlayer1);
        headerPanel.add(ButtonStartReset);
        headerPanel.add(ButtonPlayer2);
        //headerPanel.add(menuBar);
        //------------ status ----------------------------------
        LabelStatus.setName("LabelStatus");
        statusPanel.add(LabelStatus);
        LabelStatus_temp.setName("LabelStatus_temp");
        statusPanel.add(LabelStatus);
        statusPanel.add(LabelStatus_temp);
        //statusPanel.setSize(450, 50);

        JLabel naglowek = new JLabel("");
        naglowek.setLayout(new GridLayout(2,1));
        //naglowek.add(menuBar);
        //naglowek.add(headerPanel);
        //naglowek.setMinimumSize(new Dimension(50,50));
        //------------ status ----------------------------------
        this.add(board,BorderLayout.CENTER);
        this.add(statusPanel,BorderLayout.PAGE_END);

        //this.add(menuBar,BorderLayout.PAGE_START);
        this.add(headerPanel,BorderLayout.PAGE_START);
        //this.add(naglowek,BorderLayout.PAGE_START);
        this.setJMenuBar(menuBar);
        setVisible(true);
        setLayout(null);
        //------------ status ----------------------------------

        ButtonStartReset.addActionListener(e->{
            if(czyGramy) {
                czyGramy = false;
                ButtonStartReset.setText("Start");
                resetuj();
            }
            else{
                czyGramy = true;
                ButtonStartReset.setText("Reset");
                rozpocznij_gre();
                }


        });


    }
    //-------------------------------------------------------------------------
    private void akcjaPoPrzycisnieciu() {
        gra.checkStatusGry();
        LabelStatus.setText(gra.currentStatus);
        if(gra.checkStatusGry()) zakonczGre();
        if (trybGry== 1|| trybGry == 2){
            int losuj = gra.losuj(currentLetter);

            currentLetter= gra.currentLetter;;

            buttony[losuj].setText(gra.currentLetter);
            gra.wstaw(currentLetter, losuj);
            LabelStatus.setText(gra.currentStatus);
           // buttony[losuj].setEnabled(false);
            if(gra.checkStatusGry())
                zakonczGre();
        }else if (trybGry == 3){




        }

        komunikatTymczasowy();
    }

    //-------------------------------------------------------------------------
    public void rozpocznij_gre(){

        gra = new Game();
        currentLetter = gra.currentLetter;
        gra.name_X=plejer1;
        gra.name_O=plejer2;

        if(plejer1=="Human" && plejer2=="Human"){
            rozpocznij_gre2();
            //tryb 0
            trybGry = 0;


        }else if(plejer1=="Human" && plejer2=="Robot") {
            rozpocznij_gre2();
            //tryb 1
            trybGry = 1;


        }else if(plejer1=="Robot" && plejer2=="Human" ) {
            rozpocznij_gre2();
           // tryb 2
            trybGry = 2;


            ButtonA1.setEnabled(true);
            ButtonA2.setEnabled(true);
            ButtonA3.setEnabled(true);
            ButtonB1.setEnabled(true);
            ButtonB2.setEnabled(true);
            ButtonB3.setEnabled(true);
            ButtonC1.setEnabled(true);
            ButtonC2.setEnabled(true);
            ButtonC3.setEnabled(true);

            akcjaPoPrzycisnieciu();






        }else {// robot vs robot
            // tryb 3
            trybGry = 3;

            ButtonPlayer1.setEnabled(false);
            ButtonPlayer2.setEnabled(false);
           // LabelStatus.setText("Game in progress");
            LabelStatus.setText(gra.currentStatus);
            int licznik = 0;
            do{
                int losuj = gra.losuj(currentLetter);

                currentLetter= gra.currentLetter;;
                buttony[losuj].setEnabled(false);
                buttony[losuj].setText(gra.currentLetter);
                gra.wstaw(currentLetter, losuj);
                LabelStatus.setText(gra.currentStatus);
                  licznik++;


            }while (!gra.checkStatusGry());

            LabelStatus.setText(gra.currentStatus);
            rysuj();
        }


}
    //-------------------------------------------------------------------------
    public void resetuj(){


        ButtonA1.setEnabled(false);
        ButtonA2.setEnabled(false);
        ButtonA3.setEnabled(false);
        ButtonB1.setEnabled(false);
        ButtonB2.setEnabled(false);
        ButtonB3.setEnabled(false);
        ButtonC1.setEnabled(false);
        ButtonC2.setEnabled(false);
        ButtonC3.setEnabled(false);

        buttony = new JButton[10];
        buttony[1]=ButtonA3;
        buttony[2]=ButtonB3;
        buttony[3]=ButtonC3;
        buttony[4]=ButtonA2;
        buttony[5]=ButtonB2;
        buttony[6]=ButtonC2;
        buttony[7]=ButtonA3;
        buttony[8]=ButtonB3;
        buttony[9]=ButtonC3;


       // znak_nr = 0;
       // znak_znak="X";

        ButtonA1.setText(" ");
        ButtonA2.setText(" ");
        ButtonA3.setText(" ");
        ButtonB1.setText(" ");
        ButtonB2.setText(" ");
        ButtonB3.setText(" ");
        ButtonC1.setText(" ");
        ButtonC2.setText(" ");
        ButtonC3.setText(" ");




        buttony =new JButton[10];
        buttony[1]=ButtonA3;
        buttony[2]=ButtonB3;
        buttony[3]=ButtonC3;
        buttony[4]=ButtonA2;
        buttony[5]=ButtonB2;
        buttony[6]=ButtonC2;
        buttony[7]=ButtonA1;
        buttony[8]=ButtonB1;
        buttony[9]=ButtonC1;


        LabelStatus.setText("Game is not started");


        ButtonPlayer1.setText("Human");
        ButtonPlayer2.setText("Human");
        plejer1="Human";
        plejer2="Human";
        ButtonPlayer1.setEnabled(true);
        ButtonPlayer2.setEnabled(true);

       // znak_nr = 0;
       // znak_znak="X";


    }
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    public void rozpocznij_gre2(){
        ButtonA1.setEnabled(true);
        ButtonA2.setEnabled(true);
        ButtonA3.setEnabled(true);
        ButtonB1.setEnabled(true);
        ButtonB2.setEnabled(true);
        ButtonB3.setEnabled(true);
        ButtonC1.setEnabled(true);
        ButtonC2.setEnabled(true);
        ButtonC3.setEnabled(true);
        ButtonPlayer1.setEnabled(false);
        ButtonPlayer2.setEnabled(false);
        //LabelStatus.setText("Game in progress");
        LabelStatus.setText("The turn of "+gra.name_X+" Player (X)");
        System.out.println(LabelStatus.getText());

    }
    //-------------------------------------------------------------------------
    public void zakonczGre(){
        ButtonA1.setEnabled(false);
        ButtonA2.setEnabled(false);
        ButtonA3.setEnabled(false);
        ButtonB1.setEnabled(false);
        ButtonB2.setEnabled(false);
        ButtonB3.setEnabled(false);
        ButtonC1.setEnabled(false);
        ButtonC2.setEnabled(false);
        ButtonC3.setEnabled(false);
        rysuj();
        LabelStatus.setText(gra.currentStatus);
       // komunikatTymczasowy();


    }
    //-------------------------------------------------------------------------
    public void rysuj(){
        for(int i = 1;i<10;i++){
            buttony[i].setText(gra.literki[i]);
        }
        int k =0;
    }
    //-------------------------------------------------------------------------
    public void komunikatTymczasowy(){
        String tekst ="";
        for(int i = 0; i<10;i++){
            String s = gra.literki[i];
            if(s ==" ") s="_";
            tekst=tekst+ s;
        }
        LabelStatus_temp.setText(tekst+": "+gra.currentStatus);
        System.out.println(tekst.substring(1,4)+tekst.substring(4,7)+tekst.substring(7,10)+":"+gra.currentStatus+":"+LabelStatus.getText());

    }

    //-------------------------------------------------------------------------
}