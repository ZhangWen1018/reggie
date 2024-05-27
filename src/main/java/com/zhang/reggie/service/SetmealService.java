package com.zhang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.reggie.dto.SetmealDto;
import com.zhang.reggie.entity.Setmeal;

import java.util.List;


/**
 * @author ZhangLi
 * @version 1.0
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐关联的菜品数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
