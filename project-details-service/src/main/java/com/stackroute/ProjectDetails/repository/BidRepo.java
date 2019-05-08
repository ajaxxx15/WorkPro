package com.stackroute.ProjectDetails.repository;

import com.stackroute.ProjectDetails.domain.BidKafka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepo extends MongoRepository<BidKafka,Integer> {
}
