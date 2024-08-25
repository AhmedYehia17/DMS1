package com.example.DMS.Service;

import com.example.DMS.Dto.UserLoginDto;
import com.example.DMS.Model.User;
import com.example.DMS.Model.UserPrincipal;
import com.example.DMS.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findByUsername(username);
//        if (user == null) {
//            System.out.println("User Not Found");
//            throw new UsernameNotFoundException("user not found");
//        }
//
//        return new UserPrincipal(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the repository
        User user = userRepo.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Wrap the user entity in a UserPrincipal (your implementation of UserDetails)
        return new UserPrincipal(user);
    }

}