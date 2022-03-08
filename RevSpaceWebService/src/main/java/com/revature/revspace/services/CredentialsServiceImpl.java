package com.revature.revspace.services;

import com.revature.revspace.models.Credentials;
import com.revature.revspace.models.User;
import com.revature.revspace.repositories.CredentialsRepo;
import com.revature.revspace.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService{

    @Autowired
    CredentialsRepo credentialsRepo;
    
    @Autowired
    UserRepo ur;

    @Override
    public CredentialsRepo getRepo() {
        return credentialsRepo;
    }

    @Override
    public Integer getIDFor(Credentials value) {
        return value.getCredentialsId();
    }

    @Override
    public Credentials getByEmail(String email) {
        return credentialsRepo.findByUserEmail(email);
    }

    @Override
    public Integer getIdByUserId(int id)
    {
        Credentials credResult = credentialsRepo.findByUserUserId(id);
        return (credResult != null)? credResult.getCredentialsId() : 0;
    }

	@Override
	public User changePassword(int id, String password) {
		User user = ur.getById(id);
		System.out.println(user);
		System.out.println("incoming password = "+ password);
		Credentials credResult = credentialsRepo.findByUserUserId(id);
		System.out.println(credResult);
//		String answer = "Password Changed.";
		credResult.setPassword(password);
		System.out.println("after change"+credResult);
		credentialsRepo.save(credResult);
		return user;
	}
}
