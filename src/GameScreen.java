import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen implements ActionListener {

    private Game game;
    private Frame frame;
    private MyButton ChooseX,ChooseO;
    private JLabel chooseXO;
    private boolean chosen,comp;
    private MyButton reset,exit;
    private JLayeredPane p;
    private JLabel backGround;
    GameScreen(Frame frame , boolean comp){
        this.frame = frame;
        this.p = new JLayeredPane();
        this.p.setBounds(0,0,800,700);

        backGround = new JLabel();
        backGround.setBounds(0,0,800,700);
        backGround.setIcon(new ImageIcon("grid.png"));
        game = new Game(frame , p);
        this.comp = comp;

        reset = new MyButton("Reset");
        reset.setBackground( new Color(0x196E7C));
        reset.addActionListener(this);
        reset.setForeground(Color.WHITE);
        reset.setFocusable(false);
        reset.setBorder(null);
        reset.setFont(new Font("MV Boli", Font.ITALIC, 30));
        reset.setBounds(30,530,100,100);
        reset.setRadius(50);
        reset.addActionListener(this);
        reset.setColorClick(new Color(30, 50, 54));
        reset.setColor(new Color(30, 50, 54));
        reset.setColorOver(new Color(68, 80, 112));

        exit = new MyButton("Exit");
        exit.setBackground( new Color(0x196E7C));
        exit.addActionListener(this);
        exit.setForeground(Color.WHITE);
        exit.setFocusable(false);
        exit.setBorder(null);
        exit.setFont(new Font("MV Boli", Font.ITALIC, 30));
        exit.setBounds(660,530,100,100);
        exit.setRadius(50);
        exit.addActionListener(this);
        exit.setColorClick(new Color(30, 50, 54));
        exit.setColor(new Color(30, 50, 54));
        exit.setColorOver(new Color(68, 80, 112));

        ChooseO = new MyButton();
        ChooseO.setIcon(new ImageIcon("O.png"));
        ChooseO.setBounds(50,30,90,90);
        ChooseO.setFocusable(false);
        ChooseO.setBorder(null);
        ChooseO.setBorderColor(new Color(0x196E7C));
        ChooseO.setBackground(new Color(0x196E7C));
        ChooseO.setRadius(40);
        ChooseO.setColor(new Color(0x196E7C));
        ChooseO.setColorOver(new Color(0x57BBC9));
        ChooseO.setColorClick(new Color(0x196E7C));
        ChooseO.addActionListener(this);

        ChooseX = new MyButton();
        ChooseX.setIcon(new ImageIcon("X.png"));
        ChooseX.setBounds(660,30,90,90);
        ChooseX.setFocusable(false);
        ChooseX.setBorder(null);
        ChooseX.setBorderColor(new Color(0x196E7C));
        ChooseX.setBackground(new Color(0x196E7C));
        ChooseX.setRadius(40);
        ChooseX.setColor(new Color(0x196E7C));
        ChooseX.setColorOver(new Color(0x57BBC9));
        ChooseX.setColorClick(new Color(0x196E7C));
        ChooseX.addActionListener(this);


        chooseXO = new JLabel();
        chooseXO.setText("Choose X or O");
        chooseXO.setHorizontalAlignment(JLabel.CENTER);
        chooseXO.setVerticalAlignment(JLabel.CENTER);
        chooseXO.setBounds(120,30,560,90);
        chooseXO.setFont(new Font("MV BOLI", Font.ITALIC | Font.BOLD, 40));
        chooseXO.setForeground(new Color(255, 255, 255));
        chooseXO.setBackground(new Color(0x196E7C));
        chooseXO.setOpaque(true);

        backGround.add(ChooseO);
        backGround.add(ChooseX);
        backGround.add(chooseXO);
        backGround.add(game);
        backGround.add(reset);
        backGround.add(exit);
        this.p.add(backGround,Integer.valueOf(0));
        this.frame.add(p);
        //this.frame.add(backGround);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ChooseO && !this.chosen){
            chooseXO.setVisible(false);

            this.game.setPlayer1(new Player(XO.O));
            this.game.getPlayer1().setSignImage(new ImageIcon("O.png"));
            this.game.getPlayer1().setTurn(true);
            this.game.getPlayer1().setComputer(false);
            this.game.getPlayer1().setButton(ChooseO);
            this.game.getPlayer1().ON();

            this.game.setPlayer2(new Player(XO.X));
            this.game.getPlayer2().setSignImage(new ImageIcon("X.png"));
            this.game.getPlayer2().setTurn(false);
            this.game.getPlayer2().setComputer(this.comp);
            this.game.getPlayer2().setButton(ChooseX);
            this.game.getPlayer2().OFF();

            this.openGrid();

            this.chosen = true;
        }

        if (e.getSource() == ChooseX && !this.chosen){
            chooseXO.setVisible(false);

            this.game.setPlayer1(new Player(XO.X));
            this.game.getPlayer1().setSignImage(new ImageIcon("X.png"));
            this.game.getPlayer1().setTurn(true);
            this.game.getPlayer1().setComputer(false);
            this.game.getPlayer1().setButton(ChooseX);
            this.game.getPlayer1().ON();


            this.game.setPlayer2(new Player(XO.O));
            this.game.getPlayer2().setSignImage(new ImageIcon("O.png"));
            this.game.getPlayer2().setTurn(false);
            this.game.getPlayer2().setComputer(this.comp);
            this.game.getPlayer2().setButton(ChooseO);
            this.game.getPlayer2().OFF();

            this.openGrid();

            this.chosen = true;
        }

        if(e.getSource() == exit){
            frame.dispose();
            System.exit(0);
        }

        if(e.getSource() == reset){
            new GameScreen(frame ,  true);

        }

    }

    public JLayeredPane getP() {
        return p;
    }


    public void openGrid(){
        JButton [][] buttons = this.game.getButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(true);
            }
        }
    }
}
