import java.util.Objects;
import java.sql.Time;
/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public class Event {
    String name;
    int nrParticipant;
    Time startTime;
    Time endTime;

    public Event() {
    }

    public Event(String name, int nrParticipant, Time startTime,Time endTime) {
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
