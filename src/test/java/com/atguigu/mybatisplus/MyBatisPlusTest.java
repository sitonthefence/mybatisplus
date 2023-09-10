package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;

import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {
@Autowired
    private UserMapper userMapper;
 @Test
    public void testSelectList(){

     List<User> list = userMapper.selectList(null);
     list.forEach(System.out::println);

 }

 @Test

    public void testInsert(){
     User user=new User();
     user.setName("张三");
     user.setAge(23);
     user.setEmail("zhangsan@atguigu.com");
     int result = userMapper.insert(user);
     System.out.println("result"+result);
     System.out.println("id"+user.getId());

 }
 @Test
    public void testDelete(){
/*     int result = userMapper.deleteById(1700859150474551298L);
     System.out.println("result:"+result);*/

/*  Map<String,Object> map=new HashMap<>();
  map.put("name","张三");
  map.put("age",23);
  int result = userMapper.deleteByMap(map);
  System.out.println("result:"+result);*/
  List<Long> list = Arrays.asList(1L, 2L, 3L);
  int result = userMapper.deleteBatchIds(list);
  System.out.println("result:"+result);

 }
 @Test
     public void testUpdate(){
     User user=new User();
     user.setId(4L);
     user.setName("李四");
     user.setEmail("lisi@atguigu.com");
  int result = userMapper.updateById(user);
  System.out.println("result:"+result);

 }
 @Test
 public  void  testSelect(){

/*  User user=userMapper.selectById(1L);
  System.out.println(user);*/
/*  List<Long> list = Arrays.asList(1L, 2L, 3L);
  List<User> users = userMapper.selectBatchIds(list);
  users.forEach(System.out::println);*/
/*
  Map<String,Object>map=new HashMap<>();
  map.put("name","jack");
map.put("age",20);

  List<User> users = userMapper.selectByMap(map);
  users.forEach(System.out::println);
*/
/*
  List<User> users = userMapper.selectList(null);
  users.forEach(System.out::println);*/
     Map<String, Object> map = userMapper.selectMapById(1L);
     System.out.println(map);

 }






}
