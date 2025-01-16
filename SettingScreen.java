import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SettingScreen extends World
{
    private World home;

    private String selectedColor;
    private ColorButton selectedButton;
    
    public SettingScreen(World home)
    {    
        
        super(600, 400, 1); 
        setBackground("images/instructionBackground.png");
        this.home = home;

        addLabels();
        addColorButtons();
    }
    
    // Add all color buttons 
    private void addColorButtons() {
        addObject(createColorButton("yellow", "images/yellowHead.png", 50, 150), 100, 150);
        addObject(createColorButton("pink", "images/pinkHead.png", 200, 150), 200, 150);
        addObject(createColorButton("green", "images/greenHead.png", 300, 150), 300, 150);
        addObject(createColorButton("red", "images/redHead.png", 400, 150), 400, 150);
        addObject(createColorButton("purple", "images/purpleHead.png", 450, 150), 500, 150);
    }

    // Add labels 
    private void addLabels() {
        Label gameLabel = new Label("Settings", 100);
        addObject(gameLabel, getWidth() / 2, 80);

        Label startLabel = new Label("Start", 25);
        addObject(startLabel, getWidth() / 2 + 200, 200);
        addObject(new Button(() -> Greenfoot.setWorld(new GameWorld(this, selectedColor))), 500, 240);
    }

    // Creates color button
    private ColorButton createColorButton(String color, String imagePath, int x, int y) {
        return new ColorButton(color, imagePath, () -> setSelectedColor(color));
    }
    
    // Sets the selected color 
    public void setSelectedColor(String color) {
        // Deselect the previous button
        if (selectedButton != null) {
            selectedButton.hideCheckmark();
        }

        // Select the new button
        selectedButton = (ColorButton) getObjects(ColorButton.class)
            .stream()
            .filter(button -> button.getColor().equals(color))
            .findFirst()
            .orElse(null);
        
        if (selectedButton != null) {
            selectedButton.showCheckmark();
            selectedColor = color;
        }
    }
}
