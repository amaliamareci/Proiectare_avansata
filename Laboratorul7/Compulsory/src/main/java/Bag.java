import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The bag containing the letters
 */
public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            Random rn = new Random();
            int answer = rn.nextInt(11);
            for (int index = 0; index < 9; index++) {
                letters.add(new Tile(c, answer));
            }
        }
    }

    /**
     * @param howMany -how many letters the player is extracting
     * @return the letters he extracted
     */
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int index = 0; index < howMany; index++) {
            if (letters.isEmpty()) {
                break;
            }
            //pull one  tile from collection random
            Random rn = new Random();
            int answer = rn.nextInt(letters.size());
            extracted.add(letters.get(answer));
            //then take it out
            letters.remove(letters.get(answer));
        }
        return extracted;
    }
}