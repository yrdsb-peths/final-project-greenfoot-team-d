import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HighScore extends World
{
    private TitleScreen titleScreen;

    /**
     * Constructor for HighScore.
     * 
     */
    public HighScore(TitleScreen titleScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.titleScreen = titleScreen;
        
        AddButtons();
        AddLabels();
    }
    
    private void AddButtons()
    {
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 440, 210);
        addObject(new Button(() -> Greenfoot.setWorld(titleScreen)), 160, 210); 
    }

    private void AddLabels()
    {
        // Big label
        Label score = new Label("High Score",50);
        addObject(score, 300, 80);

        // High score label
        Label highScore = new Label(GameWorld.getHighScore(),40);
        addObject(highScore, 300, 150);
        
        // Back Button
        Label backLabel = new Label("Back", 20);
        addObject(backLabel, 160, 240);

        // Play Button
        Label playButtonLabel = new Label("Play", 20);
        addObject(playButtonLabel, 440, 240);
    }

}
