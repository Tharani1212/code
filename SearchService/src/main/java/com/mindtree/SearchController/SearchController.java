package com.mindtree.SearchController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.SearchEntity.ResDetails;
import com.data.bind.SearchEntity;
import com.mindtree.SearchService.SearchService;



@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	SearchService searchService;
	
	
	
	  @PostMapping(value = "/SearchDetails") 
	  public ResponseEntity<ResDetails> insert(@RequestBody ResDetails data) {
	  
		  ResDetails res = searchService.createResDetails(data);
	  
	  return new ResponseEntity<ResDetails>(res, HttpStatus.ACCEPTED);
	  
	  }
	 
	  @GetMapping("/SearchFor")
	    public ResponseEntity<List<ResDetails>> searchFor() {
		  List<ResDetails> res = searchService.searchFor();
	        return new ResponseEntity<List<ResDetails>>(res, HttpStatus.OK);
	    }
	
	  @GetMapping("/Search")
	    public ResponseEntity<List<String>> searchBased(@RequestBody SearchEntity data) {
		  List<String> res = searchService.searchForDetails(data);
	        return new ResponseEntity<List<String>>(res, HttpStatus.OK);
	    }
}
