package com.dg.redisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zy on 2017/1/12.
 * 参考http://blog.csdn.net/aacm1992/article/details/21977237
 */
public class RunMain {

    public void run_a()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
        UserForRedisService userService =  (UserForRedisService) applicationContext.getBean("userService");


        UserForRedis user1 = new UserForRedis("user1ID", "User 1");
        UserForRedis user2 = new UserForRedis("user2ID", "User 2");

        System.out.println("==== getting objects from redis ====");
        System.out.println("User is not in redis yet: " + userService.get(user1));
        System.out.println("User is not in redis yet: " + userService.get(user2));

        System.out.println("==== putting objects into redis ====");
        userService.put(user1);
        userService.put(user2);

        System.out.println("==== getting objects from redis ====");
        System.out.println("User should be in redis yet: " + userService.get(user1));
        System.out.println("User should be in redis yet: " + userService.get(user2));

        System.out.println("==== deleting objects from redis ====");
        userService.delete(user1);
        userService.delete(user2);

        System.out.println("==== getting objects from redis ====");
        System.out.println("User is not in redis yet: " + userService.get(user1));
        System.out.println("User is not in redis yet: " + userService.get(user2));

    }

    public void run_b(){
    }
    public static void main( String[] args )
    {
        RunMain runMain=new RunMain();
        runMain.run_a();
    }
}
