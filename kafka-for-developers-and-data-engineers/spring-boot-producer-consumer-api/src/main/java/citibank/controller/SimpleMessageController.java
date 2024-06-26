package citibank.controller;

import citibank.api.SimpleConsumer;
import citibank.api.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class SimpleMessageController {

    @Autowired
    private SimpleProducer simpleProducer;

    // localhost:8080/api/v1/kafka/publish?message=Message1
    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message")String message){
        this.simpleProducer.sendMessage(message);
        return ResponseEntity.ok("Message published successfully");
    }

}
