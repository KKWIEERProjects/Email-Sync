package com.activitiesBackend.activitiesBackend.Repositories.AssignRepos;

import com.activitiesBackend.activitiesBackend.model.Notifications.Assign;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepo extends JpaRepository<StatusIQ,String> {

    @Query("SELECT s FROM StatusIQ s WHERE s.coo = :coo")
    List<StatusIQ> findByCoordinator(@Param("coo") String coo);

    @Modifying
    @Query("UPDATE StatusIQ s SET s.status=:status WHERE s.id=:id")
    void statusById(@Param("id") String id,@Param("status") String status);
}
