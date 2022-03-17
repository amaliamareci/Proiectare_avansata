/**
 * Mareci Ioana Amalia 2A2
 * PA bonus lab3
 */
public class Main {

    public static void main(String[] args) {
        Network network = new Network();
        Computer c1, c2;
        Router r1, r2;
        Switch s1, s2;
        //example from the lab
        network.addNodes(
                c1 = new Computer("A", "v1", "0.0.1", "192.168.0.1", 100),
                c2 = new Computer("B", "v6", "1.0.1", "192.168.0.2", 200),
                r1 = new Router("A", "v2", "1.1.1", "1.1.4"),
                r2 = new Router("B", "v5", "1.1.1", "1.1.4"),
                s1 = new Switch("A", "v3", "1.2.6"),
                s2 = new Switch("B", "v4", "1.2.6")
        );
        //setting the cost and probability of failure
        c1.setCost(r1, 10, 2);
        r1.setCost(c1, 10, 2);

        c1.setCost(s1, 5, 1);
        s1.setCost(c1, 5, 1);

        r1.setCost(s1, 20, 1);
        s1.setCost(r1, 20, 1);

        r1.setCost(r2, 10, 1);
        r2.setCost(r1, 10, 1);

        r1.setCost(s2, 5, 2);
        s2.setCost(r1, 5, 2);

        s1.setCost(s2, 1, 5);
        s2.setCost(s1, 1, 5);

        s2.setCost(r2, 1, 5);
        r2.setCost(s2, 1, 5);

        s2.setCost(c2, 10, 6);
        c2.setCost(s2, 10, 6);

        r2.setCost(c2, 20, 45);
        c2.setCost(r2, 20, 45);


        Path plan = new Path(network);

        Node[] nodes = {c1, c2, r1, r2, s1, s2};
        //dijkstra for finding the minim cost and path between each two nodes
        for (int i = 0; i < nodes.length - 1; ++i) {
            for (int j = 0; j < nodes.length; ++j) {
                if (i != j) {
                    System.out.println("Shortest distance from " + nodes[i].getLocationMap() + " to " + nodes[j].getLocationMap() + " is: " + plan.getShortestPath(nodes[i], nodes[j]) + " with path");
                    plan.printPath();
                }
            }
        }

    }

}
