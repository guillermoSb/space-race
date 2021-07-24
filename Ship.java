import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
 // Movement Constants
 private int moveSpeedUpDown = 5;
 private int moveSpeed = 4;
 
 // State
 private long previousMillis = 0;
 private int bulletCoolDown = 300;
 private long previousMillisAsteroid = 0;
 private int asteroidCoolDown = 1000;
 
 public void act() {
     checkForMovement();
     shoot();
     asteroidSpawn();
 }
 
 private void asteroidSpawn() {
    if (System.currentTimeMillis() - previousMillisAsteroid < asteroidCoolDown) {
        return;
    }
    Asteroid asteroid = new Asteroid(); // Crear el asteeroide
    World world = getWorld();
    
    int x = world.getWidth();
    int y = getY();
    
    world.addObject(asteroid, x, y);
    
    previousMillisAsteroid = System.currentTimeMillis();
 }
 
 private void checkForMovement() {
     // Up
     if (Greenfoot.isKeyDown("up")) {
         moveUpOrDown(true);
     }
     // Down
     if (Greenfoot.isKeyDown("down")) {
         moveUpOrDown(false);    
     }
     // Right
     if (Greenfoot.isKeyDown("right")) {
         moveForwardOrBackward(true);    
     }
     // Left
     if (Greenfoot.isKeyDown("left")) {
         moveForwardOrBackward(false);    
     }

 }
 
 private void moveUpOrDown(boolean up) {
    turn(90 * (up ? -1 : 1));
    move(moveSpeedUpDown);
    turn(90 * (up ? 1 : -1));
 }
 
 private void moveForwardOrBackward(boolean forward) {
     move( forward ? moveSpeed : -moveSpeed);
 }
 
 private void shoot() {
     if (Greenfoot.isKeyDown("space")) {
         
         if (System.currentTimeMillis() - previousMillis < bulletCoolDown) {
             return;
         }
         
         // Get the world and the actor position
         World world = getWorld();
         int x = getX();
         int y = getY();
         // Shoot a bullet
         Bullet bullet = new Bullet();
         world.addObject(bullet, x + 5, y);
         
         previousMillis = System.currentTimeMillis();
     }
 }
 
 
}
