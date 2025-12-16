import greenfoot.*; // import every greenfoot function, object and more

/**
 * Wrapper for map building
 */
public class MapManager extends Manager 
{
    private static World world; // the world object
    private static int width = 1024; // size x-cord
    private static int height = 683; // size y-cord
    
    public static void insertMap() {
        Greenfoot.setWorld(new Map());
    }
    
    public static void setMap(World _world) {
        world = _world;
        
        // show start screen if game is not started
        if (!GameManager.isGameStarted) {
            world.setBackground(new GreenfootImage("./images/game_start_map.png")); // set world background
            
            Button startButton = new Button("start", true);
            MapManager.add(startButton, 830, 490);
            return;
        }
        
        // show the restaurant
        world.setBackground(new GreenfootImage("./images/restaurant_map.png")); // set world background
    }
    
    public static int getWidth() {
        return width;
    }
    
    public static int getHeight() {
        return height;
    }
    
    public static void add(Actor object,int xCord, int yCord) {
        world.addObject(object, xCord, yCord);
    }
    
    public static void remove(Actor object) {
        world.removeObject(object);
    }
    
    /**
     * Remove an object from the map by specifying the object class
     */
    public static void removeByClass(Class<? extends Actor> objectClass) {
        world.removeObjects(world.getObjects(objectClass));
    }
}