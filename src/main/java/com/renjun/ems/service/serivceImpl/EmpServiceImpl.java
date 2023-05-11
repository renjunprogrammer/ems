package com.renjun.ems.service.serivceImpl;

import com.renjun.ems.dao.EmpDao;
import com.renjun.ems.entity.Emp;
import com.renjun.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> findAllEmp() {
        List<Emp> allEmp = empDao.findAllEmp();
        return allEmp;
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.addEmp(emp);
    }

    @Override
    public void deleteEmp(String empId) {
        empDao.deleteEmp(empId);
    }

    @Override
    public Emp findEmpById(String empId) {
        Emp emp = empDao.findEmpById(empId);
        return emp;
    }

    @Override
    public void updateEmpInfo(Emp emp) {
        empDao.updateEmpInfo(emp);
    }
}
