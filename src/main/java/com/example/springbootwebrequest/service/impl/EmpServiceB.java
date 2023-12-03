package com.example.springbootwebrequest.service.impl;

import com.example.springbootwebrequest.dao.EmpDao;
import com.example.springbootwebrequest.pojo.Emp;
import com.example.springbootwebrequest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary // 当存在多个同类型的bean，加primary告诉ioc他们的优先级
@Component //将当前类交给IOC容器管理，成为IOC容器中的bean（实现控制反转）
public class EmpServiceB implements EmpService {
    // 解耦
    // private EmpDao empDao = new EmpDaoA();
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并复制给该变量 -- 依赖注入
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 调用dao，获取数据
        List<Emp> empList = empDao.listEmp();

        // 对数据进行转换处理（service层）
        empList.stream().forEach(emp -> {
            // 处理 gender 1:男，2:女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            } else{
                emp.setGender("女士");
            }

            // 处理 job 1:讲师，2:班主任，3:就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)){
                emp.setJob("班主任");
            }else {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
