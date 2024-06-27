package citibank.handson.consumer.consumer_groups.withoutmultithreaded;

import citibank.handson.config.AppConfig;
import org.apache.kafka.clients.consumer.*;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer_01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumerA");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfig.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_KEY_DESERIALIZER);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_VALUE_DESERIALIZER);
        properties.put("group.id", "demo-group");

        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(AppConfig.MY_CUSTOM_TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.partition() + "-" + record.value());
            }
        }

    }
}
