package com.stackroute.webtokens.service;

import com.stackroute.webtokens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean verifyUser(String userName) {

        boolean result = false;
        if(userRepository.existsById(userName)){
            result = true;
        }

        return result;
    }
}
