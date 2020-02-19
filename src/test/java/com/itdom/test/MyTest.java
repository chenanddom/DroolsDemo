package com.itdom.test;

import com.itdom.entity.Order;
import com.itdom.entity.User;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
    @Autowired
    KieSession kieSession;

    @Test
    public void test1(){
        kieSession.fireAllRules();

    }



    @Test
    public void test2(){
        User user = new User("zhangsan",20);
        //插入规则
        kieSession.insert(user);
        //指定执行那个规则
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("demo2"));
    }

    @Test
    public void test3(){
        String name="zhangsan";
        User user = new User("zhangsan",18);
        kieSession.insert(name);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("demo3"));
    }

    @Test
    public void test4(){
        User user = new User("zhangsan",18);
        kieSession.insert(new ArrayList<String>(){{
            add("zhangsan");
            add("lisi");
        }});
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("demo4"));
    }

    @Test
    public void test5(){
        User user = new User("zhangsan",18);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("demo5"));
    }

    @Test
    public void test6(){
        UUID uuid = UUID.randomUUID();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Order order = new Order(System.currentTimeMillis(),timestamp,uuid.toString().replace("-",""),timestamp,uuid.toString().replace("-",""),uuid.toString().replace("-",""),200.32);
        kieSession.insert(order);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("order"));
        logger.debug("order amount is:{}",order.getOrderAmount());
    }

}
