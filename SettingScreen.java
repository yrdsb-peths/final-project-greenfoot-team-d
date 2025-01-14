import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingScreen extends World
{
    /**
     * Constructor for objects of class SettingScreen.
     * 
     */
    private World home;
    private String selectedColor;
    private ColorButton selectedButton;
    
    public SettingScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.home = home;
        Label gameLabel = new Label("settings", 100);
        addObject(gameLabel, getWidth() / 2, 80);
         
        addObject(createColorButton("yellow", "images/yellowHead.png", 50, 150), 100, 150);
        addObject(createColorButton("pink", "images/pinkHead.png", 200, 150), 200, 150);
        addObject(createColorButton("green", "images/greenHead.png", 300, 150), 300, 150);
        addObject(createColorButton("red", "images/redHead.png", 400, 150), 400, 150);
        addObject(createColorButton("purple", "images/purpleHead.png", 450, 150), 500, 150);
        // Add a button to go back to the home screen
        //addObject(new BackButton(), 300, 350);
        
        Label startLabel = new Label("Start", 25);
         addObject(startLabel, getWidth() / 2 + 200, 200);
         addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 500, 240);
    }
    
    private ColorButton createColorButton(String color, String imagePath, int x, int y) {
        return new ColorButton(color, imagePath, () -> setSelectedColor(color));
    }
    
    public void setSelectedColor(String color) {
        // Deselect the previous button
        if (selectedButton != null) {
            selectedButton.hideCheckmark();
        }

        // Select the new button
        selectedButton = (ColorButton) getObjects(ColorButton.class)
            .stream()
            .filter(button -> button.getColor().equals(color))
            .findFirst()
            .orElse(null);

        if (selectedButton != null) {
            selectedButton.showCheckmark();
            selectedColor = color;
        }
    }
}
