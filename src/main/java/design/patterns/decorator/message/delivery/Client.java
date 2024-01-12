package design.patterns.decorator.message.delivery;

public class Client {
    public static void main(String[] args) {
        Deliverer deliverer = new ServerDeliverer(
                new KafkaDeliverer(
                        new MQDeliverer()
                )
        );
        deliverer.deliver("Simple message");
    }
}
