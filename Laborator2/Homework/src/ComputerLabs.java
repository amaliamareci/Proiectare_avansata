public class ComputerLabs extends Room{
    String system;

    public ComputerLabs(String name, int capacity, String system) {
        super(name, capacity);
        this.system = system;
    }
    public ComputerLabs() {
    }

    @Override
    public String toString() {
        return "ComputerLabs{" +
                "system='" + system + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
