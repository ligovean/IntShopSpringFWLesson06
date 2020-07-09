package consumer;

import com.rabbitmq.client.*;

public class RoutingConsumerApp {

    private final static String Exchange_NAME = "direct_exchange";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Exchange_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        String routingKey = "[info]";
        channel.queueBind(queueName, Exchange_NAME,routingKey);
        System.out.println("wait message");

        final DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody(), "UTF-8");
            System.out.println("Receiver" + msg + " " + delivery.getEnvelope().getRoutingKey());
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
