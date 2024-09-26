package com.activitiesBackend.activitiesBackend.Repositories.AssignRepos;

import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssignRepo extends JpaRepository<Assign,String> {

    @Query("SELECT a FROM Assign a WHERE a.coordinator = :coo")
    List<Assign> findByCoordinator(@Param("coo") String coo);

}
