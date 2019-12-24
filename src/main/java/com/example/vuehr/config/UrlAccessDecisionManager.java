package com.example.vuehr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 当一个请求走完FilterInvocationSecurityMetadataSource中的getAttributes方法后，
 * 接下来就会来到AccessDecisionManager类中进行角色信息的比对
 *
 * @author Xu
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    /**
     * 在该方法中判断当前登录的用户是否具备当前请求URL所需要的角色信息，如果不具备，就抛出异常，说明请求权限不足，
     * 如果未抛出异常，说明请求可以通过，不做任何事
     *
     * @param auth 包含当前登录用户的信息
     * @param o 可以获取当前请求对象等
     * @param cas  getAttributes的返回值，当前请求URL所需要的角色
     */
    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> cas){
        Iterator<ConfigAttribute> iterator = cas.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();
            //如果所需要的角色是ROLE_LOGIN
            if ("ROLE_LOGIN".equals(needRole)) {
                //只需判断它不是匿名用户的实例，即表示当前用户已登录
                if (auth instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else {
                    return;
                }
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}