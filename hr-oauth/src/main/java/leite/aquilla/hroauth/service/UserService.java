package leite.aquilla.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leite.aquilla.hroauth.entity.User;
import leite.aquilla.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	UserFeignClient userFeignClient;

	@Autowired
	public UserService(UserFeignClient userFeignClient) {
		super();
		this.userFeignClient = userFeignClient;
	}

	public User findByEmail(String email) {
		return userFeignClient.findByEmail(email).getBody();
	}
}
