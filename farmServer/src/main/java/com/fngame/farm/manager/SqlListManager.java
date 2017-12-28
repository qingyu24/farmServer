package com.fngame.farm.manager;

import com.fngame.farm.util.SqlList;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingyu on 2017/12/22 /20:38
 */
@Component
public class SqlListManager {
    @Autowired
    BeanFactory beanFactory;

    public SqlList getNewlist() {
        return new SqlList(beanFactory);
    }
}
