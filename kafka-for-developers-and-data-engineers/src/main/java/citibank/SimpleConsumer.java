package citibank;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SimpleConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG,"consumerA");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put("group.id","demo-group");

        Consumer<Integer,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("my-demo-topic"));
        while(true){
            ConsumerRecords<Integer,String> records = consumer.poll(1000);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.println(record);
            }
        }

    }
}
