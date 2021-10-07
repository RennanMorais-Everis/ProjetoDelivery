package com.everis.delivery.service.serviceImplements;

import com.everis.delivery.interfaces.InterfaceService;
import com.everis.delivery.model.User;
import com.everis.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserService implements InterfaceService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findNByname(name);

    }

    public void saveAll(List<User> user) {
        userRepository.saveAll(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
