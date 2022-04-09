import java.util.ArrayList;
import java.util.List;

/**
 * the Board of the game where the players are adding words
 */
public class Board {
    private final List<String> words = new ArrayList<>();

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);

    }

    @Override
    public String toString() {
        return words.toString();
    }
}
