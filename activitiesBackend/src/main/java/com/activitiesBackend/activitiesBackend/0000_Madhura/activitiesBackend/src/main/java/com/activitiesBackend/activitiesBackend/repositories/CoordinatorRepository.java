package com.activitiesBackend.activitiesBackend.repositories;

import com.activitiesBackend.activitiesBackend.Entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, String> {
	

	
}
