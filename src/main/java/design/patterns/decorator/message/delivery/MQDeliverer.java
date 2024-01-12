package design.patterns.decorator.message.delivery;

public class MQDeliverer implements  Deliverer {

    private Deliverer deliverer;

    public MQDeliverer() {

    }

    public MQDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    @Override
    public void deliver(String message) {
        if(this.deliverer != null) {
            this.deliverer.deliver(message);
        }
        System.out.println("Delivering to MQ");
    }
}
