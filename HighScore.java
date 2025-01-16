import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HighScore extends World
{
  
    private TitleScreen titleScreen;
    private String selectedColor = "yellow";
    
    // Constructor for Highscore 
    public HighScore(TitleScreen titleScreen, String selectedColor)
    {    
        super(600, 400, 1); 
        setBackground("images/grid2.png");
        this.titleScreen = titleScreen;
        
        addButtons();
        addLabels();  
              
    }

    // Add buttons 
    private void addButtons(){
        addObject(new Button(() -> Greenfoot.setWorld(titleScreen)), getWidth() / 2, 280);
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this, selectedColor))), 300, 350);
    }

    // Add labels 
    private void addLabels() {
        Label score = new Label("High Score",50);
        addObject(score, 300, 80);

        Label highScore = new Label(GameWorld.getHighScore(),40);
        addObject(highScore, 300, 150);

        Label backLabel = new Label("Back", 20);
        addObject(backLabel, getWidth() / 2, 310);

        Label playButtonLabel = new Label("Play", 20);
        addObject(playButtonLabel, 300, 385);
    }

}
