import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{

    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        private World home;
        String firstInstruction = "Eat as much food as possible without \n crashing into walls or yourself.";
        String secondInstruction = "The snake will grow depending on how much food you eat";
        String thirdInstruction = "The difficulty of the game will get harder \n as the levels increase";
        String fourthInstruction = "Use Arrow Keys to control the snake's movement";
        private String[] allText = { firstInstruction, secondInstruction, thirdInstruction, fourthInstruction };
        private int currentIndex = 0;
        private Label instructionLabel = new Label(allText[currentIndex], 40, true);
    }
}
