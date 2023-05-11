package com.renjun.ems.dao;

import com.renjun.ems.entity.Emp;

import java.util.List;

public interface EmpDao {

    List<Emp> findAllEmp();

    void addEmp(Emp emp);

    void deleteEmp(String empId);

    Emp findEmpById(String empId);

    void updateEmpInfo(Emp emp);
}
