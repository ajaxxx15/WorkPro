package com.stackroute.freelancerprofile.service;


import com.stackroute.freelancerprofile.domain.Bid;
import com.stackroute.freelancerprofile.domain.BidKafka;
import com.stackroute.freelancerprofile.repository.BidKafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidKafkaService {
    private BidKafkaRepository bidKafkaRepository;

    @Autowired
    public BidKafkaService(BidKafkaRepository bidKafkaRepository) {
        this.bidKafkaRepository = bidKafkaRepository;
    }
    public BidKafka save(BidKafka bid) {
        BidKafka result = bidKafkaRepository.save(bid);
        return result;
    }
    public List<BidKafka> search(String email) {
        List<BidKafka> resultFreelancer = new ArrayList<BidKafka>();

        List<BidKafka> list = bidKafkaRepository.findAll();
        for (BidKafka skill1 : list) {
            System.out.println("inside For");
            System.out.println(skill1);
            if ((skill1.getFreelancerEmail()).equals(email)) {
//                LOGGER.info("inside if............................." + email);
//                LOGGER.info(skill1.getFreelancerEmail());
                resultFreelancer.add(skill1);
                System.out.println(resultFreelancer);
            }
        }
        return resultFreelancer;


    }
}
