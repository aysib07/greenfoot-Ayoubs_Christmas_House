import greenfoot.*; // import every greenfoot function, object and more
import java.util.concurrent.*; // import java concurrent utils

/**
 * Controller of the Game Engine
 */
public class GameManager extends Manager  
{
    public static boolean isGameStarted = false; // use to check internal if the game has started
    public static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(); // used for timeouts
    
    /**
     * Start the real game
     */
    public static void start() {        
        isGameStarted = true; // set internal game status true
        MapManager.insertMap(); // replace the current map
        
        // start spwaning guests after 4 seconds
        scheduler.schedule(() -> {
            GuestManager.startSpawner();
        }, 2, TimeUnit.SECONDS);
        
        // plays music
        GreenfootSound music = new GreenfootSound("./music/background_music.mp3");
        music.playLoop();
    }
}