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
    private GreenfootImage baseImage;
    private GreenfootImage checkmarkImage;
    private boolean isSelected;
    
    public ColorButton(String color, String imagePath, Runnable action) {
        // Call the superclass (Button) constructor with the action
        super(action); 
        this.color = color;

        // Set a custom image for the color button
        baseImage = new GreenfootImage(imagePath);
        checkmarkImage = new GreenfootImage("images/check.png");
        checkmarkImage.scale(20, 20); // Resize the checkmark to fit the button

        setImage(baseImage);
        isSelected = false;
    }
    
    public String getColor() {
        return color;
    }
    
    public void showCheckmark() {
        isSelected = true;

        // Create a composite image with the base image and checkmark
        GreenfootImage combinedImage = new GreenfootImage(baseImage);
        combinedImage.drawImage(checkmarkImage, baseImage.getWidth() - 25, baseImage.getHeight() - 25);
        setImage(combinedImage);
    }

    public void hideCheckmark() {
        isSelected = false;
        setImage(baseImage);
    }

    public void act()
    {
        // Add your action code here.
        super.act();
    }
}
