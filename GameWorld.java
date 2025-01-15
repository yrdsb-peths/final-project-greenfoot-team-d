import java.util.ArrayList;
import java.util.List;
import greenfoot.*;
import java.util.Random;

public class GameWorld extends World {
    private Label scoreLabel;
    private static int score = 0;
    private static int highScore = 0;

    // private Button musicButton;
    private World home;
    List<int[]> snake = new ArrayList<>();
    Snake snakeHead;
    Random random = new Random();
    Label levelLabel; 
    int level = SnakeHead.getLevel();; 
    private String selectedColor = "yellow";

    /*
     * Constructor 
     */
    public GameWorld(World home, String selectedColor) {
        super(600, 400, 1);
        setBackground("images/grid2.png");
        this.home = home;
        this.selectedColor = selectedColor;
        // // Add music button 
        // this.musicButton = musicButton;
        // addObject(musicButton, 950, 555)
        createSnake();
        spawnFood();
        levelLabel = new Label("Level " + level, 32);
        addObject(levelLabel, 50, 20);
        scoreLabel = new Label("Score: " + score, 32);
        addObject(scoreLabel, 55, 55); 
    }

    public void act(){
        setPaintOrder(Label.class,Food.class, Obstacle.class, SnakeHead.class, SnakeBody.class);
        level = SnakeHead.getLevel();
        levelLabel.setValue("Level " + level);
    }

    /*
     * Create the snake 
     */private void createSnake() {
        // Create the snake with the selected color
        snakeHead = new SnakeHead(selectedColor);
        addObject(snakeHead, getWidth() / 2, getHeight() / 2);
    }

    public void createObstacle() {
        Obstacle obstacle = new Obstacle();
        int x = random.nextInt(30,570);
        int y = random.nextInt(30,370);
        addObject(obstacle, x, y);
        obstacle.checkPosition();
    }

    public void spawnFood() {
        Food food = new Apple();
        int x = random.nextInt(15,585);
        int y = random.nextInt(15,385);
        addObject(food, x, y);
        food.checkPosition();
    }

    // Returns score
    public static int getScore() {
        return score;
    }

    // Returns high score
    public static int getHighScore() {
        return highScore;
    }

    // Resets the score
    public static void resetScore() {
        score = 0;
    }

    // /*
    //  * Sets the high score
    //  */
    public static void setHighScore(int theHighScore) {
        highScore = theHighScore;
    }
    
    public void increaseScore() {
        score++;
        scoreLabel.setValue("Score: " + score);
    }
    
    public void setSelectedColor(String color) {
        this.selectedColor = color;
    }

    public String getSelectedColor() {
        return selectedColor;
    }
}
