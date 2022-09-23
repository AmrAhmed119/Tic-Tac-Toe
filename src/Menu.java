import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    Frame frame;
    JButton SinglePlayer;
    JButton TwoPlayers;
    JButton Exit;
    JLabel label;

    Menu(Frame frame) {

        this.frame = frame;
        label = new JLabel();
        label.setIcon(new ImageIcon("background.png"));
        label.setBounds(0, 0, 800, 700);

        //single player button
        SinglePlayer = new JButton("SinglePlayer");
        SinglePlayer.setBackground(new Color(30, 50, 54));
        SinglePlayer.setForeground(Color.WHITE);
        SinglePlayer.setFocusable(false);
        SinglePlayer.setBorder(null);
        SinglePlayer.setFont(new Font("MV Boli", Font.BOLD, 30));
        SinglePlayer.setBounds(270, 270, 250, 80);
        SinglePlayer.addActionListener(this);

        //Two Players button
        TwoPlayers = new JButton("TwoPlayers");
        TwoPlayers.setBackground(new Color(30, 50, 54));
        TwoPlayers.setForeground(Color.WHITE);
        TwoPlayers.setFocusable(false);
        TwoPlayers.setBorder(null);
        TwoPlayers.setFont(new Font("MV Boli", Font.BOLD, 30));
        TwoPlayers.setBounds(270, 370, 250, 80);
        TwoPlayers.addActionListener(this);

        //Exit button
        Exit = new JButton("Exit");
        Exit.setBackground(new Color(30, 50, 54));
        Exit.setForeground(Color.WHITE);
        Exit.setFocusable(false);
        Exit.setBorder(null);
        Exit.setFont(new Font("MV Boli", Font.BOLD, 30));
        Exit.setBounds(270, 470, 250, 80);
        Exit.addActionListener(this);

        label.add(SinglePlayer);
        label.add(TwoPlayers);
        label.add(Exit);

        frame.add(label);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Exit) {
            this.frame.dispose();
            System.exit(0);

        }

        if (e.getSource() == SinglePlayer) {
            this.label.setVisible(false);
            new Game(frame);

        }

        if (e.getSource() == TwoPlayers) {
            this.label.setVisible(false);
            new Game(frame);
        }

    }


}
