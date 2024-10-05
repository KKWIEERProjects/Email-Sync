package com.activitiesBackend.activitiesBackend.Repositories.AssignRepos;

import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepo extends JpaRepository<History,String> {

    @Query("SELECT h FROM History h WHERE h.coo = :coo")
    List<History> findByCoordinator(@Param("coo") String coo);


}
