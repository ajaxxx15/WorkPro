package com.stackroute.projectownerprofile.service;
import com.stackroute.projectownerprofile.domain.ProjectOwner;
import com.stackroute.projectownerprofile.repository.ProjectOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectOwnerServices implements ProjectOwnerInterface{
    private ProjectOwnerRepository repository;

    @Autowired
    public ProjectOwnerServices(ProjectOwnerRepository repository) {

        this.repository = repository;
    }


    public ProjectOwner post(ProjectOwner projectOwner){
        System.out.println(projectOwner);
        ProjectOwner po=repository.save(projectOwner);
     //   System.out.println(po+"Im in service...............................");
        return po;
    }

    public ProjectOwner getProjectOwner(String id){
        List<ProjectOwner> list=repository.findAll();
        System.out.println(list);
        ProjectOwner result=new ProjectOwner();
        for (ProjectOwner po:list){
            System.out.println(id);
            System.out.println(po.getEmail());

            if(po.getEmail().equals(id)){

              result.setAddress(po.getAddress());
              result.setEmail(po.getEmail());
              result.setId(po.getId());
              result.setLocation(po.getLocation());
              result.setName(po.getName());
              result.setNumber(po.getNumber());
            }
        }
        return result;
    }
}
