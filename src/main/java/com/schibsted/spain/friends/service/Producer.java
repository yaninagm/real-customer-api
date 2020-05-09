package com.schibsted.spain.friends.service;

import org.springframework.stereotype.Service;

@Service
public class Producer {
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(KafkaProperties.Producer.class);
    private static final String TOPIC = "users";

    //@Autowired
    //private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //logger.info(String.format("#### -> Producing message -> %s", message));
        //String.format("#### -> Producing message -> %s", message);
        System.out.println("#### -> Producing message -> %s "+ message);
        //this.kafkaTemplate.send(TOPIC, message);
    }
}
