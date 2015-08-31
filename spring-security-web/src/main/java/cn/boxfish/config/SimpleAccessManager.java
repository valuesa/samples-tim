package cn.boxfish.config;

import cn.boxfish.entity.CurrentUser;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * Created by LuoLiBing on 15/8/31.
 * 自定义的访问权限控制manager
 */
public class SimpleAccessManager implements AccessDecisionManager {

    /**
     * authentication包含了当前用户信息
     * 当前正在请求的受保护对象
     * 当前正在访问的受保护对象的配置信息
     *
     * @param authentication
     * @param object
     * @param configAttributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println(authentication);
        System.out.println(configAttributes);

        if(!(authentication.getPrincipal() instanceof CurrentUser)) {
            throw new AccessDeniedException(" 没有权限访问！ ");
        }

        System.out.println(" ---------------  MyAccessDecisionManager --------------- ");
        if(configAttributes == null) {
            return;
        }
        // 权限判断

        // 没有权限
        throw new AccessDeniedException(" 没有权限访问！ ");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
