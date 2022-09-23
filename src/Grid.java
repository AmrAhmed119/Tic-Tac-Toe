import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid extends JLabel implements ActionListener {

    private JButton[] buttons;

    Grid(){
        //grid
        this.setBounds(235,178,330,344);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        this.setLayout(new GridLayout(3,3,16,16));


        buttons = new JButton[9];
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(null);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }




    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
