import java.util.Arrays;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class City {
    private Street[] streets;

    public City(Stream<Street> streets, Set<Intersection> intersections) {
        this.streets = streets.toArray(Street[]::new);
    }

    public void printCity() {
        Arrays.stream(streets).forEach(System.out::println);
    }

    /**
     * Printing all the streets that are longer than a specified value and join at least 3 streets
     */
    public void printSpecialStreets(int value) {
        Stream<Street> specialStreets = Arrays.stream(streets).filter(street -> street.getLength() > value).filter(street -> joinStreets(street) > 3);
        specialStreets.forEach(System.out::println);
    }

    /**
     * number of streets that have the same intersection with street
     */
    public int joinStreets(Street street) {
        String i1 = street.getIntersection1().getName();
        String i2 = street.getIntersection2().getName();
        int nr = 0;
        for (Street street1 : streets)
            if (street1.getIntersection1().getName() == i1 || street1.getIntersection1().getName() == i2 || street1.getIntersection2().getName() == i1 || street1.getIntersection2().getName() == i2)
                if (street != street1)
                    nr++;
        return nr;

    }

    public int[][] matrixStreet(int n) {
        int[][] matrix = new int[n][n];
        for (Street street : streets) {
            String s = street.getIntersection1().getName();
            String s2 = street.getIntersection2().getName();
            int i = s.charAt(1) - '0';
            int j = s2.charAt(1) - '0';
            matrix[i][j] = matrix[j][i] = street.getLength();
        }
        return matrix;
    }
}
