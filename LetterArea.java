import greenfoot.*;
import java.util.*;
/**
 * Write a description of class LetterArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterArea extends Actor
{
    public LetterArea() {
        GreenfootImage circle = new GreenfootImage(60, 60);
        circle.setColor(Color.RED);
        circle.drawOval(0, 0, 60, 60);
        this.setImage(circle);
      
    }
    
    public void act() {

        World world = getWorld();
        // Find if there is a letter that was pressed near this
        List<LetterBubble> nearBubbles = getObjectsInRange(60, LetterBubble.class);
        // Calculate the distance for those objects
        for (LetterBubble bubble : nearBubbles) {
            if (Greenfoot.getKey() == "a") {
                System.out.println("yes!");
                world.removeObject(bubble);
            }
        }
        // Check if the object letter is the same as the letter typed
        // Remove object if the letter pressed is the correct one
    }
    
}
