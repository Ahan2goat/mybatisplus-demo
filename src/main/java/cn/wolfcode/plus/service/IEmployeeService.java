package cn.wolfcode.plus.service;

import cn.wolfcode.plus.domain.Employee;
import cn.wolfcode.plus.qo.EmployeeQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IEmployeeService extends IService<Employee> {

    IPage<Employee> query(EmployeeQuery qo, QueryWrapper<Employee> wrapper);
}
