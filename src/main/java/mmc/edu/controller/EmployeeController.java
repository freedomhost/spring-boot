package mmc.edu.controller;

import mmc.edu.dao.DepartmentDao;
import mmc.edu.dao.EmployeeDao;
import mmc.edu.entities.Department;
import mmc.edu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee emp){
        System.out.println("emp: "+emp);
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id,Model model){
        model.addAttribute("emp",employeeDao.get(id));
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
    @PutMapping("emp")
    public String toEmpsPage(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
