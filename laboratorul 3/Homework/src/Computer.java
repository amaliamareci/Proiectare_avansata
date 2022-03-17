public class Computer extends Node implements Identifiable, Storage {
    private String IP;
    private int capacity;

    public Computer(String name, String locationMap, String macAddress, String IP, int capacity) {
        super(name, locationMap, macAddress);
        this.IP = IP;
        this.capacity = capacity;
    }

    @Override
    public void setStorageCapacity(int storageCapacity) {
        this.capacity = storageCapacity;
    }

    @Override
    public String getAddress() {
        return this.IP;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void setAddress(String IP) {
        this.IP = IP;
    }

    @Override
    public String toString() {
        return locationMap + "(" + "Computer " + getName() + ")";
    }

    @Override
    public int inMega() {
        return Storage.super.inMega();
    }

    @Override
    public long inKilo() {
        return Storage.super.inKilo();
    }

    @Override
    public long inBytes() {
        return Storage.super.inBytes();
    }
}
