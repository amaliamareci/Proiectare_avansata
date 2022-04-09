import java.util.List;
import java.util.logging.Logger;

/**
 * player class having a run method
 */
public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * @return true if the player extracted the letters successfully
     * false - if the bag is empty or if we don't have enough letters in it
     * after extracting the letters ,the word is added to the board
     */
    public boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty() || extracted.size() < 7) {
            return false;
        }
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) word.append(tile.getLetter());


        game.getBoard().addWord(this, word.toString());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.warning("(InterruptedException");
        }
        return true;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (running) {
            running = this.submitWord();
        }
    }
}
