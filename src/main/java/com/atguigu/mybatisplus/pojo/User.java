package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@TableName("t_user")
public class User {
   @TableId(type = IdType.AUTO )
   private  Long id;
   @TableField("name")
   private  String name;

   private Integer age;

   private  String email;
   private SexEnum sex;


   @TableLogic
   private  Integer isDeleted;

}
