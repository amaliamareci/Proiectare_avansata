import java.util.*;
public class Network {
    List<Node>nodes=new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Network() {
    }

    /**
     * @param nodes can be Computer,Switch,Routers
     *  adding the nodes in the list
     */
    public void addNodes(Node... nodes){
        for(Node node : nodes)
        this.nodes.add(node);
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
        for(Node node : nodes)
            temp = temp.concat(node.toString());
        return temp;
    }
}
