package leite.aquilla.hruser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leite.aquilla.hruser.entity.User;
import leite.aquilla.hruser.repository.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
}
