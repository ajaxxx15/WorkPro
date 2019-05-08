package com.stackroute.freelancerprofile.repository;

import com.stackroute.freelancerprofile.domain.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends MongoRepository<Bid,Integer> {
}
