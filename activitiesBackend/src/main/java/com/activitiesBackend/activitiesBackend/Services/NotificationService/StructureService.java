package com.activitiesBackend.activitiesBackend.Services.NotificationService;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.AssignRepo;
import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.StructureRepo;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StructureService {

    @Autowired
    private StructureRepo structureRepo;

    public String save(Assign assign, String name,
                     //Date startDate,Date endDate,
                     String venue,String coo){

        //String date=startDate.toString() + endDate.toString();
        String date="NaN";
        Structure structure=Structure.builder()
                .id(assign.getId())
                .name(name)
                .estimate(date)
                .info(assign.getInfo())
                .event(assign.getEvent())
                .venue(venue)
                .coo(coo)
                .build();
        structureRepo.save(structure);
        System.out.println("structure");
        return structure.getId();

    }

    public Structure getStructure(String id){
        System.out.println("last stage");
        Structure structure=structureRepo.findById(id).orElse(null);
        if(structure==null)
            System.out.println("null");
        return structure;
    }

    public void remove(Structure structure){
        structureRepo.delete(structure);
    }



}
