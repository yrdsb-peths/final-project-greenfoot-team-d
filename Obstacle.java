import greenfoot.*;

public class Obstacle extends Actor{

    public Obstacle() {
        GreenfootImage block = new GreenfootImage("images/png/wall_block_64_0.png");
        setImage(block);
    }

    public void act() {
        checkCollision();
    }

    private void checkCollision() {
        Actor actor = getOneIntersectingObject(Snake.class); // Might be null
        if (actor != null) {
            //gameover screen;
            Greenfoot.setWorld(new EndScreen());
        
        }
    }

    public void checkPosition() {
        Actor food = getOneIntersectingObject(Food.class); // Might be null
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        Actor snake = getOneIntersectingObject(Snake.class);
        GameWorld world = (GameWorld) getWorld();
        if (food != null) {    
           
            world.createObstacle();
            world.removeObject(this);   
                   
        }

        if(obstacle != null || snake != null) {
            world.createObstacle();
            world.removeObject(this);   
        }
    }
}
