import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        Player player = new Player();
        LetterArea area = new LetterArea();
        GameManager manager = new GameManager();
        addObject(player,70,181);
        addObject(manager,0,0);
        addObject(area, 70, 70);
    }
    
    public GameManager getGameManager() {
        List<GameManager> gameManagers = this.getObjects(GameManager.class);
        return gameManagers.get(0);
    }       
    
}
