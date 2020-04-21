package com.mindtree.UserManagementRepository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.UserEntity.Users;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Integer> {

	public default Users saveUsers(Users data) {
		// TODO Auto-generated method stub
		return this.save(data);
	}

	public default Optional<Users> RetrieveUsers(Integer uId) {
		return this.findById(uId);
	}

	@Modifying
	@Query(value = "Update Users set Password=?2 where User_id=?1")
	public Integer upadatePassword(Integer uId, String password);
	
	
	@Query(value = "Select password from Users where User_id=?1")
	public String getOldPassword(Integer uiD);

}
