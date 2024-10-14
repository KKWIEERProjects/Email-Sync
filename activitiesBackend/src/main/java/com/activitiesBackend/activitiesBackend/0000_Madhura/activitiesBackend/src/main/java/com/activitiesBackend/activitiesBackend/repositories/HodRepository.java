package com.activitiesBackend.activitiesBackend.repositories;
/*All methods here are used for CRUD operations , add delete , fill, findAll,getReferenceById ,etc*/

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.activitiesBackend.activitiesBackend.Entities.hod_ntt;

@Repository
public interface HodRepository extends JpaRepository<hod_ntt ,String> 
{

	//public hod_ntt fetchHod_name(String hod_name);

	public static Optional<hod_ntt> findById(hod_ntt hod_id) {
		
		return null;
	}

	public void deleteById(String hod_id);
}
 