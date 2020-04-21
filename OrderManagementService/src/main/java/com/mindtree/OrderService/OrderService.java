package com.mindtree.OrderService;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.OrderEntity.Cart;



public interface OrderService {

	


	

	Cart addTocart(Cart data);

	ArrayList<String> order(Integer uId);

	

}
