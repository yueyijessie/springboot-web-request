package com.example.springbootwebrequest.controller;

import com.example.springbootwebrequest.pojo.Emp;
import com.example.springbootwebrequest.pojo.Result;
import com.example.springbootwebrequest.service.EmpService;
import com.example.springbootwebrequest.service.impl.EmpServiceA;
import com.example.springbootwebrequest.utils.XmlParserUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @Controller不用额外加，因为@RestController = @Controller + @ResponseBody
@RestController
public class EmpController {

    // 解耦，需要删掉new的对象
    // private EmpService empService = new EmpServiceA();
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并复制给该变量 -- 依赖注入
//    @Resource(name = "empServiceB")
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
        // 调用service，获取数据
        List<Emp> empList = empService.listEmp();
        // 响应数据
        return Result.success(empList);
    }

//    @RequestMapping("/listEmp")
//    public Result list(){
//        //三层架构（用户请求执行顺序1-2-3-2-1）
//        //1.controller： 控制层，接收前端请求，对请求处理，给出response
//        //2.service：业务逻辑层，处理业务逻辑
//        //3.dao：数据访问层，持久层，负责数据访问操作，数据增删改查
//
//        // 加载并解析emp.xml（dao层）
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
//        // 对数据进行转换处理（service层）
//        empList.stream().forEach(emp -> {
//            // 处理 gender 1:男，2:女
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            } else{
//                emp.setGender("女");
//            }
//
//            // 处理 job 1:讲师，2:班主任，3:就业指导
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            } else if ("2".equals(job)){
//                emp.setJob("班主任");
//            }else {
//                emp.setJob("就业指导");
//            }
//        });
//
//        // 响应数据（controller层）
//        return Result.success(empList);
//    }
}
