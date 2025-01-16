import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionScreen extends World
{
    private World home;

    private String[] allText = 
        {"Eat as much food as possible \n without crashing into walls or \n yourself.",
        "The snake will grow depending \n on how much food you eat",
        "The difficulty of the game will \n get harder as the levels increase",
        "Use Arrow Keys to control \n the snake's movement,",
        "Collect power-ups to become \n invisible for 8 seconds. While \n invisible, you can bounce off \n walls and obstacles without \n dying."
        };
    private int currentIndex = 0;
    private Label instructionLabel = new Label(allText[currentIndex], 40); 
    private Label next;

    Button nextButton = new Button(this::nextScreen);
    private String selectedColor = "yellow";
    
    public InstructionScreen(World home, String selectedColor) 
    {    
        super(600, 400, 1);
        setBackground("images/instructionBackground.png");

        this.home = home;
        this.selectedColor = selectedColor;

        addButtons();
        addLabels();
          
    }
    
    // Add buttons 
    private void addButtons() {
        addObject(nextButton, 500, 70);
        addObject(new Button(this::prevScreen), 100, 70);
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this, selectedColor))), 500, getHeight() / 2 + 85);
    }
    
    // Add labels 
    private void addLabels() {
        instructionLabel = new Label(allText[currentIndex], 40);
        addObject(instructionLabel, getWidth() / 2, getHeight() / 2 - 20);

        Label prevLabel = new Label("Back", 25);
        addObject(prevLabel, 100, 35);

        Label startLabel = new Label("Start", 25);
        addObject(startLabel, 500, getHeight() / 2 + 50);
    }

    // Moves to next screen 
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
    
    // Goes back to previous screen 
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
