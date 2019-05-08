package com.stackroute.projectownerprofile.service;

import com.stackroute.projectownerprofile.domain.ProjectOwner;

public interface ProjectOwnerInterface {
    public ProjectOwner post(ProjectOwner projectOwner);
    public ProjectOwner getProjectOwner(String id);
}
