import javax.swing.*;
import java.awt.*;

public class Player {
    private XO sign;
    private boolean turn;
    private ImageIcon signImage;
    private MyButton button;

    private boolean isComputer;

    Player(XO sign){
        this.sign = sign;
    }

    public boolean getComputer() { return isComputer; }
    public void setComputer(boolean isComputer) { this.isComputer = isComputer; }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public boolean getTurn(){
        return turn;
    }

    public void setSignImage(ImageIcon signImage) {
        this.signImage = signImage;
    }

    public ImageIcon getSignImage(){
        return this.signImage;
    }

    public void setButton(MyButton button) {
        this.button = button;
    }

    public XO getSign() {
        return sign;
    }

    public void setSign(XO sign) {
        this.sign = sign;
    }

    public void ON() {
        Color color = new Color(0x57BBC9);
        this.button.setBackground(color);
        this.button.setColor(color);
        this.button.setColorClick(color);
        this.button.setBorderColor(color);
        this.button.setColorOver(color);
    }

    public void OFF(){
        Color color = new Color(0x196E7C);
        this.button.setColorOver(color);
        this.button.setColorClick(color);
        this.button.setColor(color);
        this.button.setBackground(color);
        this.button.setBorderColor(color);
    }
}
