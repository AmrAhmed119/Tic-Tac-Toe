import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JLabel implements ActionListener {
    private JButton[][] buttons;
    private XO[][] valuesGrid;
    private Player Player1 , Player2;
    private JFrame frame;
    private JLayeredPane p;


    Game(JFrame frame , JLayeredPane p) {
        this.setBounds(235, 178, 330, 344);
        this.setLayout(new GridLayout(3, 3, 16, 16));
        this.frame = frame;
        this.p = p;

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

        //System.out.println( Player2.getComputer() );
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j] && valuesGrid[i][j] == null ){
                    if (Player1.getTurn()) {
                        buttons[i][j].setIcon(Player1.getSignImage());
                        this.valuesGrid[i][j] = Player1.getSign();
                        Player1.setTurn(false);
                        Player2.setTurn(true);
                        Player1.OFF();
                        Player2.ON();
                        endGame();
                        //buttons[i][j].setVisible(true);
                        if( Player2.getComputer() && checkComp() != 0){

                            int [] cp = computerTurn( Player2.getSign() );
                            buttons[ cp[0] ][ cp[1] ].setIcon(Player2.getSignImage());
                            this.valuesGrid[ cp[0] ][ cp[1] ] = Player2.getSign();
                            Player1.setTurn(true);
                            Player2.setTurn(false);
                            Player1.ON();
                            Player2.OFF();
                        }
                    }

                    else if (Player2.getTurn()){

                        buttons[i][j].setIcon(Player2.getSignImage());
                        this.valuesGrid[i][j] = Player2.getSign();
                        Player1.setTurn(true);
                        Player2.setTurn(false);
                        Player1.ON();
                        Player2.OFF();
                    }
                    endGame();
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
            if (x == 3){
                Color color = new Color(0x57BBC9);
                this.buttons[i][0].setContentAreaFilled(true);
                this.buttons[i][0].setBackground(color);

                this.buttons[i][1].setContentAreaFilled(true);
                this.buttons[i][1].setBackground(color);

                this.buttons[i][2].setContentAreaFilled(true);
                this.buttons[i][2].setBackground(color);

                return XO.X;
            }
            else if (o == 3) {
                Color color = new Color(0x57BBC9);
                this.buttons[i][0].setContentAreaFilled(true);
                this.buttons[i][0].setBackground(color);

                this.buttons[i][1].setContentAreaFilled(true);
                this.buttons[i][1].setBackground(color);

                this.buttons[i][2].setContentAreaFilled(true);
                this.buttons[i][2].setBackground(color);
                return XO.O;
            }
        }

        for (int j = 0; j < 3; j++) {
            x = 0;
            o = 0;
            for (int i = 0; i < 3; i++) {
                if (this.valuesGrid[i][j] == XO.X) x++;
                else if (this.valuesGrid[i][j] == XO.O) o++;
            }
            if (x == 3) {
                Color color = new Color(0x57BBC9);
                this.buttons[0][j].setContentAreaFilled(true);
                this.buttons[0][j].setBackground(color);

                this.buttons[1][j].setContentAreaFilled(true);
                this.buttons[1][j].setBackground(color);

                this.buttons[2][j].setContentAreaFilled(true);
                this.buttons[2][j].setBackground(color);

                return XO.X;
            }
            else if (o == 3){
                Color color = new Color(0x57BBC9);
                this.buttons[0][j].setContentAreaFilled(true);
                this.buttons[0][j].setBackground(color);

                this.buttons[1][j].setContentAreaFilled(true);
                this.buttons[1][j].setBackground(color);

                this.buttons[2][j].setContentAreaFilled(true);
                this.buttons[2][j].setBackground(color);

                return XO.O;

            }
        }

        if (this.valuesGrid[0][0] == this.valuesGrid[1][1] && this.valuesGrid[1][1] == this.valuesGrid[2][2] && this.valuesGrid[2][2] != null){
            Color color = new Color(0x57BBC9);
            this.buttons[0][0].setContentAreaFilled(true);
            this.buttons[0][0].setBackground(color);

            this.buttons[1][1].setContentAreaFilled(true);
            this.buttons[1][1].setBackground(color);

            this.buttons[2][2].setContentAreaFilled(true);
            this.buttons[2][2].setBackground(color);

            return this.valuesGrid[0][0];

        }
        else if (this.valuesGrid[0][2] == this.valuesGrid[1][1] && this.valuesGrid[1][1] == this.valuesGrid[2][0] && this.valuesGrid[2][0] != null){
            Color color = new Color(0x57BBC9);
            this.buttons[0][2].setContentAreaFilled(true);
            this.buttons[0][2].setBackground(color);

            this.buttons[1][1].setContentAreaFilled(true);
            this.buttons[1][1].setBackground(color);

            this.buttons[2][0].setContentAreaFilled(true);
            this.buttons[2][0].setBackground(color);

            return this.valuesGrid[0][2];
        }

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

    public int[] computerTurn(XO shape){

        //exp(2000);

        int[] ret = WinOrLose( shape );
        if( ret[0] != -1 )return ret;
        ret = WinOrLose( ( shape == XO.O )? XO.X : XO.O );
        if( ret[0] != -1 )return ret;

        //case of random play
        ArrayList <Integer> x = new ArrayList<>();
        ArrayList <Integer> y = new ArrayList<>();

        for( int i = 0 ; i < 3 ; i++ ){
            for (int j = 0; j < 3; j++){
                if( this.valuesGrid[i][j] == null ){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int rand = (int)(Math.random()*(x.size()-1));
        return new int[]{ x.get(rand) , y.get(rand) };
    }
    public int[] WinOrLose( XO shape ){
        int num , empty , x = -1 , y = -1;

        // check possibility of winning in rows
        for (int i = 0; i < 3; i++) {
            num = 0 ; empty = 0;
            for (int j = 0; j < 3; j++) {
                if( this.valuesGrid[i][j] == shape ) num++;
                else if( this.valuesGrid[i][j] == null ) {
                    empty++;
                    x = i;
                    y = j;
                }
            }
            if( num == 2 && empty == 1 )return new int[]{ x , y };
        }

        //check possibility of winning in cols
        for (int j = 0; j < 3; j++){
            num = 0 ; empty = 0;
            for (int i = 0; i < 3; i++) {
                if( this.valuesGrid[i][j] == shape ) num++;
                else if( this.valuesGrid[i][j] == null ) {
                    empty++;
                    x = i;
                    y = j;
                }
            }
            if( num == 2 && empty == 1 )return new int[]{ x , y };
        }

        //check possibility of winning in diagonals
        num = 0 ; empty = 0;
        for (int i = 0; i < 3; i++){
            if( this.valuesGrid[i][i] == shape ) num++;
            else if( this.valuesGrid[i][i] == null ) {
                empty++;
                x = y = i;
            }
        }
        if( num == 2 && empty == 1 )return new int[]{ x , y };

        num = 0 ; empty = 0;
        for (int i = 0; i < 3; i++){
            if( this.valuesGrid[i][2-i] == shape ) num++;
            else if( this.valuesGrid[i][2-i] == null ) {
                empty++;
                x = y = i;
            }
        }
        if( num == 2 && empty == 1 )return new int[]{ x , y };
        return new int[]{ -1 , -1 };
    }

    public void endGame(){
        XO checkF = checkFinish();
        if( checkF != null ){
            Player1.OFF();
            Player2.OFF();
            JLabel winner = new JLabel();
            winner.setBounds(130,30,540,90);
            winner.setFont(new Font("MV BOLI", Font.ITALIC | Font.BOLD, 40));
            winner.setForeground(new Color(255, 255, 255));
            winner.setBackground(new Color(0x196E7C));
            winner.setOpaque(true);
            winner.setHorizontalAlignment(JLabel.CENTER);
            winner.setVerticalAlignment(JLabel.CENTER);

            if( checkF == XO.X || checkF == XO.O ){
                winner.setText(checkF.toString() + " Wins!");

            }else {
                winner.setText("Tie!");
            }
            // set non clickable buttons unenabled
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(valuesGrid[i][j] == null){
                        this.buttons[i][j].setEnabled(false);
                    }
                }
            }

            this.p.add(winner,Integer.valueOf(1));
        }


    }

    //check there is a cell for comp to play or not
    public int checkComp(){
        int cnt = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(valuesGrid[i][j] == null) cnt++;
            }
        }
        return cnt;
    }


}
