public class Switch  extends Node{
    public Switch(String name, String locationMap, String macAddress) {
        super(name, locationMap, macAddress);
    }

    @Override
    public String toString() {
        return getLocationMap()+"("+"Switch " +getName()+")";
    }
}
