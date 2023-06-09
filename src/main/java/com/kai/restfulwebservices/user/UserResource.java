package com.kai.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/user")
    public List<User> retrieveALlUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("Id-" + id);
        }
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userDaoService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id){
        boolean isDeleteSuccess = userDaoService.deleteById(id);
        if(!isDeleteSuccess){
            throw new UserNotFoundException("Id-" + id);
        }
        return true;
    }
}
