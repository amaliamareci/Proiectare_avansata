import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * player class having a run method
 */
public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    int round = 1;
    int score;

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
        String finalAns = "";
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) word.append(tile.getLetter());
        finalAns = checkWord(word.toString());
        game.getBoard().addWord(this, finalAns);
        for (int index = 0; index < finalAns.length(); index++)
            game.getBag().deleteTile(finalAns.charAt(index));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.warning("(InterruptedException");
        }
        return true;
    }

    /**
     * @param str -the letters that the player has extracted
     *            checks if the player can make a word from this letters
     */
    public String checkWord(String str) {
        int maxScore = 0;
        String finalAns = "";
        Combinations combobj = new Combinations(str);
        combobj.combine();
        List<String> words = combobj.getWords();
        for (String word : words) {
            int score = 0;
            for (int index = 0; index < word.length(); index++)
                score += game.getBag().getPointsFromLetter(word.charAt(index));
            if (this.game.getDictionary().isWord(word) && score > maxScore) {
                finalAns = word;
                maxScore = score;
            }
        }
        score += maxScore;
        return finalAns;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (running) {
            running = this.submitWord();
            for (Player player : game.getPlayers())
                while (player.round != this.round)

                    round++;
        }

    }
}
