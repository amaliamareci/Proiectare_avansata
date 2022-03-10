/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
import java.sql.Time;
public class Problem {

    public static void main(String[] args) {
        Event events[]=new Event[5];
        //events

        Time start;
        events[0] = new Event("C1", 100, start=new Time(8,0,0), start=new Time(10,0,0));
        events[1] = new Event("C2", 100,start=new Time(10,0,0), start=new Time(12,0,0));
        events[2] = new Event("L1", 30, start=new Time(8,0,0), start=new Time(10,0,0));
        events[3] = new Event("L2", 30, start=new Time(8,0,0), start=new Time(10,0,0));
        events[4] = new Event("L3", 30, start=new Time(10,0,0), start=new Time(12,0,0));

        Room rooms[]=new Room[4];
        //rooms
        rooms[0]=new ComputerLabs("401",30,"windows");
        rooms[1]=new ComputerLabs("403",30,"windows");
        rooms[2]=new ComputerLabs("405",30,"linux");
        rooms[3]=new LectureHall("309",100,true);

        //Solution with graph using DSatur
        SolutionGraph sol2=new SolutionGraph(rooms,events);
        sol2.DSatur();

    }

}
