import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    XO [][] Grid = new XO[3][3];

    Grid(){
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(49, 49, 68));


        ImageIcon image = new ImageIcon("tic-tac-toe.png");
        this.setIconImage(image.getImage());

        JPanel panel = new JPanel();
        panel.setBounds(0,165,500,500);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(3,3));

        JButton[] buttons = new JButton[9];
        for (int i = 0;i < 9;i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusable(false);
            buttons[i].setBounds(new Rectangle(160,130));
            panel.add(buttons[i]);
        }

        this.add(panel);
        this.setVisible(true);

    }
}
