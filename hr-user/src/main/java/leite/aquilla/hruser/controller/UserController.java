package leite.aquilla.hruser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import leite.aquilla.hruser.entity.User;
import leite.aquilla.hruser.service.UserService;

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

	@GetMapping
	public ResponseEntity<List<User>> index() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<User> show(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> show(@RequestParam String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}
}
