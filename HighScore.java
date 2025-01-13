import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HighScore extends World
{
    private TitleScreen titleScreen;

    // Constructor for Highscore screen 
    public HighScore(TitleScreen titleScreen)
    {    
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.titleScreen = titleScreen;
        
        // Add buttons and labels 
        AddButtons();
        AddLabels();
    }
    
    // Add buttons
    private void AddButtons()
    {
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 440, 210);
        addObject(new Button(() -> Greenfoot.setWorld(titleScreen)), 160, 210); 
    }

    // Add labels 
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
