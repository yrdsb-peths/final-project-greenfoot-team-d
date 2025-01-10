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
    public SettingScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.home = home;
        Label gameLabel = new Label("settings", 100);
        addObject(gameLabel, getWidth() / 2, 80);
         
        addObject(new ColorButton("yellow", "images/png/snake_yellow_head_32.png",() -> setSelectedColor("yellow")), 150, 150);
        addObject(new ColorButton("pink", "images/pinkHead.png",() -> setSelectedColor("pink")), 250, 150);
        addObject(new ColorButton("green", "images/greenHead.png",() -> setSelectedColor("green")), 350, 150);
        addObject(new ColorButton("red", "images/redHead.png",() -> setSelectedColor("red")), 450, 150);
        // Add a button to go back to the home screen
        //addObject(new BackButton(), 300, 350);
    }
    
    public void setSelectedColor(String color) {
        selectedColor = color;
        System.out.println("Selected color: " + color);
        // Additional logic to handle color selection
    }
}
