import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Laser que las naves pueden disparar. 
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
        int x = getX(); // Get the current x coordinate
        int worldWidth = getWorld().getWidth(); // Get the world width
        Actor asteroid = getOneObjectAtOffset(0, 0, Asteroid.class); // Get the nearest asteroid
        // With World
        if (x >= worldWidth - 10) {
            // If the bullet is at the end of the map, it needs to dissapear
            getWorld().removeObject(this);
        } else if (asteroid != null) {
            // With Asteroid
            getWorld().removeObject(asteroid);
            // Remove the asteroid from the map
            getWorld().removeObject(this);
        }

    }
    
    private int defaultSpeed = 8;   // Default bullet speed
}
