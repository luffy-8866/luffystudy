package com.luffy.mvcdiy.service.impl;

import com.luffy.mvcdiy.annotation.LuffyService;
import com.luffy.mvcdiy.service.IDemoService;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/10 14:41
 */
@LuffyService
public class demoService implements IDemoService {
    @Override
    public String getName(String name) {
        System.out.println(name);
        return name;
    }
}
