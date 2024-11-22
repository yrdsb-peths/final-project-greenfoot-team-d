import greenfoot.*;

public class MusicButton extends Button {
    // private static boolean isOff = false;

    // // Load the images and music
    // private static GreenfootImage musicOn = new GreenfootImage("images/musicOn.png");
    // private static GreenfootImage musicOff = new GreenfootImage("images/musicOff.png");
    // private static GreenfootSound music = new GreenfootSound("sounds/backgroundMusic.mp3");

    /*
     * Constructor
     */
    public MusicButton(Runnable action) {
        super(action); // calls super class constructor 
        // setImage(musicOn); // sets image

        // // Plays and loop music
        // music.play(); 
        // music.playLoop(); 
    }

    // /*
    //  * Changes the button image and pause/play the background music
    //  */
    // public void setButton() {

    //     // Make isOff the opposite boolean
    //     isOff = !isOff;

    //     // Changes image and pause/play music
    //     if (isOff) {
    //         setImage(musicOff);
    //         music.pause();
    //     } else {
    //         setImage(musicOn);
    //         music.play();
    //     }
    // }
    
}