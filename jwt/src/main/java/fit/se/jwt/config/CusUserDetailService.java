package fit.se.jwt.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fit.se.jwt.entity.Account;
import fit.se.jwt.repository.AccountRepository;

@Component
public class CusUserDetailService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountRepository.finfByUsername(username);
		return account.map(CusUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Not found username: " + username));
	}

}
