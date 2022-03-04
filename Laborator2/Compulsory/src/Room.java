/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public class Room {
    String name;
    RoomType type;
    int capacity;

    public Room() {
    }

    public Room(String name,  int capacity,RoomType type) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String newType;
        if(type==RoomType.LECTURE_HALLS)
            newType="lecture hall";
        else
            newType="lab";
        return  name + '(' + "cap="
                +capacity+", " +newType+")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
