import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends Actor
{
    private Runnable action;
    private GreenfootSound clickSound = new GreenfootSound("sounds/buttonClicked.mp3");

    public Settings(Runnable action)
    {
        // Add your action code here.
        this.action = action;
        GreenfootImage image = new GreenfootImage("images/settings.png");
        setImage(image);
    }
    
    public void act() {
        // Checks if user clicked the button
        if (Greenfoot.mouseClicked(this)) {

            // Plays the mouse clicking sound and delays to match the sound
            clickSound.play();
            Greenfoot.delay(20);

            // Runs the action
            if (action != null) {
                action.run();
            }
        }
    }
}
