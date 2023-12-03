package com.example.springbootwebrequest.controller;

import com.example.springbootwebrequest.pojo.Address;
import com.example.springbootwebrequest.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {

//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("Hello World ~");
//        return "Hello World ~";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr(){
//        Address address = new Address();
//        address.setCity("shenyang");
//        address.setProvince("liaoning");
//        return address;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr(){
//        List<Address> list = new ArrayList<>();
//        Address addr = new Address();
//        addr.setProvince("beijing");
//        addr.setCity("beijing");
//
//        Address addr2 = new Address();
//        addr2.setProvince("liaoning");
//        addr2.setCity("shenyang");
//
//        list.add(addr);
//        list.add(addr2);
//        return list;
//    }

    // 以下方法使用result进行封装

    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello World ~");
        return Result.success("Hello World ~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address address = new Address();
        address.setCity("shenyang");
        address.setProvince("liaoning");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list = new ArrayList<>();
        Address addr = new Address();
        addr.setProvince("beijing");
        addr.setCity("beijing");

        Address addr2 = new Address();
        addr2.setProvince("liaoning");
        addr2.setCity("shenyang");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }
}
