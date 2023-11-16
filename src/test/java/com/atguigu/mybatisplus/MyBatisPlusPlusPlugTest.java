package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPlusPlugTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void  testPage(){
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
  /*  @Test
    public void testPageVo(){
        Page<User> page=new Page<>(1,3);
        userMapper.selectPageVo(page,20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }*/
    @Test
    public void testProduct01(){
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格"+productLi.getPrice());
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格"+productWang.getPrice());
       productLi.setPrice(productLi.getPrice()+50);
       productMapper.updateById(productLi);
       productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result==0){
            Product productNew=productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);

        }


        Product productLaoban= productMapper.selectById(1);
        System.out.println("老板查询的商品价格"+productLaoban.getPrice());

    }



}
