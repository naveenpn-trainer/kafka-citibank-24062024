package citibank.handson.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        // Step 01 : Set up the properties for the Kafka producer
        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"producerA");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Step 02 : Create the KafkaProducer object
        Producer<Integer,String> producer = new KafkaProducer<>(properties);
        for(int i=0;i<10000;i++){
            ProducerRecord record = new ProducerRecord<>("my-demo-topic",String.valueOf(i));
            producer.send(record);
        }
        producer.close();
    }
}
