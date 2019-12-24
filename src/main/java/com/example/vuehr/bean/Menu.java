package com.example.vuehr.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@ApiModel(value = "menu表",description = "菜单表")
public class Menu implements Serializable {
    @ApiModelProperty(value = "自增主键")
    private Long id;
    @ApiModelProperty(value = "请求路径规则")
    private String url;
    @ApiModelProperty(value = "路由path")
    private String path;
    @ApiModelProperty(value = "组件名称")
    private Object component;
    @ApiModelProperty(value = "组件名")
    private String name;
    @ApiModelProperty(value = "菜单图标")
    private String iconCls;
    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;
    @ApiModelProperty(value = "角色")
    private List<Role> roles;
    @ApiModelProperty(value = "子菜单")
    private List<Menu> children;
    private MenuMeta meta;

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public Object getComponent() {
        return component;
    }

    public void setComponent(Object component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @JsonIgnore
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @JsonIgnore
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
