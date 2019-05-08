package com.stackroute.freelancerprofile.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.freelancerprofile.domain.Bid;
import com.stackroute.freelancerprofile.domain.Freelancer;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;



public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

//    @Value("${kafka.topic.json}")
//    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;



    public void  sendBid(Object object) {
        System.out.println("Sending");
        kafkaTemplate.send("myTopic", object);
    }



    public void sendFreelancer(Object object){
        System.out.println(object);
        System.out.println("Sending");
        kafkaTemplate.send("freelancerTopic",object);

    }


}

