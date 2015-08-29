package cn.boxfish.service;

import cn.boxfish.entity.User;
import cn.boxfish.entity.UserCreateForm;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by LuoLiBing on 15/8/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> getUserByUsername(String username) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return null;
    }

    @Override
    public User save(UserCreateForm form) {
        return null;
    }
}
