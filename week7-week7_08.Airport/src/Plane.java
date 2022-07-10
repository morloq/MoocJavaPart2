public class Plane {
    private final String planeID;
    private final String planeCapacity;
    
    public Plane(String planeID, String planeCapacity)
    {
        this.planeCapacity = planeCapacity;
        this.planeID = planeID;
    }
    
    public String getID()
    {
        return this.planeID;
    }
    
    public String getCapacity()
    {
        return this.planeCapacity;
    }
}