package com.activitiesBackend.activitiesBackend.Services.NotificationService;

import com.activitiesBackend.activitiesBackend.Repositories.AssignRepos.HistoryRepo;
import com.activitiesBackend.activitiesBackend.model.Notifications.History;
import com.activitiesBackend.activitiesBackend.model.Notifications.StatusIQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepo historyRepo;

    public void record(StatusIQ statusIQ){
        History history=History.builder()
                .event(statusIQ.getEvent())
                .name(statusIQ.getName())
                .status(statusIQ.getStatus())
                .coo(statusIQ.getCoo())
                .build();

        historyRepo.save(history);
    }

    public List<History> getHistory(String coo){
        return historyRepo.findByCoordinator(coo);
    }

}
