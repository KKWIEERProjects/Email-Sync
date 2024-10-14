package com.activitiesBackend.activitiesBackend.services;
import java.util.List;
import com.activitiesBackend.activitiesBackend.Entities.hod_ntt;

public interface HodService {

	public hod_ntt saveHod(hod_ntt hod_name);

	public List<hod_ntt> fetchHodList();

	public hod_ntt fetchHodById(hod_ntt id);

	public void deleteHodById(Long hod_id);

	void deleteById(String hod_id);

	//public hod_ntt updateHodById(hod_ntt hod_id, hod_ntt hod);

	//public hod_ntt fetchHod_name(String hod_name);
}
