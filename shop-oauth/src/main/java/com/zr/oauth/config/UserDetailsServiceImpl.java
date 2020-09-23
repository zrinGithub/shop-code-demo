package com.zr.oauth.config;

import com.zr.oauth.util.UserJwt;
import com.zr.user.client.ShopUserClient;
import com.zr.user.model.QueryUserRequest;
import com.zr.user.model.ShopUserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 11:18
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    ClientDetailsService clientDetailsService;

    @Resource
    ShopUserClient userClient;

    //自定义的授权认证
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //取出身份，如果为空表示没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {

        }

        if (StringUtils.isBlank(userName)) return null;

        //通过用户中心渠道 根据用户名取到用户信息
        ShopUserVo userVo = userClient.queryUserInfo(new QueryUserRequest() {{
            setUserName(userName);
        }}).getContent();

        //创建User对象
        String permissions = "salesman,accountant,user";//权限数据
        return new UserJwt(userName, userVo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
    }
}
