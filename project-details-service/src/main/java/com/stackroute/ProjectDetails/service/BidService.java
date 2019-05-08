package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.BidKafka;
import com.stackroute.ProjectDetails.repository.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    private BidRepo bidRepo;

@Autowired
    public BidService(BidRepo bidRepo) {
        this.bidRepo = bidRepo;
    }

    public List<BidKafka> getAll(){
    return bidRepo.findAll();
    }

    public BidKafka save(BidKafka bidKafka){

    return bidRepo.save(bidKafka);
    }
}
