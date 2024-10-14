package com.activitiesBackend.activitiesBackend.services.Implementation;

import java.util.List;

//import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.activitiesBackend.activitiesBackend.Entities.hod_ntt;
import com.activitiesBackend.activitiesBackend.repositories.HodRepository;
import com.activitiesBackend.activitiesBackend.services.HodService;

@Service
public class HodServiceImpl implements HodService{

	@Autowired
	private HodRepository hodRepo;
	
	@Override
	public hod_ntt saveHod(hod_ntt hod_name) {
		
		return hodRepo.save(hod_name);
	}

	@Override
	public List<hod_ntt> fetchHodList() {
		
		return hodRepo.findAll() ;
	}

	@Override 
	public hod_ntt fetchHodById(hod_ntt hod_id) {
		
		return hod_id;
	}

	@Override
	public void deleteById(String hod_id) {
	    hodRepo.deleteById(hod_id);
	}

	@Override
	public void deleteHodById(Long hod_id) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public  hod_ntt updateHodById(hod_ntt hod_id, hod_ntt hod) {
		 hod_ntt hod1  = HodRepository.findById(hod_id).get();
		//if HodName not null and not "" 
		if(Objects.nonNull(hod1.getHod_name()) && !"".equalsIgnoreCase(hod1.getHod_name()))
		{
			hod1.setHod_name(hod1.getHod_name());
		}
		//if Email id not null and not ""
		if(Objects.nonNull(hod1.getEmailid()) && !"".equalsIgnoreCase(hod1.getEmailid()))
		{
			hod1.setEmailid(hod1.getEmailid());
		}
		//if phone not null and not ""
		if(Objects.nonNull(hod1.getPhone()) && !"".equalsIgnoreCase(hod1.getPhone()))
		{				
			hod1.setPhone(hod1.getPhone());
		}
		//if Department not null and not ""
		if(Objects.nonNull(hod1.getDepartment()) && !"".equalsIgnoreCase(hod1.getDepartment()))
		{
			hod1.setDepartment(hod1.getDepartment());
		}
		//if Address not null and not ""
		if(Objects.nonNull(hod1.getAddress()) && !"".equalsIgnoreCase(hod1.getAddress()))
		{
			hod1.setAddress(hod1.getAddress());
		}
		//if bdate not null and not ""
		if(Objects.nonNull(hod1.getBdate()) && !"".equalsIgnoreCase(hod1.getBdate()))
		{
			hod1.setBdate(hod1.getBdate());
		}
		
		return hodRepo.save(hod1);
	}
	*/
	
	/*
	@Override
	public hod_ntt fetchHod_name(String hod_name) {
		
		return hodRepo.fetchHod_name(hod_name);
	}
	*/
	
}
