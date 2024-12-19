import greenfoot.*;

public class Obstacle extends Actor{

    public Obstacle() {
        GreenfootImage block = new GreenfootImage("images/png/wall_block_32_0.png");
        setImage(block);
    }

    public void act() {
        checkCollision();
    }

    private void checkCollision() {
        Actor actor = getOneIntersectingObject(Snake.class); // Might be null
        if (actor != null) {
            // game over screen
        
        }
    }

    public void checkPosition() {
        Actor food = getOneIntersectingObject(Food.class); // Might be null
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        GameWorld world = (GameWorld) getWorld();
        if (food != null) {    
           
            world.createObstacle();
            world.removeObject(this);   
                   
        }

        if(obstacle != null) {
            world.createObstacle();
            world.removeObject(obstacle);   
        }
    }
}
