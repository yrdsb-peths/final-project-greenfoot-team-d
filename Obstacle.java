import greenfoot.*;

public class Obstacle extends Actor{

    public Obstacle() {
        GreenfootImage block = new GreenfootImage("images/wall_block_32_0.png");
        setImage(block);
    }

    public void act() {
        checkCollision();
    }

    public void checkCollision() {
        Actor actor = getOneIntersectingObject(Snake.class); // Might be null
        if (actor != null) {
            // game over screen
        
        }
    }
}
