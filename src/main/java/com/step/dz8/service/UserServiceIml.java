package com.step.dz8.service;

import com.step.dz8.model.User;
import com.step.dz8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return (List<User>) repository.findAll();
    }

    public User updateUser(User user, Long Id) {
        User upUser = repository.findById(Id).get();
        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            upUser.setName(user.getName());
        }
        if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
            upUser.setAddress(user.getAddress());
        }
        if (Objects.nonNull(user.getPhoneNumber()) && "".equalsIgnoreCase(user.getPhoneNumber())) {
            upUser.setPhoneNumber(user.getPhoneNumber());
        }
        if (Objects.nonNull(user.getEmail()) && "".equalsIgnoreCase(user.getEmail())) {
            upUser.setEmail(user.getEmail());
        }

        return repository.save(upUser);
    }

    public void deleteUser(Long Id) {
        repository.deleteById(Id);
    }
}
