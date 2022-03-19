import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Mareci Ioana Amalia 2A2
 * LAB 4 compulsory
 * main class of the problem where i buid the streets and intersections
 */
public class Main {

    public static void main(String[] args) {

        //adding the streets names from example
        String[] streetNames = {"S3", "S8", "S9", "S6", "S1", "S2", "S4", "S5", "S7", "S10", "S11", "S12", "S13", "S14", "S15", "S16"};
        int[] length = {0, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 3, 3, 3};
        Street[] streetsArray = IntStream.rangeClosed(1, 16).mapToObj(i -> new Street("S" + i, length[i])).toArray(Street[]::new);
        Stream<Street> streets = Arrays.stream(streetsArray)
                .sorted(Comparator.comparing(Street::getLength))
                .collect(Collectors.toCollection(LinkedList::new))
                .stream();

        //adding the intersections name from example
        Stream<String> intersectionNames = Stream.of("I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9");
        Set<Intersection> intersections = intersectionNames
                .map(Intersection::new).collect(Collectors.toSet());
        Intersection[] inter = intersections.toArray(Intersection[]::new);
        //adding the intersections to the streets
        streetsArray[0].add(inter[0], inter[1]);
        streetsArray[1].add(inter[0], inter[2]);
        streetsArray[2].add(inter[0], inter[3]);
        streetsArray[3].add(inter[0], inter[4]);
        streetsArray[4].add(inter[1], inter[4]);
        streetsArray[5].add(inter[1], inter[5]);
        streetsArray[6].add(inter[3], inter[6]);
        streetsArray[7].add(inter[7], inter[3]);
        streetsArray[8].add(inter[5], inter[2]);
        streetsArray[9].add(inter[8], inter[6]);
        streetsArray[10].add(inter[2], inter[4]);
        streetsArray[11].add(inter[1], inter[4]);
        streetsArray[12].add(inter[8], inter[2]);
        streetsArray[13].add(inter[2], inter[5]);
        streetsArray[14].add(inter[1], inter[2]);
        streetsArray[15].add(inter[1], inter[8]);
        //printing the streets from example
        streets.forEach(System.out::println);
    }
}
