package com.zhang.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.reggie.entity.AddressBook;
import com.zhang.reggie.mapper.AddressBookMapper;
import com.zhang.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author ZhangLi
 * @version 1.0
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
