import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PowerUp extends Actor
{
    private int lifespan = 300; 
    
    // Constructor
    public PowerUp() {
        GreenfootImage image = new GreenfootImage("powerup.png");
        setImage(image);
    }
    
    public void act()
    {
        lifespan--;
        if (lifespan <= 0) {
            deactivate();
        }
    }
    
    // Deactivates power up
    private void deactivate() {
        // Remove the power-up from the world
        if (getWorld() != null) {
            GameWorld world = (GameWorld) getWorld();
            world.powerUpDeactivated();
            getWorld().removeObject(this);
        }
    }
}
