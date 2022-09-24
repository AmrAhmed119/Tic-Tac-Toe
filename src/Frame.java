import javax.swing.*;

public class Frame extends JFrame{
    Frame(){
        ImageIcon image = new ImageIcon("logo.png");
        this.setIconImage(image.getImage());
        this.setTitle("Tic-Tac-Toe");
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.add(new JLabel(new ImageIcon("background.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
    }

}
