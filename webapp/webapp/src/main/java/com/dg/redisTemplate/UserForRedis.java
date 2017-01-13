package com.dg.redisTemplate;

import java.io.Serializable;

/**
 * Created by zy on 2017/1/12.
 * 创建User类，必须实现或者间接实现Serializable接口:
 * Redis存储对象是使用序列化，spring-data-redis已经将序列化的功能内置，不需要我们去管，
 * 我们只需要调用api就可以使用。SerialVersionUID字段对序列化扩展有用，为了以后扩展或者缩减字段时不会造成反序列化出错
 */
public class UserForRedis implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;

    public static final String OBJECT_KEY = "USER";

    public UserForRedis() {
    }

    public UserForRedis(String id) {
    }

    public UserForRedis(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    public String getKey() {
        return getId();
    }

    public String getObjectKey() {
        return OBJECT_KEY;
    }
}
