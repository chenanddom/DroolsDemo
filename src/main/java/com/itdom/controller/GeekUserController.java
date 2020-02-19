package com.itdom.controller;

import com.itdom.entity.GeekUser;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/geek_user")
public class GeekUserController {

@Resource
private MongoTemplate mongoTemplate;

@PostMapping("/add")
 public Boolean add(){
     GeekUser geekUser = new GeekUser("张三","100");
     GeekUser save = mongoTemplate.save(geekUser);
     return geekUser==null?false:true;
 }

 @GetMapping("/search")
 public GeekUser getGeekUser(@RequestParam("page") Integer page){
     Query query = new Query();
     query.addCriteria(Criteria.where("username").is("张三"));
     query.skip(10*page).limit(10);
     List<GeekUser> geekUsers = mongoTemplate.find(query, GeekUser.class);
     return CollectionUtils.isEmpty(geekUsers)?new GeekUser():geekUsers.get(0);

 }



}
