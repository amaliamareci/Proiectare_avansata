import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Network() {
    }

    /**
     * @param nodes can be Computer,Switch,Routers
     *              adding the nodes in the list
     */
    public void addNodes(Node... nodes) {
        for (Node node : nodes) {
            this.nodes.add(node);

        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        Collections.sort(nodes);
        String temp = new String();
        for (Node node : nodes)
            temp = temp.concat(node.toString());
        return temp;
    }

    /**
     * printing only the identifiable nodes
     */
    public void identifiableNodes() {
        List<Node> onlyIdentifiableNodes = new ArrayList<>();
        for (Node node : nodes)
            if (node instanceof Identifiable)
                onlyIdentifiableNodes.add(node);
        Collections.sort(onlyIdentifiableNodes);
        String temp = new String();
        for (Node node : onlyIdentifiableNodes)
            temp = temp.concat(node.toString());
        System.out.println(temp);
    }

    /**
     * printing the network from example
     */
    public void printNetwork() {
        String temp = new String();
        for (Node node : nodes)
            temp = temp + node.print();
        System.out.println(temp);

    }

}
