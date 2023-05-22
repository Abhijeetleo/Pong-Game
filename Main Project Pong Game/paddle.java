import java.awt.*;
import java.awt.event.KeyEvent;

public class paddle extends Rectangle {

    int id;

    int yvelocity;
    int speed=10;

    paddle(int x,int y,int Paddle_Width, int Paddle_Height, int id)
    {
       super(x,y,Paddle_Width, Paddle_Height);
       this.id = id;


    }
    public void keyPressed(KeyEvent e)
    {
        switch(id)
        {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                break;
        }

    }

    private void setYDirection(int direction)
    {
        yvelocity = direction;

    }

    public void keyReleased(KeyEvent e)
    {
        switch(id)
        {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W)
                {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S)
                {
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    setYDirection(0);
                }
                break;
        }

    }
    public void move()
    {
        y = y + yvelocity;

    }
     public void draw(Graphics g)
     {
         if(id==1)
         {
             g.setColor(Color.blue);
         }
         else if(id==2)
         {
             g.setColor(Color.red);
         }
         g.fillRect(x,y,width,height);

     }
}
