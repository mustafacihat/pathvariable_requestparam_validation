package com.cydeo.user_creation.service.implementation;


import com.cydeo.user_creation.bootstrap.DataGenerator;
import com.cydeo.user_creation.model.User;
import com.cydeo.user_creation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Override
    public List<User> getUsers() {
        return DataGenerator.USER_LIST;
    }

    @Override
    public void save(User user) {
        DataGenerator.USER_LIST.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow();
    }

    @Override
    public void update(User user) {
        User userInDB = findByEmail(user.getEmail());
        getUsers().remove(userInDB);
        save(user);
    }

    @Override
    public void deleteByEmail(String email) {
        getUsers().remove(findByEmail(email));
    }

}
