import greenfoot.*;

public class SnakeBody extends Snake {
    
    public SnakeBody(String selectedColor) {
        GreenfootImage yellowBody = new GreenfootImage("images/png/snake_yellow_blob_32.png");
        GreenfootImage pinkBody = new GreenfootImage("images/body/pinkBody.png");
        GreenfootImage redBody = new GreenfootImage("images/body/redBody.png");
        GreenfootImage purpleBody = new GreenfootImage("images/body/purpleBody.png");
        GreenfootImage orangeBody = new GreenfootImage("images/body/orangeBody.png");
        GreenfootImage greenBody = new GreenfootImage("images/body/greenBody.png");
        setImage(yellowBody);
    }
}