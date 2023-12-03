package com.example.springbootwebrequest.dao.impl;

import com.example.springbootwebrequest.dao.EmpDao;
import com.example.springbootwebrequest.pojo.Emp;
import com.example.springbootwebrequest.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component //将当前类交给IOC容器管理，成为IOC容器中的bean（实现控制反转）
@Repository("daoA") // 括号中可以重命名bean对象（value属性），如果没有制定，默认为雷鸣首字母小写，即empDao
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 加载并解析emp.xml（dao层）
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
