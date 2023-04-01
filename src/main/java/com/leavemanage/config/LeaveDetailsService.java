package com.leavemanage.config;

import com.leavemanage.entity.Leaves;
import com.leavemanage.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LeaveDetailsService implements UserDetailsService {

    @Autowired
    private LeaveRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Leaves> user = repository.findById(email);
        try {
        	return user.map(LeaveDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
    }
}