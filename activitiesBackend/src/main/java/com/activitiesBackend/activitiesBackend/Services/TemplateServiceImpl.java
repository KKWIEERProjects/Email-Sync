package com.activitiesBackend.activitiesBackend.Services;

import com.activitiesBackend.activitiesBackend.Repositories.TemplateRepo;
import com.activitiesBackend.activitiesBackend.dto.Template;
import com.activitiesBackend.activitiesBackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl {

    @Autowired
    private TemplateRepo templateRepo;

    public void addTemplate(User user, String name, String data){
        Template template=Template.builder()
                .user(user)
                .name(name)
                .data(data)
                .build();

        templateRepo.save(template);
        template=null;
    }
}
