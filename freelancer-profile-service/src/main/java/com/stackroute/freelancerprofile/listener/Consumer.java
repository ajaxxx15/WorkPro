package com.stackroute.freelancerprofile.listener;

import com.stackroute.freelancerprofile.domain.BidKafka;
import com.stackroute.freelancerprofile.domain.ProjectsOfProjectOwner;
import com.stackroute.freelancerprofile.service.BidKafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import javax.sound.midi.Receiver;
import java.util.concurrent.CountDownLatch;


public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    private BidKafkaService bidService;


    public Consumer() {
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "projectDetails")
    public void receive(BidKafka bidKafka) {
        System.out.println(bidKafka);
        bidService.save(bidKafka);
    }

}
