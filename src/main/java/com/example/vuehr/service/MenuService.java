package com.example.vuehr.service;

import com.example.vuehr.bean.Menu;
import com.example.vuehr.common.HrUtils;
import com.example.vuehr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {

    @Autowired(required = true)
    MenuMapper menuMapper;

    /**
     * 这里使用当前方法名作为缓存的key，另外要从启动类上加上@EnableCaching
     * @return
     */
    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
