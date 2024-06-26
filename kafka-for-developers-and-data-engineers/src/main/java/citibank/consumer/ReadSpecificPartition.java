package citibank.consumer;

import citibank.config.AppConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class ReadSpecificPartition {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumerB");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfig.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_KEY_DESERIALIZER);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AppConfig.STRING_VALUE_DESERIALIZER);
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put("group.id", "demo-group-2");

        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.assign(Collections.singletonList(new TopicPartition(AppConfig.MY_CUSTOM_TOPIC,0)));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.partition() + "-" + record.value());
            }
        }
    }
}
