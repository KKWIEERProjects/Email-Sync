package com.activitiesBackend.activitiesBackend.Repositories;

import com.activitiesBackend.activitiesBackend.dto.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepo extends JpaRepository<Template,String> {
}
