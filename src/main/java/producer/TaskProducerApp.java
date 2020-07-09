package producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class TaskProducerApp {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            boolean durable = true;
            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
            String msg = "new Task!";
            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_BASIC,
                    msg.getBytes("UTF-8"));
            System.out.println("sent " + msg);
        }
    }
}