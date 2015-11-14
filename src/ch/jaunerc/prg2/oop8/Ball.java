package ch.jaunerc.prg2.oop8;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a ball.
 * @author jaunerc
 */
public class Ball {
    
    private Color color;
    private Thread lifeCycle;
    private int radius;
    private int velocityY;
    private int x, y;
    private int height;
    private boolean isAlive;
    
    /**
     * Creates a new ball.
     * @param x position.
     * @param y position.
     * @param height of the graphics container.
     */
    public Ball(int x, int y, int height) {
        this(Color.red, 60, 8, x, y, height);
    }
    
    /**
     * Creates a new ball.
     * @param color of the ball background.
     * @param radius of the ball.
     * @param velocityY translation of the ball in y-direction.
     * @param x position.
     * @param y position.
     * @param height of the graphics container.
     */
    public Ball(Color color, int radius, int velocityY, int x, int y, int height) {
        this.color = color;
        this.radius = radius;
        this.velocityY = velocityY;
        this.x = x;
        this.y = y;
        this.height = height;
        isAlive = true;
        
        lifeCycle = new Thread(new LifeCycle());
        lifeCycle.start();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isAlive() {
        return isAlive;
    }
    
    /**
     * Draw this ball on the given graphics context.
     * @param g 
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
    }
    
    /**
     * Generate a ball with random radius, velocity and color fields.
     * @param x position.
     * @param y position.
     * @param height of the graphics container.
     * @return random ball reference.
     */
    public static Ball genRandomBall(int x, int y, int height) {
        Random ran = new Random();
        int rad = ran.nextInt((50-20)+1) + 20;
        int vel = ran.nextInt((10-1)+1) + 1;
        Color col = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        
        return new Ball(col, rad, vel, x, y, height);
    }
    
    /**
     * This class provides a runnable to handle the lifecycle of a ball.
     */
    private class LifeCycle implements Runnable {
        
        /**
         * Recalculate the ball position every 25 millis.
         */
        @Override
        public void run() {
            while(isAlive) {
                updatePosition();
                
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /**
         * Adds the velocity value to the position. If the ball has reached the ground of the window,
         * this method invokes the die method.
         */
        private void updatePosition() {
            if((y + radius) >= height) {
                velocityY = 0;
                die();
            }
            
            y += velocityY;
        }
        
        /**
         * Makes the color of the ball brighter until the ball is dead.
         */
        private void die() {
            if(!color.equals(Color.white)) {
                Color colRes = color.brighter();
                if(colRes.equals(color)) {
                    color = Color.white;
                } else {
                    color = colRes;
                }
            } else {
                isAlive = false;
            }
        }
    }
}
