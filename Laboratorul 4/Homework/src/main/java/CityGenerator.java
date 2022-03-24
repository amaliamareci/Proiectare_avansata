import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Random;

/**
 * in this class I generate random names using a third-party library
 */
public class CityGenerator {
    /**
     * @param maxNames -maximum number of names generated
     * @return a String[] of random names
     */
    public static String[] generateNames(int maxNames) {
        Faker faker = new Faker();
        String[] names = new String[maxNames];
        for (int i = 0; i < maxNames; i++)
            names[i] = faker.address().streetName();
        return names;
    }

    /**
     * @param maxNames -maximum number of street names
     * @return -String [] of length maxNames containing all the streets name
     */
    public static String[] generateStreetsNames(int maxNames) {
        String[] streetsNames = new String[maxNames];
        for (int i = 0; i < maxNames; i++)
            streetsNames[i] = "S_";
        String[] randomNames = generateNames(maxNames);
        for (int i = 0; i < maxNames; i++)
            streetsNames[i] = streetsNames[i] + randomNames[i];
        return streetsNames;
    }

    /**
     * @param maxNames -maximum number of intersections names
     * @return String [] of length maxNames containing all the intersections name
     */
    public static String[] generateIntersectionsNames(int maxNames) {
        String[] intersectionsNames = new String[maxNames];
        for (int i = 0; i < maxNames; i++)
            intersectionsNames[i] = "I" + i + "_";
        String[] randomNames = generateNames(maxNames);
        for (int i = 0; i < maxNames; i++)
            intersectionsNames[i] = intersectionsNames[i] + randomNames[i];
        return intersectionsNames;
    }
}
