import greenfoot.*;

public class Snake extends Actor {
    GreenfootImage yellowHead = new GreenfootImage("images/png/snake_yellow_head_32.png");
    GreenfootImage yellowBody = new GreenfootImage("images/png/snake_yellow_blob_32.png");

    /*
     * Constructor
     */
    public Snake() {
        setImage(yellowHead);
    }

    public void act()
    {
        int x = this.getX();
        int y = this.getY();

        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(x-2, y);
        }
        else if (Greenfoot.isKeyDown("right")){
            setLocation(x+2, y);
        }
        else if (Greenfoot.isKeyDown("up")) {
            setLocation(x, y-2);
        }
        else if (Greenfoot.isKeyDown("down")) {
            setLocation(x, y+2);
        }
    }

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
