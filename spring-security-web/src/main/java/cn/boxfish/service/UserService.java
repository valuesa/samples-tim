package cn.boxfish.service;

import cn.boxfish.entity.User;
import cn.boxfish.entity.UserCreateForm;

import java.util.Optional;

/**
 * Created by LuoLiBing on 15/8/29.
 */
public interface UserService {

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserById(Long id);

    User save(UserCreateForm form);
}
