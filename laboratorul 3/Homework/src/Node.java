import java.util.Objects;
import java.util.*;

public class Node implements Comparable<Node> {
    String name;
    String locationMap;
    String macAddress;
    Map<Node, Integer> cost = new HashMap<Node, Integer>();

    public Node(String name, String locationMap, String macAddress) {
        this.name = name;
        this.locationMap = locationMap;
        this.macAddress = macAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationMap() {
        return locationMap;
    }

    public void setLocationMap(String locationMap) {
        this.locationMap = locationMap;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Map<Node, Integer> getCost() {
        return new HashMap<>(cost);
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Node other) {
        if (other.name == null) {
            throw new IllegalArgumentException("null name");
        }
        return this.locationMap.compareTo(other.locationMap);
    }

    /**
     * is used in printNetwork() from Network class for printing the example
     */
    public String print() {
        String temp = new String();
        for (Node key : cost.keySet()) {
            temp = temp.concat(this.getLocationMap());
            temp = temp.concat("--");
            temp = temp.concat(key.getLocationMap());
            temp = temp.concat(" ");
            temp = temp + cost.get(key);
            temp = temp.concat("\n");
        }
        return temp;
    }

    ////

}
