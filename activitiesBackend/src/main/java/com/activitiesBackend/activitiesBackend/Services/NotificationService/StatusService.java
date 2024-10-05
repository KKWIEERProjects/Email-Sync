package com.activitiesBackend.activitiesBackend.Services.NotificationService;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.StatusRepo;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StatusService {

    @Autowired
    private StatusRepo statusRepo;

    public void setStatusTable(Structure structure){
        StatusIQ statusIQ=StatusIQ.builder()
                .id(structure.getId())
                .event(structure.getEvent())
                .name(structure.getName())
                .status("pending")
                .info(structure.getInfo())
                .coo(structure.getCoo())
                .build();

        statusRepo.save(statusIQ);
    }

    public List<StatusIQ> get(String name){
        return statusRepo.findByCoordinator(name);
    }


    public StatusIQ updateStatus(String id,String status){

        statusRepo.statusById(id,status);
        return statusRepo.findById(id).orElseThrow();
    }

    public void remove(String id){
        statusRepo.deleteById(id);
    }
}
