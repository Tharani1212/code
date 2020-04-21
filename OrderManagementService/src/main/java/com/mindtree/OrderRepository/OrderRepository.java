package com.mindtree.OrderRepository;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.OrderEntity.Cart;



@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Cart, Integer> {

	default Cart orderit(Cart data) {
		
		return this.save(data);
		
	}

	@Query(value = "select sum(c.cost),d.res_dis,e.location,e.phone_no,e.res_name,u.User_name,u.Phone_number from Cart c join res_distance d join res_details e join user u where u.user_id=?1 and status='order' and d.res_id=c.res_id",nativeQuery=true)
	ArrayList<String> order(Integer uId);

	
	

	
	

	

}
