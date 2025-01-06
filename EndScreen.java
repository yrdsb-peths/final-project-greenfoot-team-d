import greenfoot.*;

public class EndScreen extends World {
    
    public EndScreen() 

    {
        super(600, 400, 1);
        setBackground("images/instructionBackground.png");
    
        Label gameOverLabel = new Label("Game Over!", 40);
        addObject(gameOverLabel, 300, 150);

        Button homeButton = new HomeButton(this::backToHome);
        addObject(homeButton, 300, 200);
        
        // // Update high score
        // if (GameWorld.getScore() > GameWorld.getHighScore()) {
        //     GameWorld.setHighScore(GameWorld.getScore());
        // }
        
        // // Score label
        // Label score = new Label("Score: " + GameWorld.getScore(), 40);
        // addObject(score, 70, 20);

        // // High score label
        // Label highScoreLabel = new Label("Highscore: " + GameWorld.getHighScore(), 40);
        // addObject(highScoreLabel, 110, 50);  

    }

    
    // Return back to title screen
    public void backToHome() {
        Greenfoot.setWorld(new TitleScreen());
    }


}