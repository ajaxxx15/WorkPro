package com.stackroute.freelancerprofile.repository;

import com.stackroute.freelancerprofile.domain.BidKafka;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidKafkaRepository extends MongoRepository<BidKafka, String> {
}
