package my.lab.four.service.impl;

import my.lab.four.entity.User;
import my.lab.four.repository.PointRepository;
import my.lab.four.repository.UserRepository;
import my.lab.four.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(String string) {
        return userRepository.getOne(string);
    }
}
