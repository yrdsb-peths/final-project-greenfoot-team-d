import greenfoot.*;

public class Obstacle extends Actor{

    // Constructor 
    public Obstacle() {
        GreenfootImage block = new GreenfootImage("images/png/wall_block_64_0.png");
        setImage(block);
    }

    public void act() {
        checkCollision();
    }

    // Check collision with snake 
    private void checkCollision() {
        GameWorld world = (GameWorld) getWorld();
        Actor actor = getOneIntersectingObject(Snake.class); // Might be null
        if (actor != null) {
            // game over screen
            Greenfoot.setWorld(new EndScreen(world.getSelectedColor()));
        }
    }

    // Checks collision with all the objects 
    public void checkPosition() {
        Actor food = getOneIntersectingObject(Food.class); 
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        Actor snake = getOneIntersectingObject(Snake.class);
 
        if (food != null || obstacle != null || snake != null) {    
           
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
            world.removeObject(this);   
        
        }
    }
}
