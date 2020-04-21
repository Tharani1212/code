package com.mindtree.SearchService;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.mindtree.SearchEntity.ResDetails;
import com.data.bind.SearchEntity;

public interface SearchService {

	ResDetails createResDetails(ResDetails data);

	List<ResDetails> searchFor();

	List<String> searchForDetails(SearchEntity data);

}
