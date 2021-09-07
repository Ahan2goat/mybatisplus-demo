package cn.wolfcode.plus.service.impl;

import cn.wolfcode.plus.domain.Employee;
import cn.wolfcode.plus.mapper.EmployeeMapper;
import cn.wolfcode.plus.qo.EmployeeQuery;
import cn.wolfcode.plus.service.IEmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/7
 * @description
 **/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService{

    @Override
    public IPage<Employee> query(EmployeeQuery qo, QueryWrapper<Employee> wrapper) {
        IPage<Employee> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return this.page(page,wrapper);
    }

}
