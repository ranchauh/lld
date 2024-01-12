package design.patterns.decorator.message.delivery;

public class KafkaDeliverer implements  Deliverer {

    private Deliverer deliverer;

    public KafkaDeliverer() {

    }

    public KafkaDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    @Override
    public void deliver(String message) {
        if(this.deliverer != null) {
            this.deliverer.deliver(message);
        }
        System.out.println("Delivering to kafka");
    }
}
