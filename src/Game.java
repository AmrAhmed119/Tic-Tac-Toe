import javax.swing.*;

public class Game {

    private Grid grid;
    private Frame frame;
    Game(Frame frame){
        this.frame = frame;
        JLabel backGround = new JLabel();
        backGround.setBounds(0,0,800,700);
        backGround.setIcon(new ImageIcon("grid.png"));

        grid = new Grid();
        backGround.add(grid);

        this.frame.add(backGround);

    }




}
