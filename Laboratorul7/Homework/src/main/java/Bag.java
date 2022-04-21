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
        for (int index = 0; index < 9; index++) {
            letters.add(new Tile('A', 1));
            letters.add(new Tile('I', 1));
        }
        for (int index = 0; index < 2; index++) {
            letters.add(new Tile('B', 3));
            letters.add(new Tile('C', 3));
            letters.add(new Tile('F', 4));
            letters.add(new Tile('H', 4));
            letters.add(new Tile('M', 3));
            letters.add(new Tile('P', 3));
            letters.add(new Tile('V', 4));
            letters.add(new Tile('W', 4));
            letters.add(new Tile('Y', 4));
        }
        for (int index = 0; index < 4; index++) {
            letters.add(new Tile('D', 2));
            letters.add(new Tile('L', 1));
            letters.add(new Tile('S', 1));
            letters.add(new Tile('U', 1));
        }
        for (int index = 0; index < 12; index++) {
            letters.add(new Tile('E', 1));
        }
        for (int index = 0; index < 3; index++) {
            letters.add(new Tile('G', 2));
        }
        for (int index = 0; index < 6; index++) {
            letters.add(new Tile('N', 1));
            letters.add(new Tile('R', 1));
            letters.add(new Tile('T', 1));
        }
        for (int index = 0; index < 8; index++) {
            letters.add(new Tile('O', 1));
        }
        letters.add(new Tile('J', 8));
        letters.add(new Tile('K', 5));
        letters.add(new Tile('Q', 10));
        letters.add(new Tile('X', 8));
        letters.add(new Tile('Z', 10));
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

    /**
     * @param letter -the letter i am searching for
     * @return-number of points fot the letter
     */
    public int getPointsFromLetter(char letter) {
        for (Tile tile : letters)
            if (tile.getLetter() == letter)
                return tile.getPoints();
        return 0;
    }

    /**
     * @param letter -remove this tile from the bag
     */
    public void deleteTile(char letter) {
        letters.removeIf(tile -> tile.getLetter() == letter);
    }
}