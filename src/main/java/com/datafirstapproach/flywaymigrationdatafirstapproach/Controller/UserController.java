package com.datafirstapproach.flywaymigrationdatafirstapproach.Controller;

import com.datafirstapproach.flywaymigrationdatafirstapproach.Entity.Users;
import com.datafirstapproach.flywaymigrationdatafirstapproach.Service.UserService;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long userId) {
        Users user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    create user api
//    @PostMapping
//    public ResponseEntity<Users> createUser(@RequestBody Users user) {
//        Users savedUser = userService.createUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }

    @PutMapping("{id}")
     public ResponseEntity<Users> updateUser(@PathVariable("id") Long userId, @RequestBody Users user) {
        user.setId(userId);
        Users updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        Users newUser = userService.createUser(user);
        flywayMigration();

        return newUser;
    }
    private void flywayMigration() {
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
