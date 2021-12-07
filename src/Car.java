public class Car {
    private static final int STOPPED = 0; //car speed is 0m/s
    private static final int NEXT_ROAD_INDEX = 0;
    private static final int START_POSITION = 1;
    String id; // Set the unique identifier
    static float length; // Number of segments occupied, 1 for ease of prototype
    private static float breadth;
    private int speed; //Segments moved per turn
    private int position; // Position of the current road
    private Road currentRoad; // Current Road object


    public Car(String id, Road currentRoad) {
        this.id = "car_" + id;
        this.currentRoad = currentRoad;
        length = 1f; // Cars made 1m long for prototype
        breadth = length * 0.5f;
        speed = 0;
        position = 1;
        this.currentRoad.getCarsOnRoad().add(this); //Add this car to the road its on.
    }

    public Car() {
        id = "000";
        length = 1f;
        breadth = length * 0.5f;
        speed = 0;
        position = 1;
    }

    public void move() {
        this.speed = this.currentRoad.getSpeedLimit(); //Set the speed of car limit to that of currentRoad
        if (!this.currentRoad.getLightsOnRoad().isEmpty() && this.position == this.currentRoad.getLightsOnRoad().get(0).getPosition() && this.currentRoad.getLightsOnRoad().get(0).getState().equals("red")) {
            this.speed = STOPPED;
        } else {
            this.speed = this.currentRoad.getSpeedLimit();
            if (this.currentRoad.getLength() == this.getPosition() && !this.currentRoad.getConnectedRoads().isEmpty()) {
                this.currentRoad.getCarsOnRoad().remove(this);
                this.currentRoad = this.currentRoad.getConnectedRoads().get(NEXT_ROAD_INDEX);
                this.currentRoad.getCarsOnRoad().add(this);
                this.position = START_POSITION;
            } else if (this.currentRoad.getLength() > this.getPosition()) {
                this.position = (this.position + this.speed);
            } else {
                this.speed = STOPPED;
            }
        }
    }

    public void printCarStatus() {
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getCurrentRoad().
                getId(), this.getPosition());
    }

    public float getLength() {  //Get the length of the Car
        return length;
    }

    public void setLength(float length) {   //Set the length of the Car
        Car.length = length;
    }

    public float getBreadth() {
        return breadth;
    }

    public void setBreadth(float breadth) {
        Car.breadth = breadth;
    }

    public int getSpeed() {     //Get the speed of the Car
        return speed;
    }

    public void setSpeed(int speed) {   //Set the speed of the Car
        this.speed = speed;
    }

    public int getPosition() {      //Get the positon of the Car
        return position;
    }

    public void setPosition(int position) { //Set the position of the Car
        this.position = position;
    }

    public Road getCurrentRoad() {      // Get the Current Road for the Car using getCurrentRoad method
        return currentRoad;
    }

    public void setCurrentRoad(Road currentRoad) {  // Set the Current Road for the Car using getCurrentRoad method
        this.currentRoad = currentRoad;
    }

    public String getId() {     // Get ID for the Car
        return id;
    }

    public void setId(String id) {  // Set ID for the Car
        this.id = id;
    }

}

