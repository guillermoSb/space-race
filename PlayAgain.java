import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Retry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Actor
{
    /**
     * Act - do whatever the Retry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        World world = getWorld();
        world.showText("Click Here To Play Again", world.getWidth() / 2 , world.getHeight() / 2); 
        // Create a new Game if the user clicks the button
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("music.mp3");
            Greenfoot.setWorld(new LevelOne());
        }
    }
}
