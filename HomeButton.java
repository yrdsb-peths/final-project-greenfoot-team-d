import greenfoot.*;

public class HomeButton extends Button {

    public HomeButton(Runnable action) {
        super(action); // calls super class constructor 

        // // Load and set image
        GreenfootImage image = new GreenfootImage("images/homeButton.png");
        image.scale(50, 50);
        setImage(image);
    }

}
