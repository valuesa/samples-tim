package cn.boxfish.entity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


/**
 * Created by LuoLiBing on 15/8/29.
 */
public class BaseUser extends User {

    private cn.boxfish.entity.User user;

    public BaseUser(cn.boxfish.entity.User user) {
        super(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public cn.boxfish.entity.User getUser() {
        return user;
    }

    public void setUser(cn.boxfish.entity.User user) {
        this.user = user;
    }

    public Role getRole() {
        return user.getRole();
    }
}
