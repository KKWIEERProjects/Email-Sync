package com.activitiesBackend.activitiesBackend;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.AssignRepo;
import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@PropertySource(
        ignoreResourceNotFound = false,
        value = "classpath:dbcofig.properties")
@Rollback
public class DatabaseTesting {


    @Autowired
    private AssignRepo assignRepo;

    @Test
    public void testShowListOfCoo(){

        Assign assign=Assign.builder()
                .info("name=sumedh ahire call him")
                .event("Expert talk")
                .coordinator("archana12")
                .build();

        assignRepo.save(assign);

        List<Assign> map=assignRepo.findByCoordinator("archana12");

        System.out.println(map);



    }

}
