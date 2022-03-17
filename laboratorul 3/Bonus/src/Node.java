import java.util.Objects;
import java.util.*;
public class Node implements Comparable<Node> {
    String name;
    String locationMap;
    String macAddress;
    double distance;
    boolean known;

    Map<Node, Integer> new_cost = new HashMap<>();


    public Node(String name, String locationMap, String macAddress) {
        this.name = name;
        this.locationMap = locationMap;
        this.macAddress = macAddress;
    }
    public Node getNode(){return this;}
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
        return new HashMap<>(new_cost);
    }

    public void setCost(Node node, int value , int probability) {
        new_cost.put(node, value*probability);
    }


    @Override
    public int compareTo(Node other){
        if(other.name == null) {
            throw new IllegalArgumentException("null name");
        }
        return this.locationMap.compareTo(other.locationMap);
    }

    public String print() {
        String temp = new String();
        for (Node key : new_cost.keySet()) {
            temp = temp.concat(this.getLocationMap());
            temp = temp.concat("--");
            temp = temp.concat(key.getLocationMap());
            temp = temp.concat(" ");
            temp = temp + new_cost.get(key);
            temp = temp.concat("\n");
        }
        return temp;
    }

    ////

}
