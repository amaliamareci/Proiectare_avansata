/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 *in this class i create the problem(events and rooms)
 */
public class Problem {

    public static void main(String[] args) {
        Event events[]=new Event[5];
        //events
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);

        Room rooms[]=new Room[4];
        //rooms
        rooms[0]=new ComputerLabs("401",30,"windows");
        rooms[1]=new ComputerLabs("403",30,"windows");
        rooms[2]=new ComputerLabs("405",30,"linux");
        rooms[3]=new LectureHall("309",100,true);

        Solution sol=new Solution(rooms,events);
        //the solution of the problem
        sol.Distribution();
    
    }
}
