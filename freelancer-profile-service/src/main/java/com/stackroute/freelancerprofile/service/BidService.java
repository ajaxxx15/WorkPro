package com.stackroute.freelancerprofile.service;

import com.stackroute.freelancerprofile.domain.Bid;
import com.stackroute.freelancerprofile.domain.Skill;

import java.util.List;

public interface BidService {
    public Bid save(Bid bid);
    public List<Bid> allBids(String email);
}
