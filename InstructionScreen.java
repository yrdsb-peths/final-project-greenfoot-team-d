import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    private World home;
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    private String[] allText = 
        {"Eat as much food as possible \n without crashing into walls or \n yourself.",
        "The snake will grow depending \n on how much food you eat",
        "The difficulty of the game will \n get harder as the levels increase",
        "Use Arrow Keys to control \n the snake's movement"};
    private int currentIndex = 0;
    private Label instructionLabel = new Label(allText[currentIndex], 50); 
    private Label next;
    Button nextButton = new Button(this::nextScreen);
    
    public InstructionScreen(World home) 
    {    
        super(600, 400, 1);
        setBackground("images/instructionBackground.png");
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.home = home;
        instructionLabel = new Label(allText[currentIndex], 40);
        addObject(instructionLabel, getWidth() / 2, getHeight() / 2 - 50);
        
        addObject(instructionLabel, 250, 200);
        
        next = new Label("Next", 25);
        addObject(next, 500, 35);
        addObject(nextButton, 500, 70);
        
        Label prevLabel = new Label("Back", 25);
        addObject(prevLabel, 100, 35);
        addObject(new Button(this::prevScreen), 100, 70);
        
        Label startLabel = new Label("Start", 25);
        addObject(startLabel, 500, getHeight() / 2 + 30);
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 500, getHeight() / 2 + 65);
    }
    
    private void nextScreen()
    {
        if (currentIndex < allText.length - 1) {
            currentIndex++;
            instructionLabel.setValue(allText[currentIndex]);
        }
        if (currentIndex == allText.length - 1) {
            removeObject(next); 
            removeObject(nextButton); 
        }
    }
    
    private void prevScreen()
    {
        if(currentIndex == 0)
        {
            Greenfoot.setWorld(home);
            return;
        }
        else
        {
            currentIndex--;
            instructionLabel.setValue(allText[currentIndex]);
        }
        if (currentIndex < allText.length - 1 && !getObjects(Button.class).contains(nextButton)) 
        {
            addObject(next, 500, 35);
            addObject(nextButton, 500, 70);
        }
    }
}
