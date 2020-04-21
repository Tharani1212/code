package com.mindtree.SearchServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mindtree.SearchEntity.ResDetails;
import com.data.bind.SearchEntity;
import com.mindtree.SearchRepository.DistanceRepository;
import com.mindtree.SearchRepository.HotelDetailsRepository;
import com.mindtree.SearchRepository.SearchRepository;
import com.mindtree.SearchService.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
@Autowired
SearchRepository searchRepository;

@Autowired
HotelDetailsRepository hotelDetailsRepository;

@Autowired
DistanceRepository distanceRepository;

	@Override
	public ResDetails createResDetails(ResDetails data) {
		// TODO Auto-generated method stub
		return searchRepository.createResDetails(data);
	}

	@Override
	public List<ResDetails> searchFor() {
		// TODO Auto-generated method stub
		return searchRepository.find();
	}

	@Override
	public List<String> searchForDetails(SearchEntity data) {
		// TODO Auto-generated method stub
		if(data.isType())
			return hotelDetailsRepository.searchBytype(data.getTypes());
		else if(data.isBudget())
			return hotelDetailsRepository.searchBybudget(data.getBudgets());
		else if(data.isRating())
			return hotelDetailsRepository.searchByratings(data.getRatings());
		else if(data.isDistance())
			return distanceRepository.searchByditance(data.getDistances());
		else
			return hotelDetailsRepository.allfilters(data.getTypes(),data.getBudgets(),data.getRatings());
	}

}
