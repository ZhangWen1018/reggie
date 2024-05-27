package com.zhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.reggie.entity.Category;

/**
 * @author ZhangLi
 * @version 1.0
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
