package com.revature.revspace.services;

import java.util.List;

import com.revature.revspace.models.User;
import com.revature.revspace.repositories.UserRepo;

public interface UserService extends CrudService<User, Integer, UserRepo>
{
	public User getUserByEmail(String email);

	/**
	 * @return Currently logged-in user. Returns null if used outside an HTTP request scope.
	 */
	public User getLoggedInUser();
	public List<User> getLoggedFollowers();
	public List<User> getFollowing();
	public List<User> getViewFollowers(User user);
}
