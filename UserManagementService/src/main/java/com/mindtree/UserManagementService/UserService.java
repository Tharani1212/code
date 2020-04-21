package com.mindtree.UserManagementService;

import java.util.Optional;

import com.mindtree.UserEntity.Users;

public interface UserService {

	public Users createUsers(Users data);

	public Optional<Users> RetrieveUsers(Integer uId);

	public Integer upadatePassword(Integer uId, String password, String oldpassword);

}
