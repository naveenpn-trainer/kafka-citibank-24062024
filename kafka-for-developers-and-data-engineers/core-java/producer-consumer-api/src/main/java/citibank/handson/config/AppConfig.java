package citibank.handson.config;

import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public interface AppConfig {
    String KAFKA_BROKERS = "localhost:9092";
    String MY_CUSTOM_TOPIC = "my-demo-topic";


    /*
         Serilizers and Deserializer
     */
    String STRING_KEY_SERIALIZER = StringSerializer.class.getName();
    String STRING_VALUE_SERIALIZER = StringSerializer.class.getName();;
    String STRING_KEY_DESERIALIZER = StringDeserializer.class.getName();
    String STRING_VALUE_DESERIALIZER = StringDeserializer.class.getName();
}
