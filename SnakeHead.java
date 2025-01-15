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
    
    private GreenfootSound eatSound = new GreenfootSound("sounds/apple.mp3");
    private GreenfootSound levelUpSound = new GreenfootSound("sounds/levelUp.mp3");
    
    private boolean isInvincible = false;
    private int invincibilityTimer = 0;

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

    public void makeInvincible(int duration) {
        isInvincible = true;
        invincibilityTimer = duration;
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
            
            if (isInvincible) {
                // reverse direction
                dx = -dx; 
                dy = -dy; 
                newX = previousX + dx; 
                newY = previousY + dy;
                setLocation(newX, newY);
            }
            //gameover screen;
            Greenfoot.setWorld(new EndScreen());
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

    private void grow() {
        SnakeBody b = new SnakeBody();
        getWorld().addObject(b,getX(),getY());
        body.add(b);
    }

    public void setSpeed(int speed) {
        moveDelay = speed;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public static void resetLevel(){
        level = 1;
    }

    public static int getLevel() {
        return level;
    }

    public void changeLevel() {
        GameWorld world = (GameWorld) getWorld();

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

    public void checkCollision() {
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        GameWorld world = (GameWorld) getWorld();
        
        // food collision
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
        
        // obstacle collission
        Actor obstacle = getOneIntersectingObject(Obstacle.class); 
        if (obstacle != null) { 
            
            if (isInvincible){
                // reverse direction
                dx = -dx; 
                dy = -dy;
            }else 
            {
                Greenfoot.setWorld(new EndScreen()); 
                return;
            }
        }
        
        Actor powerUp = getOneIntersectingObject(PowerUp.class);
        if (powerUp != null) {
            activateInvincibility(360);
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
    }
    
    private void handleInvincibility() {
        if (isInvincible) {
            //System.out.println("Invincibility timer: " + invincibilityTimer);
            invincibilityTimer--;
            if (invincibilityTimer <= 0) {
                deactivateInvincibility();
            }
        }
    }

    // private void reverseSnake() {
        
    //     int j = body.size()-1;

    //     for(int i = 0; i < j; i++, j--) {
    //         SnakeBody temp = body.get(i);
    //         body.set(i,body.get(j));
    //         body.set(j,temp);
    //     }

    //     int newX = body.get(body.size()-1).getX();
    //     int newY = body.get(body.size()-1).getY();

    //     body.get(body.size()-1).setLocation(getX(),getY());
    //     setLocation(newX,newY);
        
    // }

    private void reverseSnake() {
        int newX = body.get(body.size()-1).getX();
        int newY = body.get(body.size()-1).getY();

        body.get(body.size()-1).setLocation(getX(),getY());
        setLocation(newX,newY);

        dx *= -1;
        dy *= -1;
    }

}
