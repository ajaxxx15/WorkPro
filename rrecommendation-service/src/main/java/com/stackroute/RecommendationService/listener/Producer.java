package com.stackroute.RecommendationService.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

//    @Value("${kafka.topic.json}")
//    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void  sendBid(Object object) {
        System.out.println("Sending");
        kafkaTemplate.send("recommendTopic", object);
    }
}
