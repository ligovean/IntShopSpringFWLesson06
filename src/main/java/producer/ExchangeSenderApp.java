package producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class ExchangeSenderApp {
    private final static String Exchange_NAME = "example-2";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(Exchange_NAME, "fanout");
            String msg = "info: Hello World!";
            channel.basicPublish(Exchange_NAME, "", null, msg.getBytes("UTF-8"));
            System.out.println("sent Exchange" + msg);
        }
    }
}
