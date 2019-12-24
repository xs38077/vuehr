package com.example.vuehr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户认证使用Spring Security实现，因此需要首先提供一个UserDetail的实例
 * 前端用户在登录成功之后，需要获取当前登录用户的信息，对于一些敏感的信息不必返回，使用@JsonIgnore注解即可
 *
 * @author xushuo
 */
@ApiModel(value = "hr表",description = "hr表属于系统管理员")
public class Hr implements UserDetails {
    @ApiModelProperty(value = "hrID")
    private Long id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "住宅电话")
    private String telephone;
    @ApiModelProperty(value = "联系地址")
    private String address;
    @ApiModelProperty(value = "账户是否可用")
    private boolean enabled;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "角色")
    private List<Role> roles;
    @ApiModelProperty(value = "头像")
    private String userface;
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 当前用户是否未过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 当前用户是否未锁定
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 当前账户密码是否未过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 获取当前用户所具有的角色信息。
     * 用户所具有的角色存储在role属性中，因此直接遍历roles
     * 然后构造SimpleGrantedAuthority集合并返回
     * @return
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}