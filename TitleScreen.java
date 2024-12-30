import greenfoot.*;

public class TitleScreen extends World {
    //private Button musicButton;
    //private Face face;

    public TitleScreen() {
        super(600, 400, 1);
        setBackground("images/titleScreenBackground.png");

         // Add game name
         Label gameLabel = new Label("SNAKE", 100);
         addObject(gameLabel, getWidth() / 2, 80);

         // Add buttons
         //Button startbutton = new StartButton(this::goGameScreen);
         //addObject(startbutton, getWidth() / 2, 120);
         Label startLabel = new Label("Start", 25);
         addObject(startLabel, getWidth() / 2 + 200, 135);
         addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 500, 170);

         Label instructionLabel = new Label("Instructions", 25);
         addObject(instructionLabel, getWidth() / 2 - 200, 135);
         addObject(new Button(() -> Greenfoot.setWorld(new InstructionScreen(this))), 100, 170);

    //     musicButton = new MusicButton(this::changeVolume);
    //     addObject(musicButton, x, y);

    }

    // /*
    //  * Plays or pauses the music
    //  */
    // public void changeVolume() {
    //     ((MusicButton) musicButton).setButton();
    // }

    // /*
    //  * Creates game screen
    //  */
    //public void goGameScreen() {
         //Greenfoot.setWorld(new GameWorld(StartButton));
    //}

}