import java.util.ArrayList;
import java.util.List;

/**
 * class for finding all the combinations of input string letters
 */
public class Combinations {
    private StringBuilder output = new StringBuilder();
    private final String input;
    List<String> words = new ArrayList<>();

    public Combinations(final String str) {
        input = str;
    }

    public void combine() {
        combine(0);
    }

    private void combine(int start) {
        for (int i = start; i < input.length(); ++i) {
            output.append(input.charAt(i));
            //System.out.println( output );
            words.add(output.toString());
            if (i < input.length())
                combine(i + 1);
            output.setLength(output.length() - 1);
        }
    }

    public List<String> getWords() {
        return words;
    }
}
