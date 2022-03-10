import java.util.Objects;
import java.sql.Time;
/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public abstract class Room {
    String name;
    int capacity;
    Time finalTimeEvent;

    public Room() {
    }

    public Room(String name,  int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.finalTimeEvent=new Time(0,0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return name.equals(room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
