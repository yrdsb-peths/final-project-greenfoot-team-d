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
    GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
    GreenfootImage pinkHead = new GreenfootImage("images/png/pinkHead.png");
    GreenfootImage orangeHead = new GreenfootImage("images/png/orangeHead.png");
    GreenfootImage greenHead = new GreenfootImage("images/png/greenHead.png");
    GreenfootImage redHead = new GreenfootImage("images/png/redHead.png");
    
    public SettingScreen(World home)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.home = home;
        
    }
}
