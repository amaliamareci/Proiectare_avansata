import java.util.Objects;

/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public class Event {
    String name;
    int nrParticipant;
    int startTime;
    int endTime;

    public Event() {
    }

    public Event(String name, int nrParticipant, int startTime, int endTime) {
        this.name = name;
        this.nrParticipant = nrParticipant;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return name + "( size=" + nrParticipant + ", start="+ startTime + ", end=" + endTime + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return name.equals(event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nrParticipant, startTime, endTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrParticipant() {
        return nrParticipant;
    }

    public void setNrParticipant(int nrParticipant) {
        this.nrParticipant = nrParticipant;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
