package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/6
 * @description
 **/
@SpringBootTest
public class MyBatisPlusQueryWrapperTest4 {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * Wrappers工具类：用于创建各种类型的wrapper
     */
    @Test
    public void testWrappers() {
        // UpdateWrapper
        UpdateWrapper<Employee> updateWrapper1 = new UpdateWrapper<>();
        UpdateWrapper<Employee> updateWrapper2 = Wrappers.<Employee>update();
        // LambdaUpdateWrapper
        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper1 = updateWrapper1.lambda();
        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper2 = new LambdaUpdateWrapper<>();
        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper3 = Wrappers.<Employee>lambdaUpdate();
        // QueryWrapper
        QueryWrapper<Employee> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<Employee> queryWrapper2 = Wrappers.<Employee>query();
        // LambdaQueryWrapper
        LambdaQueryWrapper<Employee> lambdaQueryWrapper1 = queryWrapper2.lambda();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper2 = Wrappers.<Employee>lambdaQuery();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper3 = new LambdaQueryWrapper<>();
    }

    /**
     * 需求：查询name=dafei， age=18的用户
     */
    @Test
    public void test01() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        // 拼接where条件
        wrapper.eq("ename", "dafei").eq("age", 18);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 需求：查询name=dafei， age=18的用户LambdaQueryWrapper
     */
    @Test
    public void test02() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        // 拼接where条件
        wrapper.eq(Employee::getName, "dafei").eq(Employee::getAge, 18);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

}
