package com.example.springbootwebrequest.service;

import com.example.springbootwebrequest.pojo.Emp;

import java.util.List;

public interface EmpService {
    // 获取员工列表
    public List<Emp> listEmp();
}
