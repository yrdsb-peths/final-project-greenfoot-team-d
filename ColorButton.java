import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ColorButton extends Button
{
 
    private GreenfootImage baseImage;
    private GreenfootImage checkmarkImage;
    
    private String color;
    private boolean isSelected;
    
    public ColorButton(String color, String imagePath, Runnable action) {
        super(action); 
        this.color = color;

        // Set a custom image for the color button
        baseImage = new GreenfootImage(imagePath);

        checkmarkImage = new GreenfootImage("images/check.png");
        checkmarkImage.scale(20, 20); // Resize the checkmark to fit the button

        setImage(baseImage);
        isSelected = false;
    }
    
    // Get the colour 
    public String getColor() {
        return color;
    }
    
    // Shows the checkmark 
    public void showCheckmark() {
        isSelected = true;

        // Create a composite image with the base image and checkmark
        GreenfootImage combinedImage = new GreenfootImage(baseImage);
        combinedImage.drawImage(checkmarkImage, baseImage.getWidth() - 25, baseImage.getHeight() - 25);
        setImage(combinedImage);
    }

    // Hides the checkmark
    public void hideCheckmark() {
        isSelected = false;
        setImage(baseImage);
    }

}
