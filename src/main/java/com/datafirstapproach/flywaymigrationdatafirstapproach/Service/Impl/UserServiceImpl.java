package com.datafirstapproach.flywaymigrationdatafirstapproach.Service.Impl;

import com.datafirstapproach.flywaymigrationdatafirstapproach.Entity.Users;
import com.datafirstapproach.flywaymigrationdatafirstapproach.Repository.UserRepository;
import com.datafirstapproach.flywaymigrationdatafirstapproach.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users createUser(Users user) {

        return userRepository.save(user);
    }

    @Override
    public Users getUserById(Long userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public Users updateUser(Users user) {
        Users existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        Users updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public List<Users> getAllUsers() {

        return userRepository.findAll();
    }

}
