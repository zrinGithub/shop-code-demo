package com.zr.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 14:44
 */
@Configuration
@EnableWebSecurity
@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //忽略安全拦截的URL
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/oauth/login", "/oauth/loginPage");
    }

    //创建授权管理认证对象
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //使用BCryptPasswordEncoder对密码进行编码
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()    //启用Http基本身份验证
                .and()
                .formLogin()    //启用表单身份认证
                .and()
                .authorizeRequests() //限制基于Request请求访问
                .anyRequest()
                .authenticated();   //其他请求都需要通过验证

        //开启表单登录
        http.formLogin().loginPage("/oauth/loginPage")//设置访问登录页面的路径
                .loginProcessingUrl("/oauth/login");//设置执行登录操作的请求路径
    }
}
