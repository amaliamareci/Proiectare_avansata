import java.util.*;

/**
 * in this class in GetShortestPath I implemented Dijkstra's algorithm to find the minim cost between two nodes
 */
public class Path {
    private Network network;
    private List<Node> nodes;
    private final int MAXVAL;
    //constructor
    public Path(Network network) {
        this.network = network;
        this.nodes = network.getNodes();
        this.MAXVAL = 999999;
    }

    /**
     * Dijkstra
     * @param start -start node
     * @param finish-finish node
     * @return minim cost between start node and finish node
     */
    public int getShortestPath(Node start, Node finish) {
        int n = nodes.size(), startIndex = nodes.indexOf(start), finishIndex = nodes.indexOf(finish);
        int d[] = new int[n]; //array for minim costs
        boolean viz[] = new boolean[n], ok = true;
        viz[startIndex] = true;
        for (int i = 0; i < n; ++i) {
            if (i == startIndex) {
                d[i] = 0;
            } else {
                if (start.getCost().get(nodes.get(i)) != null)
                    d[i] = start.getCost().get(nodes.get(i));
                else
                    d[i] = MAXVAL;
            }
        }
        while (ok) {
            int min = MAXVAL, currentIndex = -1;
            for (int i = 0; i < n; ++i) {
                if (d[i] < min && !viz[i]) {
                    min = d[i];
                    currentIndex = i;
                }
            }
            if (min == MAXVAL) {
                ok = false;
                break;
            }
            viz[currentIndex] = true;
            Node currentLocation = nodes.get(currentIndex);
            Map<Node, Integer> tempCost;
            tempCost = currentLocation.getCost();
            for (Map.Entry<Node, Integer> entry : tempCost.entrySet()) {
                int neighbourIndex = nodes.indexOf(entry.getKey());
                if (d[currentIndex] + entry.getValue() < d[neighbourIndex] && !viz[neighbourIndex]) {
                    d[neighbourIndex] = d[currentIndex] + entry.getValue();
                }
            }
        }
        return d[finishIndex];
    }


}
