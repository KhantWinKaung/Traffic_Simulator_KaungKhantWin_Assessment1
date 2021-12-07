public class Motorbike extends Car {    // Mortorbike class for the Traffic Simulation extends from the Car Class

    public Motorbike(String id) {
        this.id = ("bike_" + id);
        length = super.getLength() * 0.5f;
    }

}
