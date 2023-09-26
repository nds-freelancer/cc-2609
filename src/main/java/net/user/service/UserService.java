package net.user.service;

import java.util.List;
import net.user.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();
    
    User updateUser(User user);
}
