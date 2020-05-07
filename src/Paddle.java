import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle {
    private int xDirection;
    private int yDirection;
    private int[] pixels;
    private Rectangle boundingBox;
    private int width = 5;
    private int height = 40;

    public Paddle(int x, int y, int col){
        boundingBox = new Rectangle(x, y, width, height);
        pixels = new int[width*height];
        for (int i = 0 ; i < pixels.length ; i++) {
            pixels[i] = col;
            boundingBox.x = 10;
            boundingBox.y = 120;
        }
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == e.VK_W){
            setYDirection(-2);
        }
        if(e.getKeyCode() == e.VK_S){
            setYDirection(2);
        }
    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == e.VK_W){
            setYDirection(0);
        }
        if(e.getKeyCode() == e.VK_S){
            setYDirection(0);
        }

    }

    public void setXDirection(int xdir) {
        xDirection = xdir;
    }

    public void setYDirection(int ydir){
        yDirection = ydir;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void update(){
        boundingBox.x += xDirection;
        if(boundingBox.x <= 0) {
            boundingBox.x = 0;
        }
        if(boundingBox.x >= 380) {
            boundingBox.x = 380;
        }
        boundingBox.y += yDirection;
        if(boundingBox.y <= 0) {
            boundingBox.y = 0;
        }
        if(boundingBox.y >= 260) {
            boundingBox.y = 260;
        }
    }

    public void draw(int[] Screen, int screenWidth){
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                Screen[(boundingBox.y+i)*screenWidth + boundingBox.x+j] = pixels[i*width+j];
            }
        }
    }
}