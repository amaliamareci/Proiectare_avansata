public class MinTree {
    private final int V;

    public MinTree(int dim) {
        V = dim;
    }

    /**
     * @param key the cost values
     * @param viz set of vertices included in the MST
     * @return minimum key from the vertices that are not yet included in MST
     */
    int minKey(int key[], Boolean viz[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (viz[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    /**
     * printing the MST for the graph and minimum cost
     */
    void printMST(int parent[], int graph[][]) {
        int cost = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            cost += graph[i][parent[i]];
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
        System.out.println("Total cost is :" + cost);
    }

    /**
     * building the MST with Prim algorithm
     */
    void primMST(int graph[][]) {
        // Array to store constructed MST
        int parent[] = new int[V];

        int key[] = new int[V];

        // the set of vertices included in MST
        Boolean viz[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            viz[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, viz);
            viz[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && viz[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(parent, graph);
    }
}
