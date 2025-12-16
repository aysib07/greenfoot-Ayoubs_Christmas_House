import greenfoot.*;  // import every greenfoot function, object and more

public class Text extends Actor
{
    public Text(String text, int size, String color, int xCord, int yCord) {
        this.updateText(text, size, color, xCord, yCord);
    }
    
    public void updateText(String text, int size, String color, int xCord, int yCord) {
        Color textColor = null;
        switch (color) {
            case "white":
                textColor = Color.WHITE;
                break;
            case "red":
                textColor = Color.RED;
                break;
            default:
                textColor = Color.BLACK;
        }
        
        GreenfootImage img = new GreenfootImage(
            text,
            size,
            textColor,
            new Color(0, 0, 0, 0)
        );
        setImage(img);
        
        MapManager.add(this, xCord, yCord);
    }
}