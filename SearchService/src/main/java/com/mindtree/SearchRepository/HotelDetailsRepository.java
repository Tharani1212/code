package com.mindtree.SearchRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.SearchEntity.ResTypeDetails;

@Repository
@Transactional
public interface HotelDetailsRepository extends JpaRepository<ResTypeDetails, Integer> {

	@Query(value="Select d.res_name,r.* from res_type r join res_details d on r.res_id=d.res_id where r.res_type=?1",nativeQuery=true)
	public List<String> searchBytype(String string);
	
	
	@Query(value="Select d.res_name,r.* from res_type r join res_details d on r.res_id=d.res_id where r.res_cost=?1",nativeQuery=true)
	public List<String> searchBybudget(float string);

	@Query(value="Select d.res_name,r.* from res_type r join res_details d on r.res_id=d.res_id where r.delivery_ratings=?1",nativeQuery=true)
	public List<String> searchByratings(Integer ratings);

	@Query(value="Select d.res_name,r.* from res_type r join res_details d on r.res_id=d.res_id where r.delivery_ratings=?3 and r.res_cost=?2 and r.res_type=?1",nativeQuery=true)
	public List<String> allfilters(String types, float budgets, Integer ratings);
	
}
