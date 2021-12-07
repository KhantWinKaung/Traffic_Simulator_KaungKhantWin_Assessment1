import java.util.Random;

public class TrafficLight {         // Traffic Light calss for the Traffic Simulatiors
    private static final double CHANGE_GREEN = 0.5; // 50/50 chance of changing state.
    private static final String GREEN = "green";    // Set the Green Traffic Light
    private static final String RED = "red";        // Set the Red Traffic Light
    private String id;      // ID for Traffic Light
    private String state;   // State for Traffic Light
    private int position;   // Position of the Traffic Light
    private Road roadAttachedTo;

    public TrafficLight(String id, Road road) {
        this.id = "light_" + id;
        state = RED;
        this.roadAttachedTo = road;
        position = this.roadAttachedTo.getLength(); // always places the traffic light at the end of the roadAttachedTo.
        this.roadAttachedTo.getLightsOnRoad().add(this); // adds this light to the road it belongs to.
    }

    public void operate(int seed) {
        Random random = new Random(seed);
        double probability = random.nextDouble();
        if (probability > CHANGE_GREEN) {
            this.setState(GREEN);
        } else {
            this.setState(RED);
        }
    }

    public void printLightStatus() {
        System.out.printf("%s is:%s on %s at position:%s%n", this.getId(), this.getState(), this.getRoadAttachedTo().getId(), this.getPosition());
    }

    public String getState() {      // Get the state of the Traffic Light
        return state;
    }

    public void setState(String state) {        // Set the state of the Traffic Light
        this.state = state;
    }

    public Road getRoadAttachedTo() {
        return roadAttachedTo;
    }

    public void setRoadAttachedTo(Road roadAttachedTo) {
        this.roadAttachedTo = roadAttachedTo;
    }

    public int getPosition() {  // Get the Position of the Traffic Light
        return position;
    }

    public int setPosition() {  // set the Position of the Traffic Light
        return position;
    }

    public String getId() {     // Get the ID of the Traffic Light
        return id;
    }

    public void setId(String id) {      // Set the ID of the Traffic Light
        this.id = id;
    }

}
