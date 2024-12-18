import java.util.ArrayList;
import java.util.List;
import greenfoot.*;

public class GameWorld extends World {
    
    // private static int score = 0;
    // private static int highScore = 0;

    // private Button musicButton;

    List<int[]> snake = new ArrayList<>();
    Snake snakeHead;

    /*
     * Constructor 
     */
    public GameWorld() {
        super(600, 400, 1);
        setBackground("images/green background.png");

        // // Add music button 
        // this.musicButton = musicButton;
        // addObject(musicButton, 950, 555);

        createSnake();
        spawnFood();
    }

    public void act(){
        setPaintOrder(SnakeHead.class, SnakeBody.class);
    }

    /*
     * Create the snake 
     */
    public void createSnake() {
        snakeHead = new SnakeHead();
        addObject(snakeHead, getWidth()/2, getHeight()/2);
    }

    public void createObstacle() {
        Obstacle obstacle = new Obstacle();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(obstacle, x, y);
    }

    public void spawnFood() {
        Food food = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(food, x, y);
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
