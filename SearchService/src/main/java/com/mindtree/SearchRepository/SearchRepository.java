package com.mindtree.SearchRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.SearchEntity.ResDetails;

@Repository
@Transactional
public interface SearchRepository extends JpaRepository<ResDetails, Integer> {

	public default ResDetails createResDetails(ResDetails data)
	{
		return this.save(data);
	}

	public default List<ResDetails> find(){
		return this.findAll();
	}

	

	

	

}
