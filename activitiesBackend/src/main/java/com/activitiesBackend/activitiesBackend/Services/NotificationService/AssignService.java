package com.activitiesBackend.activitiesBackend.Services.NotificationService;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.AssignRepo;
import com.activitiesBackend.activitiesBackend.exceptions.PostNotFoundById;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignService {

    @Autowired
    private AssignRepo assignRepo;

    public void setPost(String event,String coo,String info){


        Assign assign=Assign.builder()
                .coordinator(coo)
                .event(event)
                .info(info)
                .build();

        System.out.println(assignRepo.save(assign));
        System.out.println(assign);
        assign=null;
        //return assign;

    }


    public List<Assign> getPost(String coo) {

        return assignRepo.findByCoordinator(coo);

    }

    public Assign getPostById(String id){

        return assignRepo.findById(id).orElseThrow(()->new PostNotFoundById("Post not found"));
    }

    public void remove(Assign assign){
        assignRepo.delete(assign);
    }

    public void removeById(String id){
        Assign assign=assignRepo.findById(id).orElseThrow(()->new PostNotFoundById("Post not found"));
        assignRepo.delete(assign);
    }














}
