package fit.se.user.service;

import java.util.List;
import org.springframework.stereotype.Service;

import fit.se.user.entity.User;

@Service
public interface UserService {
	List<User> getAll();

	User getDetail(Long id);

	User create(User user);

	void update(Long id, User user);

	void delete(Long id);
}