import java.awt.*;

public class Score extends  Rectangle {
    int width;
    int height;
    int player1;
    int player2;
    String pl1="PLAYER A";
    String pl2="PLAYER B";
    Score(int width,int height)
    {
        this.height=height;
        this.width=width;

    }
    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("ARIAL",Font.PLAIN,30));
        g.drawString(pl1,width/2-150,50);
        g.drawString(pl2,width/2+10,50);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString(String.valueOf(player1),width/2-60,100);
        g.drawString(String.valueOf(player2),width/2+20,100);
    }


}
