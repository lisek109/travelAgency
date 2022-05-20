package com.project.travelAgency.service;

import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService {

  //  private final UserRepo userRepo;
//
  //  @Override
  //  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //      return userRepo.findByUserName(username)
  //              .orElseThrow(() -> new NoIdException("User not found"));
  //  }

    //  @Override
    //  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     User user = userRepo.findByUserName(username);
    //      return new org.springframework.security.core.userdetails
    //              .User(user.getUsername(), user.getPassword(), user.getAuthorities());
    //  }
}
