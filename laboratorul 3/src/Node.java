import java.util.Objects;

public class Node implements Comparable<Node> {
    String name;
    String locationMap;
    String macAddress;

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
    @Override
    public int compareTo(Node other){
        if(other.name == null) {
            throw new IllegalArgumentException("null name");
        }
        return this.locationMap.compareTo(other.locationMap);
    }

}
