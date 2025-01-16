import java.util.ArrayList;
import java.util.List;
import greenfoot.*;
import java.util.Random;

public class GameWorld extends World {
    private Label scoreLabel;
    private static int score = 0;
    private static int highScore = 0;
    
    // power up
    private PowerUp currentPowerUp;
    private int powerUpSpawnTimer = 0;
    private boolean isPowerUpActive = false;
    private Label powerUpTimeLabel;

    // private Button musicButton;
    private World home;
    List<int[]> snake = new ArrayList<>();
    Snake snakeHead;
    Random random = new Random();
    Label levelLabel; 
    int level = SnakeHead.getLevel(); 
    

    /*
     * Constructor 
     */
    public GameWorld(World home) {
        super(600, 400, 1);
        setBackground("images/grid2.png");
        this.home = home;
        
    
        // // Add music button 
        // this.musicButton = musicButton;
        // addObject(musicButton, 950, 555);

        createSnake();
        spawnFood();
        levelLabel = new Label("Level " + level, 32);
        addObject(levelLabel, 50, 20);
        scoreLabel = new Label("Score: " + score, 32);
        addObject(scoreLabel, 55, 55); 
        // initiatlize the power up spawn between each spawn
        resetPowerUpSpawnTimer();
        powerUpSpawnTimer = 100;
        
        powerUpTimeLabel = new Label("", 32); 
        addObject(powerUpTimeLabel, getWidth() - 35, 20);
    }

    public void act(){
        setPaintOrder(Label.class,Food.class, Obstacle.class, SnakeHead.class, SnakeBody.class);
        level = SnakeHead.getLevel();
        levelLabel.setValue("Level " + level);
        
        if (!isPowerUpActive && powerUpSpawnTimer > 0) {
            powerUpSpawnTimer--; 
        }
        
        if (powerUpSpawnTimer <= 0 && !isPowerUpActive) { 
            spawnPowerUp(); 
            isPowerUpActive = true;
            resetPowerUpSpawnTimer(); 
        }
        
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

    /*
     * Sets the high score
     */
    public static void setHighScore(int theHighScore) {
        highScore = theHighScore;
    }
    
    public void increaseScore() {
        score++;
        scoreLabel.setValue("Score: " + score);
    }
    
    public void spawnPowerUp() {
        currentPowerUp = new PowerUp();
        
        // spawn random x and y position
        int x = Greenfoot.getRandomNumber(585) + 15; 
        int y = Greenfoot.getRandomNumber(385) + 15; 
        if (getObjects(PowerUp.class).isEmpty())
        {
            addObject(currentPowerUp, x, y); 
        }
        
    }
    
    public void resetPowerUpSpawnTimer()
    {
        powerUpSpawnTimer = Greenfoot.getRandomNumber(200) + 300;
    }
    
    public void powerUpDeactivated()
    {
        powerUpSpawnTimer = Greenfoot.getRandomNumber(10) + 300; 
        isPowerUpActive = false;
    }
    
    public void removePowerUp() {
        if (currentPowerUp != null && currentPowerUp.getWorld() != null) {
            removeObject(currentPowerUp);
            currentPowerUp = null;
        }
    }
    
    public void updatePowerUpTimeLabel(int remainingTime) {
        if (remainingTime > 0) { 
            powerUpTimeLabel.setValue(remainingTime); 
        }else { 
            // clear the label
            powerUpTimeLabel.setValue("");  
        }
    }
}
