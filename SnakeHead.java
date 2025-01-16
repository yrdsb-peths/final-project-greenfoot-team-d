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
    private GreenfootSound levelUpSound = new GreenfootSound("sounds/levelUp.mp3");
    private GreenfootSound powerUpSound = new GreenfootSound("sounds/powerUp.mp3");
    
    private boolean isInvincible = false;
    private int invincibilityTimer = 0;

    /*
     * Constructor
     */
    public SnakeHead() {
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
        
        // power up
        if (isInvincible) {
            invincibilityTimer--;
            if (invincibilityTimer <= 0) {
                isInvincible = false;
            }
        }

        checkKeyInput();
        handleInvincibility();
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

    public void makeInvincible(int duration) {
        isInvincible = true;
        invincibilityTimer = duration;
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
            
            if (isInvincible) {
                // reverse direction
                dx = -dx; 
                dy = -dy; 
                newX = previousX + dx; 
                newY = previousY + dy;
                setLocation(newX, newY);
            }else 
            {
                //gameover screen;
                Greenfoot.setWorld(new EndScreen());
                return;
            }

            //gameover screen;
            GameWorld world = (GameWorld) getWorld();
            Greenfoot.setWorld(new EndScreen(world.getSelectedColor()));
            return;
        }

        setLocation(newX, newY);
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
        
        GameWorld world = (GameWorld) getWorld();

        int previousX = getX();
        int previousY = getY();
        int newX = previousX + dx;
        int newY = previousY + dy;
        
        // obstacle collission
        Actor obstacle = getOneIntersectingObject(Obstacle.class); 
        if (obstacle != null) { 
            
            if (isInvincible){
                // reverse direction
                dx = -dx; 
                dy = -dy;
                newX = previousX + dx; 
                newY = previousY + dy;
                setLocation(newX, newY);
            }else 
            {
                Greenfoot.setWorld(new EndScreen()); 
                return;
            }
        }
        //setLocation(newX, newY);
        
        // food collision
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        if (actor != null) {
            Food food = (Food) actor;
            // play sound 
            eatSound.play();
            
            grow();
            world.removeObject(food);
            world.spawnFood();
            foodEaten++;
            changeLevel();
            world.increaseScore();
            
        }
        
        Actor powerUp = getOneIntersectingObject(PowerUp.class);
        if (powerUp != null) {
            activateInvincibility(480);
            powerUpSound.play();
            getWorld().removeObject(powerUp);
        }

        
        Actor food = getOneIntersectingObject(Food.class);
        if (food != null) {
            Food f = (Food) food;
            getWorld().removeObject(f);
            grow();
            world.increaseScore();
            world.spawnFood();
        }
        
        
    }
    
    
    private void activateInvincibility(int duration) {
        isInvincible = true;
        invincibilityTimer = duration; 
        GreenfootImage invincibleImage = new GreenfootImage("images/png/snake_green_head_32.png");
        setImage(invincibleImage);
    }
    
    private void deactivateInvincibility() {
        isInvincible = false;
        invincibilityTimer = 0;
        GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
        setImage(yellowHead);
        // remove countdown label 
        GameWorld world = (GameWorld) getWorld(); 
        world.updatePowerUpTimeLabel(0);
        world.powerUpDeactivated();
    }
    
    private void handleInvincibility() {
        if (isInvincible) {
            //System.out.println("Invincibility timer: " + invincibilityTimer);
            invincibilityTimer--;
            
            // power up label count down
            int remainingTime = invincibilityTimer / 60;
            GameWorld world = (GameWorld) getWorld();
            world.updatePowerUpTimeLabel(remainingTime);
            
            if (invincibilityTimer <= 0) {
                deactivateInvincibility();
            }
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
