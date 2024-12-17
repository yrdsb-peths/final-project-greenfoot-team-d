import java.util.LinkedList;
import greenfoot.*;

public class Snake extends Actor {
    private int dx = 10; // Movement in x-direction
    private int dy = 0;  // Movement in y-direction
    
    private LinkedList<SnakeBody> body = new LinkedList<>();
    private int moveDelay = 5; // Speed control
    private int moveCounter = 0;
    private int foodEaten = 0;

    /*
     * Constructor
     */
    public Snake() {
        GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
        setImage(yellowHead);
    }

    public void act()
    {
        moveCounter++;
        if (moveCounter >= moveDelay) {
            moveSnake();
            moveCounter = 0;
        }

        checkKeyInput();
        //checkCollision();

    }

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

        // Move the snake head
        setLocation(previousX+dx, previousY+dy);

        // Move the body
        for(SnakeBody b: body) {
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
    	

    // public void checkCollision() {
    //     Actor actor = getOneIntersectingObject(Food.class); // Might be null
    //     if (actor != null) {
    //         grow();
    //         foodEaten++;
    //         getWorld().removeObject(food);
    //     }
    // }
}
