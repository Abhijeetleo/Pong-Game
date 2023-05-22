import java.awt.*;
import java.util.Random;

public class Ball<x> extends Rectangle {

    int xvelocity;
    int yvelocity;
     int initialspeed;
     
     Random random;
    Ball(int x,int y, int width, int height)
    {
        super(x,y,width,height);
        random=new Random();
        int RandomXDirection=random.nextInt(2);
        if(RandomXDirection==0)
        {
            RandomXDirection--;
        }else {

        }
        setXDirection(RandomXDirection);
        int RandomYDirection=random.nextInt(2);
        if(RandomYDirection==0)
        {
            RandomYDirection--;
        }
        setYDirection(RandomYDirection);
    }

    public void setXDirection(int randomXDirection) {
        xvelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yvelocity = randomYDirection;
    }

    public void move()
    {
        x = x+xvelocity;
        y = y + yvelocity;

    }

    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillOval(x,y,width,height);

        g.setColor(Color.white);

        g.drawLine(500,0,500,555);


    }
}
