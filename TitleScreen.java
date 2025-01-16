import greenfoot.*;

public class TitleScreen extends World {

    public TitleScreen() {
        super(600, 400, 1);
        setBackground("images/titleScreenBackground.png");

        addButtons();
        addLabels();

    }

    private void addButtons() {
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this, "yellow"))), 500, 170);
        addObject(new Button(() -> Greenfoot.setWorld(new InstructionScreen(this, "yellow"))), 100, 170);
        addObject(new Button(() -> Greenfoot.setWorld(new HighScore(this, "yellow"))), 100, 240);
        addObject(new Settings(() -> Greenfoot.setWorld(new SettingScreen(this))), 550, 50);
    }

    private void addLabels() {
        // Add game name
        Label gameLabel = new Label("SNAKE", 100);
        addObject(gameLabel, getWidth() / 2, 80);

        Label startLabel = new Label("Start", 25);
        addObject(startLabel, getWidth() / 2 + 200, 135);

        Label instructionLabel = new Label("Instructions", 25);
        addObject(instructionLabel, getWidth() / 2 - 200, 135);

        Label scoreLabel = new Label("HighScore", 25);
        addObject(scoreLabel, getWidth()/2 - 200, 205);
    }
   
}