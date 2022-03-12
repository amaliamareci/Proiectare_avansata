/**
 * Mareci Ioana Amalia 2A2
 * PA compulsory lab3
 */
public class Main {

    public static void main(String[] args) {
        Network network = new Network();
        //example from the lab
        network.addNodes(
                new Computer("A", "v1","0.0.1" , "192.168.0.1", 100),
                new Computer("B", "v6",  "1.0.1","192.168.0.2", 200),
                new Router("A", "v2","1.1.1",  "1.1.4"),
                new Router("B", "v5","1.1.1",  "1.1.4"),
                new Switch("A", "v3", "1.2.6"),
                new Switch("B", "v4", "1.2.6")
        );
        //printing the locations and their nodes
        System.out.println(network.toString());
    }
}
