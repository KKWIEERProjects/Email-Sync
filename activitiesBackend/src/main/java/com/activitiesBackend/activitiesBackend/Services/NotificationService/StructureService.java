package com.activitiesBackend.activitiesBackend.Services.NotificationService;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.AssignRepo;
import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.StructureRepo;
import com.activitiesBackend.activitiesBackend.exceptions.StructureRecordNotFound;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StructureService {

    @Autowired
    private StructureRepo structureRepo;

    public String save(Assign assign, String name,
                     //Date startDate,Date endDate,
                     String venue,String coo,String mail){

        //String date=startDate.toString() + endDate.toString();
        LocalDate minDate = LocalDate.now();
        LocalDate maxDate = LocalDate.now().plusDays(10);

        // Format the dates in `yyyy-MM-dd` format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Structure structure=Structure.builder()
                .id(assign.getId())
                .name(name)
                .estimateStart(minDate.format(formatter))
                .estimateEnd(maxDate.format(formatter))
                .info(assign.getInfo())
                .event(assign.getEvent())
                .venue(venue)
                .coo(coo)
                .mail(mail)
                .build();
        structureRepo.save(structure);
        System.out.println("structure");
        return structure.getId();

    }

    public Structure getStructure(String id){
        System.out.println("last stage");
        Structure structure=structureRepo.findById(id).orElseThrow(()->new StructureRecordNotFound("Record not found"));

        return structure;
    }

    public void remove(Structure structure){
        structureRepo.delete(structure);
    }

    public List<Structure> getAllStructure(String coo){
        return structureRepo.findByCoordinator(coo);
    }



}
