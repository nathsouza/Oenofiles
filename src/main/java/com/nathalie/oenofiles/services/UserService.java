package com.nathalie.oenofiles.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathalie.oenofiles.models.User;
import com.nathalie.oenofiles.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	//update account information
    public User updateUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
    	return userRepo.save(user);
    }
	
	//register
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	//find by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//find by id
	public User findById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null;
		}
	}
	
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
}