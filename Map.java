import greenfoot.*; // import every greenfoot function, object and more

public class Map extends World
{
    public Map()
    {    
        super(MapManager.getWidth(), MapManager.getHeight(), 1); // set worlds width, height and pixel size
        Greenfoot.start(); // start greenfoot engine
        
        MapManager.setMap(this); // set the right map that should be shown
    }
}