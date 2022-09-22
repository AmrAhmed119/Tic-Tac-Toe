import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Frame(){
        this.setTitle("Tic-Tac-Toe");
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        ImageIcon image = new ImageIcon("tic-tac-toe.png");
        this.setIconImage(image.getImage());
    }


    public void setMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(49, 49, 68));
        panel.setBounds(0,0,800,700);

        JLabel label = new JLabel("Tic Tac Toe");
        label.setBounds(240,50,400,100);
        label.setBackground(new Color(49, 49, 68));
        label.setFont(new Font("MV Boli",Font.BOLD,50));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);

        JButton Play = new JButton("Play");
        JButton LeaderBoard = new JButton("LeaderBoard");
        JButton Exit = new JButton("Exit");

        Play.setBackground(new Color(30, 50, 54));
        LeaderBoard.setBackground(new Color(30, 50, 54));
        Exit.setBackground(new Color(30, 50, 54));

        Play.setForeground(Color.WHITE);
        LeaderBoard.setForeground(Color.WHITE);
        Exit.setForeground(Color.WHITE);

        Play.setFocusable(false);
        LeaderBoard.setFocusable(false);
        Exit.setFocusable(false);

        Play.setBorder(null);
        LeaderBoard.setBorder(null);
        Exit.setBorder(null);

        Play.setFont(new Font("MV Boli",Font.BOLD,30));
        LeaderBoard.setFont(new Font("MV Boli",Font.BOLD,30));
        Exit.setFont(new Font("MV Boli",Font.BOLD,30));

        Play.setBounds(270,200,250,80);
        LeaderBoard.setBounds(270,300,250,80);
        Exit.setBounds(270,400,250,80);

        Exit.addActionListener(e -> {
            this.dispose();
            System.exit(0);
        });

        Play.addActionListener(e -> {
            this.dispose();
            new Grid();
        });

        panel.add(Play);
        panel.add(LeaderBoard);
        panel.add(Exit);
        panel.add(label);
        this.add(panel);
    }

}
