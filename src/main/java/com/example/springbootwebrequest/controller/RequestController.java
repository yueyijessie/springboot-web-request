package com.example.springbootwebrequest.controller;

import com.example.springbootwebrequest.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// @RestController = @Controller + @ResponseBody
@RestController
public class RequestController {

    // 原始方式，了解即可
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        // 获取参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        // 转换类型
        int age = Integer.parseInt(ageStr);
        // 打印，返回
        System.out.println(name+":"+age);
        return "ok";
    }

    // springboot方式
//    @RequestMapping("/springParam")
//    public String springParam(String name, Integer age){
//        System.out.println(name+":"+age);
//        return "ok";
//    }

    // @RequestParam注明这个参数必须传递，不传会400，可以设置required = false来可选传递，默认是true
    // name="name"， 将从请求中寻找名为 "name" 的参数
    @RequestMapping("/springParam")
    public String springParam(@RequestParam(name="name", required = false) String name, Integer age){
        System.out.println(name+":"+age);
        return "ok";
    }

    // 请求参数名与user对象属性名保持一致
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "ok";
    }

    // 复杂实体
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "ok";
    }

    // 数组传参，参数名与传递数组名字保持一致
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    // list集合接收，@RequestParam将多个参数的值封装到list集合
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";
    }

    // 日期时间参数
    // @DateTimeFormat 制定传递的参数格式
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }

    // json参数
    // 需要@RequestBody封装
    @RequestMapping(value = "/jsonParam", method = RequestMethod.POST)
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }

    // 路径参数(单个)
    // @PathVariable获取路径参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }

    // 路径参数(多个)
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + " " + name);
        return "ok";
    }


}
