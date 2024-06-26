package citibank.partitioning_mechanism;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class _04_CustomPartitioningMechanism {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "producerA");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"citibank.partitioning_mechanism.MyCustomPartitioner");

        // Step 02 : Create the KafkaProducer object
        Producer<Integer, String> producer = new KafkaProducer<>(properties);
        Scanner input = new Scanner(System.in);
        String message = null;
        String key;
        do {
            System.out.println("Enter message");
            message = input.nextLine();

            System.out.println("Enter key");
            key =input.nextLine();
            if (!message.equals("quit")) {
                ProducerRecord record = new ProducerRecord<>("my-demo-topic",  key, message);
                producer.send(record);
            }
        } while (!message.equals("quit"));

        producer.close();
    }
}
