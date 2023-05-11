package com.renjun.ems.controller;

import com.renjun.ems.entity.Emp;
import com.renjun.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("findAllEmp")
    public String findAllEmp(Model model){
        List<Emp> allEmp = empService.findAllEmp();
        model.addAttribute("emps",allEmp);
        return "/ems/empList";
    }

    @PostMapping("addEmp")
    public String addEmp(Emp emp){
        //todo 添加失败
        empService.addEmp(emp);
        return "redirect:/emp/findAllEmp";
    }

    @GetMapping("deleteEmp/{empId}")
    public String deleteEmp(@PathVariable(value = "empId") String empId){
        empService.deleteEmp(empId);
        return "redirect:/emp/findAllEmp";

    }

    @GetMapping("findEmpById/{empId}")
    public String findEmpById(@PathVariable(value = "empId") String empId,Model model){
        Emp emp = empService.findEmpById(empId);
        model.addAttribute("emp",emp);
        return "/ems/updateEmp";
    }

    @PostMapping("updateEmpInfo")
    public String updateEmpInfo(Emp emp){
        empService.updateEmpInfo(emp);
        return "redirect:/emp/findAllEmp";
    }

}
