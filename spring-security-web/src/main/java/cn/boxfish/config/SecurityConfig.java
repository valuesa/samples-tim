package cn.boxfish.config;

import cn.boxfish.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Created by LuoLiBing on 15/8/29.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 设置认证方式，所有用户都需要被认证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // basic方式
        /*http.authorizeRequests().anyRequest().fullyAuthenticated()
                .and().httpBasic();*/

        // form表单认证
        http.authorizeRequests()
                .antMatchers("/", "/static/**").permitAll() // 不拦截静态资源 /static
                .antMatchers("/manage/**").hasAuthority(Role.ADMIN.toString()) // 管理员请求需要管理员角色
                .anyRequest().fullyAuthenticated() // 拦截所有请求，都进行认证
                .and()
                .formLogin() // 表单登录，也可以指定为basic登录方式
                .loginPage("/login") // 指定登录请求
                .failureUrl("/login?error") // 指定失败请求
                .usernameParameter("username") // 指定用户名的param
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // 指定可以注销以及注销地址
                .deleteCookies("remember-me") // 删除记住我清楚cookie
                .logoutSuccessUrl("/") // 注销成功跳转的页面
                .permitAll()
                .and()
                .rememberMe(); // 记住我自动添加cookie
        //httpBasic() basic认证
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // inmemory
        /*auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("employee").and()
                .withUser("admin").password("admin123").roles("employee", "admin");*/

        // JDBC方式
        /*
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .usersByUsernameQuery("select username,password,enable from users where username=?");
                //.withUser("username").password("password").roles("USER");*/

        // 自行指定方式
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


}
