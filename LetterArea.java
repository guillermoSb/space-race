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
        String key = Greenfoot.getKey();
        World world = getWorld();
        // Find if there is a letter that was pressed near this
        List<LetterBubble> nearBubbles = getObjectsInRange(60, LetterBubble.class);
        // Calculate the distance for those objects
        for (LetterBubble bubble : nearBubbles) {
            if ( key != null && key.equals(bubble.getLetter())) {
                // Get the distance between the bubble and the click area
                int bubbleX = bubble.getX();
                int distance = Math.abs(bubbleX - this.getX());
                // Get the player
                List<Player> players = world.getObjects(Player.class);
                int speed = players.get(0).getSpeed();  // get the current player speed
                if (distance <= 10) {
                    players.get(0).setSpeed(speed + 4); // Increment the player speed
                    players.get(0).run();
                    LevelOne level = (LevelOne) world;
                    level.getGameManager().incrementScore();            
                } else {
                    players.get(0).setSpeed(speed - 6); // Decrement the player speed
                    LevelOne level = (LevelOne) world;
                    level.getGameManager().decrementScore(); 
                }
                // Make the players move
                bubble.destroy(); 
            }
        }
        // Check if the object letter is the same as the letter typed
        // Remove object if the letter pressed is the correct one
    }
    
    
    

}
