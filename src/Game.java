import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JLabel implements ActionListener {
    private JButton[][] buttons;
    private XO[][] valuesGrid;
    private Player Player1 , Player2;
    private JFrame frame;

    Game(JFrame frame) {
        this.setBounds(235, 178, 330, 344);
        this.setLayout(new GridLayout(3, 3, 16, 16));
        this.frame = frame;

        buttons = new JButton[3][3];
        valuesGrid = new XO[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setContentAreaFilled(false);
                buttons[i][j].setBorder(null);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setEnabled(false);
                this.add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j] && valuesGrid[i][j] == null){
                    if (Player1.getTurn()) {
                        buttons[i][j].setIcon(Player1.getSignImage());
                        this.valuesGrid[i][j] = Player1.getSign();
                        Player1.setTurn(false);
                        Player2.setTurn(true);
                        Player1.OFF();
                        Player2.ON();
                    }else if (Player2.getTurn()){
                        buttons[i][j].setIcon(Player2.getSignImage());
                        this.valuesGrid[i][j] = Player2.getSign();
                        Player1.setTurn(true);
                        Player2.setTurn(false);
                        Player1.ON();
                        Player2.OFF();
                    }

                    XO checkF = checkFinish();
                    if (checkF == XO.X){
                        System.out.println("X");

                    }else if (checkF == XO.O){
                        System.out.println("O");
                    }else if (checkF == XO.T){
                        System.out.println("Tie");
                    }
                }
            }
        }
    }

    public XO[][] getValuesGrid(){
        return this.valuesGrid;
    }

    public XO checkFinish(){
        int x, o;
        for (int i = 0; i < 3; i++) {
            x = 0;
            o = 0;
            for (int j = 0; j < 3; j++) {
                if (this.valuesGrid[i][j] == XO.X) x++;
                else if (this.valuesGrid[i][j] == XO.O) o++;
            }
            if (x == 3) return XO.X;
            else if (o == 3) return XO.O;
        }

        for (int j = 0; j < 3; j++) {
            x = 0;
            o = 0;
            for (int i = 0; i < 3; i++) {
                if (this.valuesGrid[i][j] == XO.X) x++;
                else if (this.valuesGrid[i][j] == XO.O) o++;
            }
            if (x == 3) return XO.X;
            else if (o == 3) return XO.O;
        }

        if (this.valuesGrid[0][0] == this.valuesGrid[1][1] && this.valuesGrid[1][1] == this.valuesGrid[2][2]) return this.valuesGrid[0][0];
        else if (this.valuesGrid[0][2] == this.valuesGrid[1][1] && this.valuesGrid[1][1] == this.valuesGrid[2][0]) return this.valuesGrid[0][2];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (this.valuesGrid[i][j] == null) return null;
            }
        }

        return XO.T;
    }

    public Player getPlayer1() {
        return Player1;
    }

    public void setPlayer1(Player player1) {
        this.Player1 = player1;
    }

    public Player getPlayer2() {
        return Player2;
    }

    public void setPlayer2(Player player2) {
        this.Player2 = player2;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

}
