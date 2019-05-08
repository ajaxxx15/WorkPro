package com.stackroute.freelancerprofile.service;


import com.stackroute.freelancerprofile.domain.Bid;
import com.stackroute.freelancerprofile.domain.Freelancer;
import com.stackroute.freelancerprofile.repository.BidRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BidServiceImpl implements BidService {
    private BidRepository bidRepository;
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BidServiceImpl.class);

    @Autowired
    BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid save(Bid bid) {
        Bid result = bidRepository.save(bid);
        return result;
    }

    public List<Bid> allBids(String email) {
        List<Bid> resultFreelancer = new ArrayList<Bid>();

        List<Bid> list = bidRepository.findAll();
        for (Bid skill1 : list) {
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
