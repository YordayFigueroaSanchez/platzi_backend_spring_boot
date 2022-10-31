package com.yfsanchez.fundamentos.service;

import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOGGER = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<User> userList){
        userList.stream()
                .peek(user -> LOGGER.info("Usuario agregado : " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }
}
