
/**
 * the class for Streets having a name ,a length and 2 intersections
 */
public class Street {
    private String name;
    private int length;
    private Intersection intersection1;
    private Intersection intersection2;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getIntersection1() {
        return intersection1;
    }

    public void setIntersection1(Intersection intersection1) {
        this.intersection1 = intersection1;
    }

    public Intersection getIntersection2() {
        return intersection2;
    }

    public void setIntersection2(Intersection intersection2) {
        this.intersection2 = intersection2;
    }

    //constructor
    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }

    //adding the intersections
    public void add(Intersection i1, Intersection i2) {
        intersection1 = i1;
        intersection2 = i2;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", intersection1=" + intersection1 +
                ", intersection2=" + intersection2 +
                '}';
    }

}