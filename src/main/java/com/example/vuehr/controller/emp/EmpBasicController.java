package com.example.vuehr.controller.emp;

import com.example.vuehr.bean.Employee;
import com.example.vuehr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xu
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmpService empService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(
            @RequestParam(defaultValue = "1")Integer page,
            @RequestParam(defaultValue = "10")Integer size,
            @RequestParam(defaultValue = "") String keywords,
            Long politicId, Long nationId, Long posId,
            Long jobLevelId, String engageForm,
            Long departmentId, String beginDateScope) {

        Map<String, Object> map = new HashMap<>();
        List<Employee> employeeByPage = empService.getEmployeeByPage(page, size,
                keywords,politicId, nationId, posId, jobLevelId, engageForm,
                departmentId, beginDateScope);
        Long count = empService.getCountByKeywords(keywords, politicId, nationId,
                posId,jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeeByPage);
        map.put("count", count);
        return map;

    }

}
