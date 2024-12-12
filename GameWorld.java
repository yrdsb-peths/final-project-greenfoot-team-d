import greenfoot.*;

public class GameWorld extends World {
    
    // private static int score = 0;
    // private static int highScore = 0;

    // private Button musicButton;

    /*
     * Constructor 
     */
    public GameWorld() {
        super(600, 400, 1);
        // setBackground("images/??.png");

        // // Add music button 
        // this.musicButton = musicButton;
        // addObject(musicButton, 950, 555);

        createSnake();
    }

    public void createSnake() {
        Snake snake = new Snake();
        addObject(snake, getWidth()/2, getHeight()/2);
    }

    public void act(){
        // String key = Greenfoot.getKey();
        // if(key != null) {

        // }
    }

    //  /*
    //  * Returns score
    //  */
    // public static int getScore() {
    //     return score;
    // }

    //  /*
    //  * Returns high score
    //  */
    // public static int getHighScore() {
    //     return highScore;
    // }

    //     /*
    //  * Resets the score
    //  */
    // public static void resetScore() {
    //     score = 0;
    // }

    // /*
    //  * Sets the high score
    //  */
    // public static void setHighScore(int theHighScore) {
    //     highScore = theHighScore;
    // }
}
