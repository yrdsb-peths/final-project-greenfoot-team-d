import greenfoot.*;

public class EndScreen extends World {
    private GreenfootSound gameOverSound;
    
    public EndScreen(String color) 
    {
        super(600, 400, 1);
        setBackground("images/instructionBackground.png");
    
        // Play sound
        gameOverSound = new GreenfootSound("gameover.mp3");
        gameOverSound.play();

        addLabels();

        // Return to game world button
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this, color))), getWidth() / 2, 170);
        addObject(new Button(() -> Greenfoot.setWorld(new TitleScreen())), 300, 250);
        
        // Update high score
        if (GameWorld.getScore() > GameWorld.getHighScore()) {
            GameWorld.setHighScore(GameWorld.getScore());
        }
        
        // Reset game
        GameWorld.resetScore();
        SnakeHead.resetLevel();
    }

    // Add Labels
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