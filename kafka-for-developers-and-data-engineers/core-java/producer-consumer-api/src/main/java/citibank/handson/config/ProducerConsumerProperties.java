package citibank.handson.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerConsumerProperties {

    public Properties getProducerProperties(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"producerA");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConfig.KAFKA_BROKERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    public Properties getConsumerProperties(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG,"consumerA");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConfig.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put("group.id","demo-group");
        return  properties;
    }
}
