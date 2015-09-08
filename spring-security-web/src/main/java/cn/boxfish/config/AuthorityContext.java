package cn.boxfish.config;

import cn.boxfish.entity.Authority;
import cn.boxfish.entity.jpa.AuthorityJpaRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuoLiBing on 15/9/1.
 */
/*@Component
public class AuthorityContext implements InitializingBean {

    @Autowired
    private AuthorityJpaRepository authorityJpaRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Authority> authorities = authorityJpaRepository.findAll();
        initContext(authorities);
    }

    private final static Map<String, Authority> context = new HashMap<>();

    public static void initContext(List<Authority> authorities) {
        if(authorities != null) {
            for(Authority authority: authorities) {
                context.put(authority.getUrl(), authority);
            }
        }
    }

    public static Authority getAuthority(String uri) {
        return context.get(uri);
    }

}*/
