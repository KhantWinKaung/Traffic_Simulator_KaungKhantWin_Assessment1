import java.util.ArrayList;

public class Road {     // Road class for the Traffic Simulation
    private String id;
    private int speedLimit;     // Speed limit on the road
    private int length;     // Length of the Road
    private int[] startLocation;    // Start Location of the Road Using Array
    private int[] endLocation;      // End Location of the Road Using Array
    private ArrayList<Car> carsOnRoad = new ArrayList<>();  // Car on the Road
    private ArrayList<TrafficLight> lightsOnRoad = new ArrayList<>();   // Traffic Light on the Road
    private ArrayList<Road> connectedRoads = new ArrayList<>();     // Connected road

    public Road(String id, int speedLimit, int length, int[] startLocation) {
        this.id = "road_" + id;
        this.speedLimit = speedLimit;
        this.length = length;
        this.startLocation = startLocation;
        this.endLocation = new int[]{this.length + this.startLocation[0], 0}; // Only works for horizontal roads;
    }

//    public void createCars(int carSpawns) {
//        for (int i = 0; i < carSpawns; i++)
//            carsOnRoad.add(new Car(Integer.toString(i), this));
//    }


    public String getId() { // Get Id for the Road
        return id;
    }

    public void setId(String id) {  // Set ID for the Road
        this.id = id;
    }

    public int getSpeedLimit() {    // Get Speed limit for the road
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {     // Set Speed Limit for the Road
        this.speedLimit = speedLimit;
    }

    public int getLength() {    // Get length of the road
        return length;
    }

    public void setLength(int length) {     // Set Length of the road
        this.length = length;
    }

    public String printStartLocation() {
        return startLocation[0] + "," + startLocation[1];
    }

    public void setStartLocation(int[] startLocation) {
        this.startLocation = startLocation;
        this.endLocation = new int[]{this.length + this.startLocation[0], 0}; //only works for horizontal roads;
    }

    public String printEndLocation() {
        return endLocation[0] + "," + endLocation[1];
    }

    public void printRoadInfo() {
        System.out.printf("%s limit of:%dm/s is %dm long at location:%s to %s%n", this.getId(), this.getSpeedLimit(), this.getLength(), this.printStartLocation(), this.printEndLocation());
    }

    public void setEndLocation(int[] endLocation) {
        this.endLocation = endLocation;
    }

    public int[] getStartLocation() {   // Get start location of the road
        return startLocation;
    }

    public int[] getEndLocation() {     // Set start location of the road
        return endLocation;
    }

    public ArrayList<Car> getCarsOnRoad() {     // Get car on the road
        return carsOnRoad;
    }

    public void setCarsOnRoad(ArrayList<Car> carsOnRoad) {      // Set car on the road
        this.carsOnRoad = carsOnRoad;
    }

    public ArrayList<TrafficLight> getLightsOnRoad() {      // Get Traffic Light on the road
        return lightsOnRoad;
    }

    public void setLightsOnRoad(ArrayList<TrafficLight> lightsOnRoad) {     // Set Traffic Light on the Road
        this.lightsOnRoad = lightsOnRoad;
    }

    public ArrayList<Road> getConnectedRoads() {    // Get the road which are Connected
        return connectedRoads;
    }

    public void setConnectedRoads(ArrayList<Road> connectedRoads) {     // Set the road which are connected
        this.connectedRoads = connectedRoads;
    }
}
