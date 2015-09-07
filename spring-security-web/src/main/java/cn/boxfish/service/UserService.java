package cn.boxfish.service;

import cn.boxfish.entity.User;
import cn.boxfish.entity.UserCreateForm;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

/**
 * Created by LuoLiBing on 15/8/29.
 */
public interface UserService {

    User findByUsername(String username);

    /**
     * 只能返回认证人本身的bean
     * @param id
     * @return
     */
    @PostAuthorize("returnObject.owner == authentication.name")
    User getUserById(Long id);

    /**
     * 方法级  hasRole  hasAnyRole  principal  authentication  permitAll  denyAll  isAnonymous  isRememberMe  isAuthenticated  isFullyAuthenticated
     * @param form
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    User save(UserCreateForm form);
}
