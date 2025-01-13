import greenfoot.*;

public class EndScreen extends World {
    private GreenfootSound gameOverSound;
    
    public EndScreen() 
    {
        super(600, 400, 1);
        setBackground("images/instructionBackground.png");
    
        // Play sound
        gameOverSound = new GreenfootSound("gameover.mp3");
        gameOverSound.play();

        addLabels();

        // Home button 
        Button homeButton = new Button(this::backToHome);
        addObject(homeButton, 300, 250);

        // Return to game world button
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), getWidth() / 2, 170);
        
        // Update high score
        if (GameWorld.getScore() > GameWorld.getHighScore()) {
            GameWorld.setHighScore(GameWorld.getScore());
        }
        
        // Reset game
        GameWorld.resetScore();
        SnakeHead.resetLevel();
    }

    
    // Return back to title screen
    public void backToHome() {
        Greenfoot.setWorld(new TitleScreen());
    }

    /*
     * Add Labels
     */
    private void addLabels(){

        // Gameover Label
        Label gameOverLabel = new Label("Game Over!", 40);
        addObject(gameOverLabel, 300, 100);
        
        // Home Label
        Label playAgainLabel = new Label("Back to Home", 20);
        addObject(playAgainLabel, 300, 280);
        
        // Restart label
        Label restartLabel = new Label("Restart", 20);
        addObject(restartLabel, getWidth() / 2, 200);

        // Score label
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 20);
    }

}