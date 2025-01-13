import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    private int lifespan = 300; 
    

    public PowerUp() {
        GreenfootImage image = new GreenfootImage("powerup.png");
        setImage(image);
    }
    
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        lifespan--;
        if (lifespan <= 0) {
            deactivate();
        }
    }
    
    private void deactivate() {
        // Remove the power-up from the world
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
}
