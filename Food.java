import greenfoot.*;

public class Food extends Actor {
    
    /*
     * Checks if its position intersect with obstacle
     */
    public void checkPosition() {
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        GameWorld world = (GameWorld) getWorld();

        // Remove and recreate if touching obstacles
        if(obstacle != null) {
            world.spawnFood();
            world.removeObject(this);   
        }
    }
}
