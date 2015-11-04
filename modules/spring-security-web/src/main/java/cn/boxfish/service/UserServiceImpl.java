package cn.boxfish.service;

import cn.boxfish.entity.User;
import cn.boxfish.entity.UserCreateForm;
import cn.boxfish.entity.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuoLiBing on 15/8/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return userJpaRepository.findOne(id);
    }

    @Override
    public User save(UserCreateForm form) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return userJpaRepository.findAll();
    }
}
