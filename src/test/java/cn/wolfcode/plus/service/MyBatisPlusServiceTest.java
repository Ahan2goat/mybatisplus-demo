package cn.wolfcode.plus.service;

import cn.wolfcode.plus.domain.Employee;
import cn.wolfcode.plus.qo.EmployeeQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/7
 * @description
 **/
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void test01() {
        /**
         * 需求：查询第2页员工信息， 每页显示3条， 按id排序
         */
        EmployeeQuery qo = new EmployeeQuery();
        qo.setPageSize(3);
        qo.setCurrentPage(2);
        QueryWrapper<Employee> wrapper = Wrappers.<Employee>query();
        wrapper.orderByAsc("id");
        IPage<Employee> page = employeeService.query(qo, wrapper);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("当前页显示记录：" + page.getRecords());
    }
}
