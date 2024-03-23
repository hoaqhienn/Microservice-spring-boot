package fit.se.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fit.se.user.entity.User;
import fit.se.user.service.UserServiceImplement;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserServiceImplement userService;

	@GetMapping("")
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{userId}")
	public User getDetail(@PathVariable("userId") Long userId) {
		return userService.getDetail(userId);
	}

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		User newUser = userService.create(user);
		System.out.println("GET ID CREATE: " + newUser.getId());
		return newUser;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user) {
		userService.update(id, user);

		return ResponseEntity.ok("Update user is success");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		userService.delete(id);

		return ResponseEntity.ok("Delete user is success");
	}
}