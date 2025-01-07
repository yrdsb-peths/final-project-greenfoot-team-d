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
    
    private TitleScreen titleScreen;
    /**
     * Constructor for objects of class HighScore.
     * 
     */
    public HighScore(TitleScreen titleScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/grid2.png");
        this.titleScreen = titleScreen;
        
        Label score = new Label("High Scores!",50);
        addObject(score, 300, 80);
        
        // highscore map with 3 names
        highScores = new HashMap<>();
        highScores.put("Mr.Chan", 20);
        highScores.put("Tiffany", 10);
        highScores.put("Andrew", 1);
        
        addScores();
        playButton();
        
        Label backLabel = new Label("Back", 20);
        addObject(backLabel, getWidth() / 2, 310);
        addObject(new Button(() -> Greenfoot.setWorld(titleScreen)), getWidth() / 2, 280);        
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
          y+= 35;
        }
    }
    
     public void playButton()
    {
        // addObject(new Button(()-> back()), 300, 350);
        Label playButtonLabel = new Label("Play", 20);
        addObject(playButtonLabel, 300, 385);
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this))), 300, 350);
    }

}
