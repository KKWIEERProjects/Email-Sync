package com.activitiesBackend.activitiesBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.activitiesBackend.activitiesBackend.Entities.hod_ntt;
import com.activitiesBackend.activitiesBackend.services.CoordinatorService;


@Controller
class CoordinatorCtrl
{
	@Autowired
	private CoordinatorService CoorS;
	
	@GetMapping("/coordinatorDashboard")
	public String fetchCoordinatorDashboard()
	{
		return "Prof.Poonam Patil, Prof. Poonam Fegade, Prof.Vijay Dhawale";
	}
	@GetMapping("/coordinatorDashboard/List")
	public List<hod_ntt> fetchHodList()
	{
		return CoorS.fetchHodList();
	}
}