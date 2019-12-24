package com.example.vuehr.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by sang on 2017/12/30.
 */
public class MenuMeta implements Serializable {
    @ApiModelProperty(value = "菜单切换时是否保活")
    private boolean keepAlive;
    @ApiModelProperty(value = "是否登录后才能访问")
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
