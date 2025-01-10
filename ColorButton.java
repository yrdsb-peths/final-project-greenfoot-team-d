import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColorButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorButton extends Button
{
    /**
     * Act - do whatever the ColorButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String color;
    
    public ColorButton(String color, String imagePath, Runnable action) {
        // Call the superclass (Button) constructor with the action
        super(action); 

        this.color = color;

        // Set a custom image for the color button
        GreenfootImage image = new GreenfootImage(imagePath);
        setImage(image);
    }
    
    public String getColor() {
        return color;
    }

    public void act()
    {
        // Add your action code here.
        super.act();
    }
}
