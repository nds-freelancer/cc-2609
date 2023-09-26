package net.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.user.entity.User;
import net.user.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @RequestMapping("/token")
    public User getToken(){
        return userService.getUserById(1L);
    }
    
    @GetMapping("/swap")
    public String swapIdUsingQueryParam(@RequestParam String token) {
    
    	 User user = userService.getUserById(1L);
    	 user.setUsername(token);
         User updatedUser = userService.updateUser(user);
    	
        return "token: " + token;
    }
}
