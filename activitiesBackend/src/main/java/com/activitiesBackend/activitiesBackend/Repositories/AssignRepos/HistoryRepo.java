package com.activitiesBackend.activitiesBackend.Repositories.AssignRepos;

import com.activitiesBackend.activitiesBackend.model.Notifications.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends JpaRepository<History,String> {
}
