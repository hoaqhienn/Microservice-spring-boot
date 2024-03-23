package fit.se.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.se.user.entity.User;
import fit.se.user.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getDetail(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist!"));
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public void update(Long id, User userUpdate) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist!"));
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist!"));
		userRepository.deleteById(id);
	}
}
