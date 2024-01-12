package design.patterns.decorator.message.delivery;

public class ServerDeliverer implements  Deliverer {

    private Deliverer deliverer;

    public ServerDeliverer() {

    }

    public ServerDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    @Override
    public void deliver(String message) {
        if(this.deliverer != null) {
            this.deliverer.deliver(message);
        }
        System.out.println("Delivering to Server");
    }
}
