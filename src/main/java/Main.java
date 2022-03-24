import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Mareci Ioana Amalia 2A2
 * LAB 4 homework
 * main class of the problem
 */
public class Main {

    public static void main(String[] args) {

        //generating the random streets names
        String[] streetNames = CityGenerator.generateStreetsNames(17);

        int[] length = {0, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 3, 3, 3};
        //building the streets
        Street[] streetsArray = IntStream.rangeClosed(1, 16).mapToObj(i -> new Street(streetNames[i], length[i])).toArray(Street[]::new);
        Stream<Street> streets = Arrays.stream(streetsArray)
                .sorted(Comparator.comparing(Street::getLength))
                .collect(Collectors.toCollection(LinkedList::new))
                .stream();
        //building the intersections names
        Stream<String> intersectionNames = Stream.of(CityGenerator.generateIntersectionsNames(9));
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

        City city = new City(streets, intersections);
        //city.printCity();
        //printing the streets  that are longer than a specified value and join at least 3 streets
        city.printSpecialStreets(1);
        //building the matrix for the graph
        int[][] matrix = city.matrixStreet(inter.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        //building the MST using Prim algorithm
        MinTree tree = new MinTree(inter.length);
        tree.primMST(matrix);
    }
}
