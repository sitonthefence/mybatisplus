package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){

        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a")
                        .between("age",20,30)
                                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void test02(){

        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }
    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result："+result);


    }
    @Test
    public void test04(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
      queryWrapper.gt("age", 20).like("name", "a")
                .or().isNull("email");
        User user =new User();
        user.setName("小明");
        user.setEmail("tset@atguigu.com");
        userMapper.update(user,queryWrapper);
    }
    @Test
    public void test05(){
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user =new User();
        user.setName("小红");
        user.setEmail("tset@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result"+result);

    }
    @Test
    public void test06(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);

    }
    @Test
    public void test07(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id<=100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }
    @Test
    public void test08(){
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("name","小黑").set("email","abc@atguigu.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+ result);


    }
    @Test
    public void test11(){
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username).
                ge(ageBegin!=null,User::getAge,ageBegin).
                le(ageEnd!=null,User::getAge,ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);


    }







}
