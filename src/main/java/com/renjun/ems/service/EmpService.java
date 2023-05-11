package com.renjun.ems.service;

import com.renjun.ems.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> findAllEmp();

    void addEmp(Emp emp);

    void deleteEmp(String empId);

    Emp findEmpById(String empId);

    void updateEmpInfo(Emp emp);
}
