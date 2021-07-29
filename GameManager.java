import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Manages the state of the game, that is, keeps track of the current level and
 * score.
 * Creates the new letters to be shown.
 * @author Guillermo Santos
 */

public class GameManager extends Actor {
    // Declare current level and score
    private int level, score;
    // Declare previousMillis for delaying the bubbles
    private long previousMillis;
    // Time to be waited until next bubble spawns
    private long bubbleCooldown = 1500;
    // Possible letters to show
    private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
         "x", "y", "z"};
      
    public void act() {
        spawnLetter();  // Spawn a letter if needed
    }
    
    /**
     * Spawns a letter every certain time
     */
    public void spawnLetter() {
        // TODO - Use levels to calculate the time
        Date date = new Date();
        long currentMillis = date.getTime();
        // Spawn the bubble only if a second has passesd
        if (currentMillis - previousMillis > 1000) {
            createBubble();
            previousMillis = currentMillis;
        }
        
        
    }
    
    private void createBubble() {
        World world = getWorld();
        Random rand = new Random();
        // Get a random index for the letters array
        int randomInt = rand.nextInt(letters.length);
        // Get world dimensions to spawn the bubble
        int height = world.getHeight();
        int width = world.getWidth();
        // Create a letter bubble instance
        LetterBubble bubble = new LetterBubble(letters[randomInt]);
        // Add the bubble to the world
        world.addObject(bubble, width, 70);
    }

    // Shared game manager instance, for all classes to access it.
    public static GameManager shared = new GameManager();
}
