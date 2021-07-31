import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El Asteroide aparece en el mapa y las naves lo deben de evitar a toda costa.
 * Este es destruido si un laser lo choca.
 * Si el asteroide choca a un usuario, este pierde puntos o termina el juego.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Mover hacia la izquierda a una velocidad constante
        move(-3);
        
        
        // Remove the asteroid if it gets at the end of the screen
        if (getX() < 5) {
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
