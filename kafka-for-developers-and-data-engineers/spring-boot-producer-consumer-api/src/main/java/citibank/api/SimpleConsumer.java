package citibank.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleConsumer.class);

    @KafkaListener(topics = "my-custom-topic", groupId = "my-group")
    public void consume(String message) {
        LOGGER.info("Message received: %s".formatted(message));
    }
}
