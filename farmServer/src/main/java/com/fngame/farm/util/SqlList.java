package com.fngame.farm.util;

import com.fngame.farm.mapper.UserMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by qingyu on 2017/12/22 /17:42
 */

public class SqlList<T> extends ArrayList<T> {

    private String sqlID = "select id from %smanagerExample order by id desc limit 0,1";
    BeanFactory beanFactory;
    private T t;

    public SqlList(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;

    }


    @Override
    public boolean add(T t) {
        Object mapper = this.getMapper(t);
        Class<?> aClass = mapper.getClass();
        try {
            Method insertSelective = aClass.getMethod("insertSelective", t.getClass());
            insertSelective.invoke(mapper, t);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return super.add(t);
    }


    private Object getExample(T t) {
        Object bean = null;
        try {
            Class<?> aClass = Class.forName("com.fngame.farm.model." + t.getClass().getSimpleName() + "Example");
            System.out.println(aClass);

            bean = beanFactory.getBean(aClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private Object getMapper(T t) {
        Object bean = null;
        try {
            Class<?> aClass = Class.forName("com.fngame.farm.mapper." + t.getClass().getSimpleName() + "Mapper");
            bean = beanFactory.getBean(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public void update(T t) {
        Object mapper = this.getMapper(t);
        Class<?> aClass = mapper.getClass();
        try {
            Method updateByPrimaryKeySelective = aClass.getMethod("updateByPrimaryKeySelective", t.getClass());
            updateByPrimaryKeySelective.invoke(mapper, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(int index, T element) {

        Object d = this.getMapper("d");


        super.add(index, element);
    }

    @Override
    public T remove(int index) {

        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        Object mapper = this.getMapper((T) t);
        Class<?> aClass = mapper.getClass();
        try {
            Method deleteByPrimaryKey = aClass.getMethod("deleteByPrimaryKey", t.getClass());
            deleteByPrimaryKey.invoke(mapper, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.remove(o);
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return super.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    public Object getExample() {
        return null;
    }

    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "mapper", key = "#obj")
    public Object getMapper(String obj) {


        return userMapper;
    }

}
