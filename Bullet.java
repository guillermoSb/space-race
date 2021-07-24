import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Bullets always move at default speed
        move(defaultSpeed);
        // Check if there is a collission
        checkForCollision();
    }
    
    private void checkForCollision() {
        int x = getX();
        int worldWidth = getWorld().getWidth();
        Actor asteroid = getOneObjectAtOffset(0, 0, Asteroid.class);
        // With World
        if (x >= worldWidth - 10) {
            getWorld().removeObject(this);
        } else if (asteroid != null) {
            // With Asteroid
            getWorld().removeObject(asteroid);
            getWorld().removeObject(this);
        }

    }
    
    private int defaultSpeed = 8;
}
