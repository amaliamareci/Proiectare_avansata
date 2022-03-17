import java.util.*;

/**
 * in this class in GetShortestPath I implemented Dijkstra's algorithm to find the minim cost between two nodes
 * and printPath() for printing the location map of the nodes in the path
 */
public class Path {
    private Network network;
    private List<Node> nodes;
    private final int MAXVAL;
    private int[] parent;
    int startIndex;
    int finishIndex;
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
        //dijkstra
        int n = nodes.size();
        startIndex = nodes.indexOf(start);
        finishIndex = nodes.indexOf(finish);
        int d[] = new int[n]; //array care tine evidenta legat de cel mai scurt drum de la start la celelalte locatii
        boolean viz[] = new boolean[n], ok = true;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;
        viz[startIndex] = true;
        for (int i = 0; i < n; ++i) {
            if (i == startIndex) {
                d[i] = 0;
            } else {
                if (start.getCost().get(nodes.get(i)) != null)
                    d[i] = start.getCost().get(nodes.get(i));
                else
                    d[i] = MAXVAL;
                parent[i] = startIndex;
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
                    parent[neighbourIndex] = currentIndex;
                }
            }
        }
        System.out.println();
        return d[finishIndex];

    }

    /**
     * printing the path using the parent array
     */
    public void printPath() {

        ArrayList<Integer> path = new ArrayList<Integer>();
        int i = finishIndex;
        while (i != startIndex) {
            path.add(parent[i]);
            i = parent[i];
        }
        Collections.reverse(path);
        int shortestPath[] = new int[path.size()];

        for (int j = 0; j < path.size(); j++) {
            shortestPath[j] = path.get(j);
        }
        for (int k = 0; k < shortestPath.length; k++)
            System.out.print(nodes.get(shortestPath[k]).locationMap);
        System.out.print(nodes.get(finishIndex).locationMap);
        System.out.println();
    }


}
