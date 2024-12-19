import greenfoot.*;

public class Food extends Actor {
    
    public void checkPosition() {
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        GameWorld world = (GameWorld) getWorld();

        if(obstacle != null) {
            world.spawnFood();
            world.removeObject(this);   
        }
    }
}
