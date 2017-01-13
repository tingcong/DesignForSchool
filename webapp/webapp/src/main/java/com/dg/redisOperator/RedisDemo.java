package com.dg.redisOperator;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zy on 2017/1/13.
 */
public class RedisDemo {

    public void testString(Jedis jedis){
        //-------添加数据----------
        jedis.set("name","li jia");
        System.out.println(jedis.get("name"));

        //拼接
        jedis.append("name"," is mine");
        System.out.println(jedis.get("name"));

        //设置多个键值对
        jedis.mset("name","li jia","age","21","sex","female");
        //进行加1操作
        jedis.incr("age");
        System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("sex"));
    }


    /**\
     * redis操作map
     */
    public void testMap(Jedis jedis){
        //-------添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "li jia");
        map.put("age", "21");
        map.put("sex", "female");
        jedis.hmset("user", map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name","age", "sex");
        System.out.println(rsmap);

        //删除map中的某个键值
        jedis.hdel("user","age");
        System.out.println("age:"+jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println("key为user的键中存放的值的个数:"+jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println("是否存在key为user的记录:"+jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println("map对象中的所有key:"+jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println("map对象中的所有value:"+jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter=jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key=iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }
    }

    /**
     * jedis操作List
     */
    public void testList(Jedis jedis){
        //开始前。先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework",0,-1));
        jedis.del("java framework");
        jedis.rpush("java framework","spring");
        jedis.rpush("java framework","struts");
        jedis.rpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));
    }

    /**
     * jedis操作Set
     * 此功能还没完成
     */
    public void testSet(Jedis jedis){
        //添加
        jedis.sadd("user","li jia");
        jedis.sadd("user","guo xia qin");
        jedis.sadd("user","cheng yan");
        jedis.sadd("user","guo xia qin");
        jedis.sadd("user","li jia");

        //移除noname
        jedis.srem("user","who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }

    public static void main(String args[]){
        Jedis jedis=new Jedis("127.0.0.1");
        RedisDemo redisDemo=new RedisDemo();
        redisDemo.testString(jedis);
        System.out.println("############################");
        redisDemo.testMap(jedis);
        System.out.println("############################");
        redisDemo.testList(jedis);
        System.out.println("############################");
        redisDemo.testSet(jedis);
    }

}
