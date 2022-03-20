package com.sda.travelAgency.security;

import com.sda.travelAgency.model.User;
import com.sda.travelAgency.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EvmUserDetailService implements UserDetailsService {

    private UserRepo userRepo;

    public EvmUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User repoUser = userRepo.findByEmail(email);
        EvmUserDetails securityUserDetails = new EvmUserDetails(repoUser);
        return securityUserDetails;
    }
}
