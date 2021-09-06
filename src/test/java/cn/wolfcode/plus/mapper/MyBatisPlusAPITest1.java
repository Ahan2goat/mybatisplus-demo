package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/6
 * @description
 **/
@SpringBootTest
public class MyBatisPlusAPITest1 {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 需求： 将id=1用户名字修改为dafei
     */
    @Test
    public void test01() {
        // 1. 实体类的字段全都为包装类型，默认值为null，便不会进行Sql拼接
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("dafei");
        employeeMapper.updateById(employee);
        // 2. 先查后改
        /*Employee employee = employeeMapper.selectById(1L);
        employee.setName("xiaofei");
        employeeMapper.updateById(employee);*/
    }

    /**
     * 需求：更新name=dafei  员工年龄为18岁
     */
    @Test
    public void test02() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("ename", "dafei")
                .set("age", "18");
        employeeMapper.update(null, wrapper);
    }

    /**
     * 需求：更新name=dafei员工年龄为18岁
     */
    @Test
    public void test03() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("ename", "dafei");
        Employee employee = new Employee();
        employee.setAge(19);
        employeeMapper.update(employee, wrapper);
    }

    /**
     * 需求：更新name=dafei，并且password=1111的员工年龄为18岁
     */
    @Test
    public void test04() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("ename", "dafei")
                .eq("password", "1111")
                .set("age", 18);
        employeeMapper.update(null, wrapper);
    }

    /**
     * 根据 ID 删除
     */
    @Test
    public void test05() {
        employeeMapper.deleteById(1434845537680535555L);
    }

    /**
     * 删除（根据ID 批量删除）
     */
    @Test
    public void test06() {
        employeeMapper.deleteBatchIds(Arrays.asList(1434841202263330819L, 1434841202263330820L));
    }

    /**
     * 根据 columnMap 条件，删除记录
     * 需求：删除name=dafei并且age=18的员工信息
     */
    @Test
    public void test07() {
        Map<String, Object> map = new HashMap<>();
        map.put("ename", "dafei");
        map.put("age", 18);
        employeeMapper.deleteByMap(map);
    }

    /**
     * 需求：删除name=dafei并且age=18的员工信息
     * QueryWrapper
     */
    @Test
    public void test08() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("ename", "dafei")
                .eq("age", 18);
        employeeMapper.delete(wrapper);
    }
}
