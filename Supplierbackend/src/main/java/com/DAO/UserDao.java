package com.DAO;

import com.Model.User;

public interface UserDao {

	boolean insertUser(User user);
	boolean deleteUser(User user);
	boolean updateUser(User user);
}
