public class Router extends Node implements Identifiable {
    String IP;

    public Router(String name, String locationMap, String macAddress, String IP) {
        super(name, locationMap, macAddress);
        this.IP = IP;
    }

    @Override
    public String getAddress() {
        return this.IP;
    }

    @Override
    public void setAddress(String IP) {
        this.IP = IP;
    }

    @Override
    public String toString() {
        return locationMap + "(" + "Router " + getName() + ")";
    }


}
