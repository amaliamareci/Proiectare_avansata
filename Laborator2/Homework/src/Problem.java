/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public class Problem {

    public static void main(String[] args) {
        Event events[]=new Event[5];
        //crearea evenimentelor din exemplu
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);

        //ComputerLabs lab=new ComputerLabs("Windows");
        //LectureHall hall=new LectureHall(true);
        Room rooms[]=new Room[4];
        //crearea camerelor din exemplu
        rooms[0]=new ComputerLabs("401",30,"windows");
        rooms[1]=new ComputerLabs("403",30,"windows");
        rooms[2]=new ComputerLabs("405",30,"linux");
        rooms[3]=new LectureHall("309",100,true);

        Solution sol=new Solution(rooms,events);
        sol.Distribution();
        //afisare
        /*
        System.out.println(event1.toString());
        System.out.println(event2.toString());
        System.out.println(event3.toString());
        System.out.println(event4.toString());
        System.out.println(event5.toString());
        System.out.println(room1.toString());
        System.out.println(room2.toString());
        System.out.println(room3.toString());
        System.out.println(room4.toString());
        Array<Room>[]rooms=new Array<Room>[];*/

    }
}
