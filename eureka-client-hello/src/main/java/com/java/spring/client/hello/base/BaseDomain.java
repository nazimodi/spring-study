package com.java.spring.client.hello.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author renqingwang on 2017/8/26.
 * @version 1.0
 */
public abstract class BaseDomain implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
