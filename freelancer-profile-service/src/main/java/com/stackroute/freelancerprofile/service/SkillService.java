package com.stackroute.freelancerprofile.service;

import com.stackroute.freelancerprofile.domain.Skill;

import java.util.List;

public interface SkillService {
    public Skill save(Skill skill);
    public List<Skill> getAll();
    public Skill search(String skill);
}
