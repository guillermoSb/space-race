import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class LetterBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterBubble extends Actor
{
    int previousX, previousY;
    private String letter;
    
    /**
     * Creates a bubble using the letter given.
     */
    public LetterBubble(String letter) {
        super(); // Initialize the Actor class
        this.letter = letter;   // Set the bubble letter
    }
    
    /**
     * Creates a bubble using a default letter.
     */
    public LetterBubble() {
        this("A");
    }
    public void act()
    {
        drawLetter();
        move(-2);
    }
    
    /**
     * Draws the letter given
     */
    private void drawLetter() {
        World world = getWorld();
        world.showText("", previousX, previousY); 
        // Set the letter
        int x = this.getX();
        int y = this.getY();
        world.showText(letter, x - 2, y - 2);
        previousX = x - 2;
        previousY = y - 2 ;
        // Remove bubble if needed
        if (x <= 0) {
            List<Player> players = world.getObjects(Player.class);
            int speed = players.get(0).getSpeed();  // get the current player speed
            players.get(0).setSpeed(speed - 6); // Decrement the player speed
            this.destroy();
            LevelOne level = (LevelOne) world;
            level.getGameManager().decrementScore(); 
        }
    }
    
    void destroy() {
        World world = getWorld();
        int x = this.getX();
        int y = this.getY();
        world.removeObject(this);
        world.showText("", previousX, previousY); 
    }
    
    /**
     * Returns the letter
     */
    public String getLetter() {
        return this.letter;
    }
}
