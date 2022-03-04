/**
 * Compulsory lab2
 * @author Mareci Ioana Amalia
 */
public class Main {

    public static void main(String[] args) {
        //crearea evenimentelor din exemplu
        Event event1 = new Event("C1", 100, 8, 10);
        Event event2 = new Event("C2", 100, 10, 12);
        Event event3 = new Event("L1", 30, 8, 10);
        Event event4 = new Event("L2", 30, 8, 10);
        Event event5 = new Event("L3", 30, 10, 12);

        //crearea camerelor din exemplu
        Room room1=new Room("401",30,RoomType.COMPUTER_LABS);
        Room room2=new Room("403",30,RoomType.COMPUTER_LABS);
        Room room3=new Room("405",30,RoomType.COMPUTER_LABS);
        Room room4=new Room("309",100,RoomType.LECTURE_HALLS);

        //afisare
        System.out.println(event1.toString());
        System.out.println(event2.toString());
        System.out.println(event3.toString());
        System.out.println(event4.toString());
        System.out.println(event5.toString());
        System.out.println(room1.toString());
        System.out.println(room2.toString());
        System.out.println(room3.toString());
        System.out.println(room4.toString());
    }
}
