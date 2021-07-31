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
    // Declare previousMillis for bubbles
    private long previousMillisAsteroid = 500;
    // Time to be waited until next bubble spawns
    private long bubbleCooldown = 1500;
    // Time to be waited between spawns of asteroids
    private long asteroidCooldown = 5000;
    // Game state paused / playing
    private boolean gamePaused = false;
    // Possible letters to show
    private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
         "x", "y", "z"};
    private int asteroidCount = 0;
    GreenfootSound sound;   // Game mi

    public void act() {
        spawnLetter();  // Spawn a letter if needed
        showScore();    // Show the current user score
    }
    
    private void showScore() {
        World world = getWorld();
        world.showText("Score: " + this.score, world.getWidth() / 2, 10); 
    }
    
    /**
     * Spawns a letter every certain time
     */
    private void spawnLetter() {
        Date date = new Date();
        long currentMillis = date.getTime();
        // Spawn the bubble only if a second has passesd
        if ( !gamePaused && (currentMillis - previousMillis > bubbleCooldown)) {
            createBubble();
            previousMillis = currentMillis;
        }
        
        if (!gamePaused && (Math.abs(currentMillis - previousMillisAsteroid) > asteroidCooldown)) {
            createAsteroid();
            previousMillisAsteroid = currentMillis;
        }
        
        
    }
    
    private void createAsteroid() {
        this.asteroidCount ++;
        if (asteroidCount == 1) {
            return;
        }
        World world = getWorld();   // Get the world to create the asteroid
        Asteroid a = new Asteroid();    // Create the asteroid instance
        world.addObject(a, world.getWidth(), 181);
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
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void incrementScore() {
        // Get the game manager
        score += 5;
        
    }
    public void decrementScore() {
        // Return if the score is already 0
        if (this.score == 0) {
            return;
        }
        // Get the game manager
        score -= 5;
    }
    // Pause the game
    public void pauseGame() {
        this.gamePaused = true;
    }
    // Resume the game
    public void resumeGame() {
        this.gamePaused = false;
    }
    
    // Remove all the bubbles
    public void endGame() {
        World world = getWorld();
        this.gamePaused = true;
        List<LetterBubble> bubbles = world.getObjects(LetterBubble.class);
        for (LetterBubble bubble : bubbles) {
            world.removeObject(bubble);
        }
    }
    // Shared game manager instance, for all classes to access it.
    public static GameManager shared = new GameManager();
}
