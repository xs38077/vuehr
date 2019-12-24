package com.example.vuehr.config;

import com.example.vuehr.bean.Menu;
import com.example.vuehr.bean.Role;
import com.example.vuehr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 要实现动态配置权限，首先要自定义FilterInvocationSecurityMetadataSource，
 * spring security通过FilterInvocationSecurityMetadataSource接口中的getAttributes方法来确定一个请求需要哪些角色
 *
 * @author Xu    xs分支
 * @Date 2019/12
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     *
     * @param o
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
        //首先获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //从数据库中获取所有资源信息
        List<Menu> allMenu = menuService.getAllMenu();
        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    &&menu.getRoles().size()>0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
