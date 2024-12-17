import java.util.LinkedList;

import greenfoot.*;

public class Snake extends Actor {
    private int dx = 10; // Movement in x-direction
    private int dy = 0;  // Movement in y-direction

    GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
    GreenfootImage yellowBody = new GreenfootImage("images/png/snake_yellow_blob_32.png");
    
    //private LinkedList<Body> body = new LinkedList<>();
    private int moveDelay = 5; // Speed control
    private int moveCounter = 0;

    /*
     * Constructor
     */
    public Snake(String part) {
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

        setLocation(previousX+dx, previousY+dy);
    }


    // public void grow() {
    //     int[] tail = arr.get(arr.size() - 1);
    //     arr.add(new int[]{tail[0], tail[1]});
    // }

    // public void checkFoodCollision() {
    //     Actor actor = getOneIntersectingObject(Food.class); // Might be null
    //     if (actor != null) {
    //         Food food = (Food) actor;
    //         MyWorld world = (MyWorld) getWorld();

    //         world.increaseScore(food.value);
    //         getWorld().removeObject(food);
    //         world.spawnFood();
    //     }
    // }
}
