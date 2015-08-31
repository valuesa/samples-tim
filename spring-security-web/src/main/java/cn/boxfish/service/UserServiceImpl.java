package cn.boxfish.service;

import cn.boxfish.entity.User;
import cn.boxfish.entity.UserCreateForm;
import cn.boxfish.entity.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by LuoLiBing on 15/8/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User save(UserCreateForm form) {
        return null;
    }
}
