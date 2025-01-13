import greenfoot.*;

public class TitleScreen extends World {

    public TitleScreen() {
        super(600, 400, 1);
        setBackground("images/titleScreenBackground.png");

        // Add labels and buttons 
        addLabels(); 
        addButtons();

    }

    // Add labels
    private void addLabels() {
        Label gameLabel = new Label("SNAKE", 100);
        addObject(gameLabel, getWidth() / 2, 80);

        Label startLabel = new Label("Start", 25);
        addObject(startLabel, getWidth() / 2 + 200, 135);


        Label instructionLabel = new Label("Instructions", 25);
        addObject(instructionLabel, getWidth() / 2 - 200, 135);

        Label scoreLabel = new Label("HighScore", 25);
        addObject(scoreLabel, getWidth()/2 - 200, 205);
    }

    // Add Buttons 
    private void addButtons() {
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 500, 170);
        addObject(new Button(() -> Greenfoot.setWorld(new InstructionScreen(this))), 100, 170);
        addObject(new Button(() -> Greenfoot.setWorld(new HighScore(this))), 100, 240);
    }

}