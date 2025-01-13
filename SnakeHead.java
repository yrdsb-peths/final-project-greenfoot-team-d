import java.util.LinkedList;
import java.util.Random;
import greenfoot.*;

public class SnakeHead extends Snake {
    private int dx = 10; // Movement in x-direction
    private int dy = 0;  // Movement in y-direction
    
    private LinkedList<SnakeBody> body = new LinkedList<>();
    private int moveDelay = 8; // Speed control
    private int moveCounter = 0;
    private int foodEaten = 0;
    private static int level = 1;
    private int numObstacles = 0;
    
    // Sounds 
    private GreenfootSound eatSound = new GreenfootSound("sounds/apple.mp3");
    private GreenfootSound levelUpSound = new GreenfootSound("sounds/levelUp.mp3");

    /*
     * Constructor
     */
    public SnakeHead() {
        // Load and set image
        GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
        setImage(yellowHead);
    }

    public void act()
    {
        // Moves the snake
        moveCounter++;
        if (moveCounter >= moveDelay) {
            moveSnake();
            moveCounter = 0;
        }

        checkKeyInput();
        checkCollision();

    }

    /*
     * Checks user keys
     */
    private void checkKeyInput() {
        if (Greenfoot.isKeyDown("up")) {
            dx = 0;
            dy = -10;
        } else if (Greenfoot.isKeyDown("down")) {
            dx = 0;
            dy = 10;
        } else if (Greenfoot.isKeyDown("left")) {
            dx = -10;
            dy = 0;
        } else if (Greenfoot.isKeyDown("right")) {
            dx = 10;
            dy = 0;
        }
    }

    private void moveSnake() {
        // Save the previous position of the head
        int previousX = getX();
        int previousY = getY();

        int newX = previousX + dx;
        int newY = previousY + dy;

        // Move the snake head
        setLocation(newX, newY);
        if(newX > 585 || newX < 15 || newY > 385 || newY < 17) {
            //gameover screen;
            Greenfoot.setWorld(new EndScreen());
            return;
        }

        // Move the body
        for(SnakeBody b : body) {
            int tempX = b.getX();
            int tempY = b.getY();

            b.setLocation(previousX, previousY);
            previousX = tempX;
            previousY = tempY;
        }

    }

    // Create and add body to the linkedList
    private void grow() {
        SnakeBody b = new SnakeBody();
        getWorld().addObject(b,getX(),getY());
        body.add(b);
    }

    // Sets the speed
    public void setSpeed(int speed) {
        moveDelay = speed;
    }

    // Returns the amount of food eaten 
    public int getFoodEaten() {
        return foodEaten;
    }

    // Resets level 
    public static void resetLevel(){
        level = 1;
    }

    // Gets current level 
    public static int getLevel() {
        return level;
    }

    // Changes to different level 
    public void changeLevel() {
        GameWorld world = (GameWorld) getWorld();

        // level up every 5 food eaten 
        if(foodEaten%5 == 0) {
            level++; 
            levelUpSound.play();
        }
        
        if(level % 2 == 0) {
            // Speed up every 2 levels
            if(moveDelay > 3) {
                moveDelay -= 1;
                setSpeed(moveDelay);
            }
            
            // Create 9 obstacles max 
            if(numObstacles < 10) {
                world.createObstacle();
                numObstacles++;
            }
            
        }

        // Adding reverse movement when level is greater or equal to 5 
        if(level >= 5) {
            Random random = new Random();
            Boolean bool = random.nextBoolean();

            if(bool) {
                reverseSnake();
            }
        }
    }

    // Checks collision 
    public void checkCollision() {
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        
        if (actor != null) {
            Food food = (Food) actor;
            GameWorld world = (GameWorld) getWorld();
            // Play sound 
            eatSound.play();
            
            grow();
            world.removeObject(food);
            world.spawnFood();
            foodEaten++;
            changeLevel();
            world.increaseScore();

        }
    }

    // Reverses snake movement 
    private void reverseSnake() {
        int newX = body.get(body.size()-1).getX();
        int newY = body.get(body.size()-1).getY();

        body.get(body.size()-1).setLocation(getX(),getY());
        setLocation(newX,newY);

        dx *= -1;
        dy *= -1;
    }

}
