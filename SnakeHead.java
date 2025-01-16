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
    private String currentColor;
    
    private GreenfootSound eatSound = new GreenfootSound("sounds/apple.mp3");
    GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
    GreenfootImage pinkHead = new GreenfootImage("images/pinkHead.png");
    GreenfootImage orangeHead = new GreenfootImage("images/orangeHead.png");
    GreenfootImage greenHead = new GreenfootImage("images/greenHead.png");
    GreenfootImage redHead = new GreenfootImage("images/redHead.png");
    
    public SnakeHead(String color) {
        // Load and set image
        this.currentColor = color;
        setColor(color);
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
    
    // Sets the color of the head 
    private void setColor(String color) {
        switch (color) {
            case "yellow":
                setImage("images/png/snake_yellow_head_32.png");
                break;

            case "pink":
                setImage("images/pinkHead.png");
                break;

            case "green":
                setImage("images/greenHead.png");
                break;

            case "red":
                setImage("images/redHead.png");
                break;

            case "purple":
                setImage("images/purpleHead.png");
                break;

            default:
                setImage("images/png/snake_yellow_head_32.png"); // Default image
        }
    }

    // Checks user key 
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

    // Moves the snake 
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
            GameWorld world = (GameWorld) getWorld();
            Greenfoot.setWorld(new EndScreen(world.getSelectedColor()));
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

    // Add body to linked list 
    private void grow() {
        SnakeBody b = new SnakeBody(getCurrentColor());
        getWorld().addObject(b,getX(),getY());
        body.add(b);
    }
    

    // Returns current color 
    private String getCurrentColor() {
        return currentColor;
    }

    // Sets the speed
    public void setSpeed(int speed) {
        moveDelay = speed;
    }

    // Get the number of food eaten
    public int getFoodEaten() {
        return foodEaten;
    }

    // Resets level
    public static void resetLevel(){
        level = 1;
    }

    // Get level
    public static int getLevel() {
        return level;
    }

    // Changes the level 
    public void changeLevel() {
        GameWorld world = (GameWorld) getWorld();

        if(foodEaten%5 == 0) {
            level++; 
        }
        
        if(level % 2 == 0) {
            // Speed up every 2 levels
            if(moveDelay > 3) {
                moveDelay -= 1;
                setSpeed(moveDelay);
            }
            
            if(numObstacles < 10) {
                world.createObstacle();
                numObstacles++;
            }
            
        }

        if(level >= 5) {
            Random random = new Random();
            Boolean bool = random.nextBoolean();

            if(bool) {
                reverseSnake();
            }
        }
    }

    // Checks collision with food 
    public void checkCollision() {
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        if (actor != null) {
            Food food = (Food) actor;
            GameWorld world = (GameWorld) getWorld();
            // play sound 
            eatSound.play();
            
            grow();
            world.removeObject(food);
            world.spawnFood();
            foodEaten++;
            changeLevel();
            world.increaseScore();

        }
    }

    // Reveres the snake movement 
    private void reverseSnake() {
        int newX = body.get(body.size()-1).getX();
        int newY = body.get(body.size()-1).getY();

        body.get(body.size()-1).setLocation(getX(),getY());
        setLocation(newX,newY);

        dx *= -1;
        dy *= -1;
    }

}
