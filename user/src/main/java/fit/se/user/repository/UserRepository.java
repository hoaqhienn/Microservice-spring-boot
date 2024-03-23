package fit.se.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.se.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
