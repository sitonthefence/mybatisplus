package com.atguigu.mybatisplus.pojo;



import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
//@TableName("t_user")
public class User {
    @TableId(value = "id",type= IdType.AUTO)
   private  Long id;
//   @TableField("name")
   private  String name;

   private Integer age;

   private  String email;

     private SexEnum sex;


   @TableLogic
   private  Integer isDeleted;


}
