package leite.aquilla.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import leite.aquilla.hroauth.entity.User;
import leite.aquilla.hroauth.feignclients.UserFeignClient;

@Service
public class OauthService implements UserDetailsService {

	UserFeignClient userFeignClient;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public OauthService(UserFeignClient userFeignClient, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userFeignClient = userFeignClient;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(email).getBody();
		System.out.println(bCryptPasswordEncoder.encode("123456"));
		if (null == user) {
			throw new UsernameNotFoundException("Email not foud");
		}
		return user;
	}
}
