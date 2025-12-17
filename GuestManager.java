import greenfoot.*; // import every greenfoot function, object and more
import java.util.*; // import java utils
import java.util.concurrent.*; // import java concurrent utils

/**
 * Manage the guests
 */
public class GuestManager extends Manager 
{
    private static Queue<Guest> queue = new Queue<Guest>();
    private static ArrayList<Guest> visualQueue = new ArrayList<>(); // list for the guest on map
    private static int currentQueueSize = 0; // the size of the queue
    
    private static final int MAX_QUEUE = 3; // limit of 3 guests
    private static final int START_X = 620; // x cord of the first guest in the queue
    private static final int SPACING = 210; // the space between each guest
    private static final int SPAWN_INTERVAL_IN_SEC = 8; // the interval time of spawning guests
    
    private static boolean stopSpawning = false;
    
    public static void startSpawner() {
        // spawn guests via java interval
        GameManager.scheduler.scheduleAtFixedRate(() -> {
            if (stopSpawning) return;
            if (currentQueueSize < MAX_QUEUE) spawnGuest();
        }, 0, SPAWN_INTERVAL_IN_SEC, TimeUnit.SECONDS);
    }
    
    private static void spawnGuest() {
        // spawn guest
        Guest guest = new Guest();
        MapManager.add(guest, START_X, guest.getYCord());

        // add guest to queues and update queue size
        queue.enqueue(guest);
        currentQueueSize++;
        visualQueue.add(guest);
        
        updateGuestPositions();
    }
    
    public static void stopSpawner() {
        stopSpawning = true;
    }
    
    public static void continueSpawning() {
        stopSpawning = false;
    }
    
    public static Guest getFirstGuest() {
        return queue.front();
    }
    
    public static boolean isFirstGuest(Guest guest) {
        if (visualQueue.isEmpty()) return false;
        return visualQueue.get(0) == guest;
    }
    
    public static void removeFirstGuest() {
        // do nothing if queue is already empty
        if (queue.isEmpty()) return;

        // remove guest from queues and update queue size
        queue.dequeue();
        MapManager.remove(visualQueue.get(0)); // remove from map
        visualQueue.remove(0);
        currentQueueSize--;

        updateGuestPositions();
    }

    private static void updateGuestPositions() {
        for (int i = 0; i < visualQueue.size(); i++) {
            Guest guest = visualQueue.get(i);
            int targetX = START_X - (i * SPACING); // set the right x cord for the guest on the map
            guest.moveTo(targetX);
        }
    }
}