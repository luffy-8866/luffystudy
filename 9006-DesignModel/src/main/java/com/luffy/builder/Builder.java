package com.luffy.builder;

import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 14:18
 */
public abstract class Builder {

    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();

    abstract House getHouse();
}
