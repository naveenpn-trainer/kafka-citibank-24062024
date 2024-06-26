package citibank.consumer;

import citibank.config.AppConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumerA");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfig.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_KEY_DESERIALIZER);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_VALUE_DESERIALIZER);
        properties.put("group.id", "demo-group");

        Consumer<Integer, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(AppConfig.MY_CUSTOM_TOPIC));
        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(1000);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.println(record.partition() + "-" + record.value());
            }
        }

    }
}
