/**
 * class that represents the timekeeper of the game
 */
public class Timer implements Runnable {

    private final Game game;

    private long startTime;
    private final long maxTime;
    private final long ONE_SECOND = 1000000000;

    public Timer(Game game, long maxSeconds) {
        this.game = game;
        maxTime = maxSeconds;
    }

    @Override
    public void run() {
        startTime = System.nanoTime();
        while (game.getBag() != null) {
            if (System.nanoTime() - startTime > maxTime * ONE_SECOND) {
                System.out.println("The time for the game is exceeded ");
                System.exit(0);
                return;
            }
        }
    }

    public void getTime() {
        System.out.print("\n" + (double) (System.nanoTime() - startTime) / ONE_SECOND + " seconds have passed\n");
    }
}