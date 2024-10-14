package com.activitiesBackend.activitiesBackend.Controller;
/* Create methods here */

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.activitiesBackend.activitiesBackend.Entities.hod_ntt;
import com.activitiesBackend.activitiesBackend.services.HodService;


@Controller
public class HodCtrl {
	//@RequestMapping(value="/hods", method = RequestMethod.GET)
	//use get mapping interface
	
	
	
	@GetMapping("/hod")
	public String hodNames()
	{
		return "Mariyam Maniyar, Vandana Bagal, Rupali Patil, Archana Rane";
	}
	
	@Autowired
	private HodService hodS;
	
	/*********** GET MAPPING **********************/
	//http://localhost:7860/hod/list
	@GetMapping("/hod/list")
	public List<hod_ntt> fetchHodList()
	{
		return hodS.fetchHodList();
	}
	
	//http://localhost:7860/hods/1696
	@GetMapping("/hod/{id}")
	public hod_ntt fetchHodById(@PathVariable("id") hod_ntt hod_id)
	{
		return hodS.fetchHodById(hod_id);
	}
	/*
	//http://localhost:7860/hod/name/Madhura
	@GetMapping("/hod/name/{name}")
	public hod_ntt fetchHod_name(@PathVariable("name") String hod_name)
	{
		return hodS.fetchHod_name(hod_name);
	}
	*/
	
	/*********** PUT MAPPING **********************
	//http://localhost:7860/hod/update/1696
	@PutMapping("/hod/update/{id}")
	public hod_ntt  updateHodById(@PathVariable("id") hod_ntt hod_id, @RequestBody hod_ntt hod)
	{
		return (hod_ntt) hodS.updateHodById(hod_id,hod);	
	}
*/
	
	/*********** POST MAPPING **********************/
	//http://localhost:7860/hod/new
	@PostMapping("/hod/new")
	public  hod_ntt saveHodNtt(@RequestBody hod_ntt hod_name)
	{
		return hodS.saveHod(hod_name);
	}
	
	/*********** DELETE MAPPING **********************/
	//http://localhost:7860/hod/delete/1696
	@DeleteMapping("/hod/delete/{id}")
	public ResponseEntity<String>  deleteHodById(@PathVariable("id") Long hod_id )
	{
		hodS.deleteHodById(hod_id);
		return ResponseEntity.ok("Hod deleted successfully");
	}
}
