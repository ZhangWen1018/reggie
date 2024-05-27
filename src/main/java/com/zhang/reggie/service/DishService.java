package com.zhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.reggie.dto.DishDto;
import com.zhang.reggie.entity.Dish;

/**
 * @author ZhangLi
 * @version 1.0
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表，dish, dish_flavor
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);
    //更新dish表基本信息
    public void updateWithFlavor(DishDto dishDto);
}
