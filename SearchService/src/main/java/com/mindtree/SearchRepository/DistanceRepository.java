package com.mindtree.SearchRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.SearchEntity.ResDistanceDetails;


@Repository
@Transactional
public interface DistanceRepository extends JpaRepository<ResDistanceDetails, Integer> {

	@Query(value="Select d.res_name,r.* from res_distance r join res_details d on r.res_id=d.res_id where r.res_dis=?1",nativeQuery=true)
	public List<String> searchByditance(Integer dis);
	
}
