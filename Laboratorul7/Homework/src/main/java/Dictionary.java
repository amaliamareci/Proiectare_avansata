import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * class representing the dictionary where I check if a word is ok or not
 */
public class Dictionary {
    List<String> words = new ArrayList<>();

    public Dictionary() {
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                words.add(myReader.nextLine());
                // System.out.println(words);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * @param word -the word I am searching for in the dictionary
     * @return true-if it finds it
     * false-otherwise
     */
    public boolean isWord(String word) {
        int index = Collections.binarySearch(words, word);
        return index > -1;
    }
}
