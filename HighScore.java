import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScore extends World
{
    private Map<String, Integer> highScores;
    private World previousScreen;
    /**
     * Constructor for objects of class HighScore.
     * 
     */
    public HighScore()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.previousScreen = previousScreen;
        
        Label score = new Label("High Scores!",50);
        addObject(score, 300, 90);
        
        // highscore map with 3 names
        highScores = new HashMap<>();
        highScores.put("Mr.Chan", 2900);
        highScores.put("Tiffany", 2800);
        highScores.put("Andrew", 1000);
        
        addScores();
        returnButton();
    }
    
    private void addScores(){
        int y = 150;
        
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(highScores.entrySet());
        sorted.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        
        for (Map.Entry<String, Integer> entry : sorted) 
        {
          String text = entry.getKey() + ": " + entry.getValue();
          Label scoreLabel = new Label(text, 24);
          addObject(scoreLabel, 300, y);
          y+= 50;
        }
    }
    
     public void returnButton()
    {
        addObject(new Button(()-> back()), 300, 350);
        Label returnButtonLabel = new Label("Return to menu", 20);
        addObject(returnButtonLabel, 300, 385);
    }

    public void back()
    {
        Greenfoot.setWorld(previousScreen);
    }
}
