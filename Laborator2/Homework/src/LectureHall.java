public class LectureHall extends Room{
    boolean projector;

    public LectureHall(String name, int capacity, boolean projector) {
        super(name, capacity);
        this.projector = projector;
        finalTimeEvent=0;
    }

    public LectureHall() {
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                "projector=" + projector +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
