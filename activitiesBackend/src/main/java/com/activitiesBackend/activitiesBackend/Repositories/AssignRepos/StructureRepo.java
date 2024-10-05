package com.activitiesBackend.activitiesBackend.Repositories.AssignRepos;

import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructureRepo extends JpaRepository<Structure,String> {

    @Query("SELECT s FROM Structure s WHERE s.coo = :coo")
    List<Structure> findByCoordinator(@Param("coo") String coo);

}
