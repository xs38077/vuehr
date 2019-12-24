package com.example.vuehr.mapper;

import com.example.vuehr.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Xu
 */
@Mapper
public interface EmpMapper {

    List<Employee> getEmployeeByPage(int start, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, Date startBeginDate, Date endBeginDate);

    Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, Date startBeginDate, Date endBeginDate);
}
