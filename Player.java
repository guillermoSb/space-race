import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
 
   private int speed = 4;
   private int bulletCoolDown = 1000;
   private long previousBulletMillis = 0;
    
   
    public void act()
    {
        // Check if the player has arrived to the end
        World world = getWorld();
        if (Math.abs(getX() - world.getWidth()) <= 5) {
            LevelOne level = (LevelOne) world;
            level.getGameManager().endGame(); // Pause the game
            world.addObject(new PlayAgain(), world.getWidth() / 2, world.getHeight() / 2);  // Add retry button
        }
        // Shoot laser
        Date date = new Date();
        long currentMillis = date.getTime();    // Get current millis
        if (Greenfoot.isKeyDown("space") && (currentMillis - previousBulletMillis) > bulletCoolDown) {
            world.addObject(new Bullet(), getX(), getY());
            previousBulletMillis = currentMillis;
        }
        
        // Check if there is an asteroid
        Actor asteroid = getOneObjectAtOffset(0, 0, Asteroid.class); // Get the nearest asteroid
        if (asteroid != null) {
            LevelOne level = (LevelOne) world;
            level.getGameManager().decrementScore(); 
        }

    }
    
    // Runs with the custom speed
    public void run() {
        move(speed);
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
}
