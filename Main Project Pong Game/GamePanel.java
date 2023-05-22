import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends Panel implements Runnable{
    int width = 1000;
    int height = (int)(width*0.555);
    Dimension screen = new Dimension(width,height);
    int paddle_Width=25;
    int paddle_Height=100;

    int ball_diameter=20;


    Image image;
    Graphics graphic;
    paddle p1, p2;

    Ball ball;
    Score score = new Score(width,height);;
    Thread gameThread;


    GamePanel()
    {
      setPreferredSize(screen);
      gameThread = new Thread(this);
      addKeyListener(new AL());
      setFocusable(true);
        gameThread.start();
        newpaddle();
        newball();
    }

    private void newball() {
        Random random = new Random();
        ball = new Ball(width/2,random.nextInt(height-ball_diameter),ball_diameter,ball_diameter);
    }

    private void newpaddle() {
        p1 = new paddle(0,(height-paddle_Height)/2,paddle_Width,paddle_Height,1);
        p2 = new paddle(width-paddle_Width,(height-paddle_Height)/2,paddle_Width,paddle_Height,2);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        image = createImage(getWidth(), getHeight());
        graphic = image.getGraphics();
        draw(graphic);
        g.drawImage(image,0,0,this);

    }

    private void draw(Graphics g) {
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);
        score.draw(g);

    }

    @Override
    public void run()
    {
        long lastTime=System.nanoTime();
        double amountOfTicks=60;
        double ns=1000000000/amountOfTicks;
        double delta=0;
        while(true) {
            long Now = System.nanoTime();
            delta += (Now - lastTime) / ns;
            lastTime = Now;
            if (delta >= 1)
            {
                repaint();
                move();
                CheckCollision();

                delta--;
            }
        }

    }
    private void CheckCollision() {
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yvelocity);
        }
        if (ball.y >= height - ball_diameter) {
            ball.setYDirection(-ball.yvelocity);
        }
        if (ball.intersects(p1)) {
            ball.xvelocity = -ball.xvelocity;
            ball.xvelocity++;
            if (ball.yvelocity > 0) {
                ball.yvelocity++;
            } else {
                ball.yvelocity--;
            }
            ball.setYDirection(ball.yvelocity);
            ball.setXDirection(ball.xvelocity);
        }

        if (ball.intersects(p2)) {
            ball.xvelocity = -ball.xvelocity;
            ball.xvelocity--;
            if (ball.yvelocity > 0) {
                ball.yvelocity++;
            } else {
                ball.yvelocity--;
            }
            ball.setYDirection(ball.yvelocity);
            ball.setXDirection(ball.xvelocity);

        }

        if (p1.y <= 0) {
            p1.y = 0;
        }
        if (p1.y >= height - paddle_Height) {
            p1.y = height - paddle_Height;
        }
        if (p2.y <= 0) {
            p2.y = 0;
        }
        if (p2.y >= height - paddle_Height) {
            p2.y = height - paddle_Height;
        }
        if (ball.x >= width - ball_diameter) {
            newball();
            newpaddle();
            score.player1++;
        }
        if (ball.x <= 0) {
            newpaddle();
            newball();
            score.player2++;
        }

    }

    private void move() {
        p1.move();
        p2.move();
        ball.move();
    }

    public class AL extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            p1.keyPressed(e);
            p2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p1.keyReleased(e);
            p2.keyReleased(e);


        }
    }
    @Override
    public void update(Graphics g)
    {
       paint(g);
    }
}
