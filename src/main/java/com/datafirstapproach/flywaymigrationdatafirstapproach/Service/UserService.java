package com.datafirstapproach.flywaymigrationdatafirstapproach.Service;

import com.datafirstapproach.flywaymigrationdatafirstapproach.Entity.Users;

import java.util.List;

public interface UserService {
    Users createUser(Users user);

    Users getUserById(Long userId);

    Users updateUser(Users user);
    List<Users> getAllUsers();
}
