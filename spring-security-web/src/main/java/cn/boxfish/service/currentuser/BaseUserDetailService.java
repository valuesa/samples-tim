package cn.boxfish.service.currentuser;

import cn.boxfish.entity.CurrentUser;
import cn.boxfish.entity.User;
import cn.boxfish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by LuoLiBing on 15/8/31.
 */
@Service
public class BaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("用户名为%s没有找到", username));
        }
        user.initAuthority();
        return new CurrentUser(user);
    }
}
