public class Bus extends Car {      //Bus class for the traffic simulations

    public Bus(String id) {
        this.id = ("bus_" + id);
        length = super.getLength() * 3;
    }
}
