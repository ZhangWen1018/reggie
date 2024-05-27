package com.zhang.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.reggie.dto.DishDto;
import com.zhang.reggie.entity.DishFlavor;
import com.zhang.reggie.mapper.DishFlavorMapper;
import com.zhang.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author ZhangLi
 * @version 1.0
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
