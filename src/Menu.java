import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    Frame frame;
    MyButton SinglePlayer;
    MyButton TwoPlayers;
    MyButton Exit;
    JLabel label;

    Menu(Frame frame) {

        this.frame = frame;
        label = new JLabel();
        label.setIcon(new ImageIcon("background.png"));
        label.setBounds(0, 0, 800, 700);

        //single player button
        SinglePlayer = new MyButton("SinglePlayer");
        SinglePlayer.setBorderColor(new Color(30, 50, 54));
        SinglePlayer.setForeground(Color.WHITE);
        SinglePlayer.setBounds(270, 270, 250, 80);
        SinglePlayer.setBackground(new Color(30, 50, 54));
        SinglePlayer.setBorder(null);
        SinglePlayer.setFocusable(false);
        SinglePlayer.setFont(new Font("MV Boli", Font.ITALIC, 30));
        SinglePlayer.setRadius(50);
        SinglePlayer.addActionListener(this);
        SinglePlayer.setColorClick(new Color(30, 50, 54));
        SinglePlayer.setColor(new Color(30, 50, 54));
        SinglePlayer.setColorOver(new Color(68, 80, 112));

        //Two Players button
        TwoPlayers = new MyButton("TwoPlayers");
        TwoPlayers.setBackground(new Color(30, 50, 54));
        TwoPlayers.setForeground(Color.WHITE);
        TwoPlayers.setFocusable(false);
        TwoPlayers.setBorder(null);
        TwoPlayers.setFont(new Font("MV Boli", Font.ITALIC, 30));
        TwoPlayers.setBounds(270, 370, 250, 80);
        TwoPlayers.setRadius(50);
        TwoPlayers.addActionListener(this);
        TwoPlayers.setColorClick(new Color(30, 50, 54));
        TwoPlayers.setColor(new Color(30, 50, 54));
        TwoPlayers.setColorOver(new Color(68, 80, 112));

        //Exit button
        Exit = new MyButton("Exit");
        Exit.setBackground(new Color(30, 50, 54));
        Exit.setForeground(Color.WHITE);
        Exit.setFocusable(false);
        Exit.setBorder(null);
        Exit.setFont(new Font("MV Boli", Font.ITALIC, 30));
        Exit.setBounds(270, 470, 250, 80);
        Exit.setRadius(50);
        Exit.addActionListener(this);
        Exit.setColorClick(new Color(30, 50, 54));
        Exit.setColor(new Color(30, 50, 54));
        Exit.setColorOver(new Color(68, 80, 112));

        label.add(SinglePlayer);
        label.add(TwoPlayers);
        label.add(Exit);

        frame.add(label);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SinglePlayer) {
            this.label.setVisible(false);
            new GameScreen(frame ,  true);
        }

        if (e.getSource() == TwoPlayers) {
            this.label.setVisible(false);
            new GameScreen(frame , false);
        }

        if (e.getSource() == Exit) {
            this.frame.dispose();
            System.exit(0);
        }
    }


}
