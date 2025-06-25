package com.zawadig.myafwanii.Service;



import com.zawadig.myafwanii.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}

