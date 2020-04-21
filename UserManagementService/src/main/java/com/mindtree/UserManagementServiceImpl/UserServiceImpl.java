package com.mindtree.UserManagementServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.UserEntity.Users;
import com.mindtree.UserManagementRepository.UserRepository;
import com.mindtree.UserManagementService.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Users createUsers(Users data) {
		// TODO Auto-generated method stub
		return userRepository.saveUsers(data);
	}

	@Override
	public Optional<Users> RetrieveUsers(Integer uId) {
		// TODO Auto-generated method stub
		return userRepository.RetrieveUsers(uId);
	}

	@Override
	public Integer upadatePassword(Integer uId, String password, String opass) {
		// TODO Auto-generated method stub
		
		String oldpass=userRepository.getOldPassword(uId);
		if(password.equals(opass))
			throw new RuntimeException("Password cannot be Same as oldpassword");
		else if(oldpass.equals(opass))
		{
		return userRepository.upadatePassword(uId, password);
		}
		else
			throw new RuntimeException("Incorrect old Password");
	}

}
