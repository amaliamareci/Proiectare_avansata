public interface Storage {
    void setStorageCapacity(int storageCapacity);
    int getCapacity();
    public default int inMega(){
        int x=getCapacity();
        return x*1000;
    }
    public default long  inKilo(){
        int x=getCapacity();
        return x*1000000;
    }
    public default long inBytes(){
        int x=getCapacity();
        return  x*1000000000;
    }
}
