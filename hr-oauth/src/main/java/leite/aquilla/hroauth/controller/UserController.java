package leite.aquilla.hroauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import leite.aquilla.hroauth.entity.User;
import leite.aquilla.hroauth.service.UserService;

@RefreshScope
@RestController
@RequestMapping("/users")
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}
}
