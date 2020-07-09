package producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RoutingProducerApp {
    private final static String Exchange_NAME = "direct_exchange";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(Exchange_NAME, "direct");

            String routingKey = "[info]";
            String msg = "message";

            channel.basicPublish(Exchange_NAME, routingKey, null, msg.getBytes("UTF-8"));
            System.out.println("sent" + routingKey + " " + msg);
        }
    }
}