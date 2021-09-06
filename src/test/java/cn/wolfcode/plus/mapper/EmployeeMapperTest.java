package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/5
 * @description
 **/
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setAdmin(1);
        employee.setAge(18);
        employee.setDeptId(1L);
        employee.setEmail("dafei@wolfcode");
        employee.setName("dafei");
        employee.setPassword("111");
        employeeMapper.insert(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(1327139013313564673L);
        employee.setAdmin(1);
        employee.setAge(18);
        employee.setDeptId(1L);
        employee.setEmail("dafei@wolfcode.cn");
        employee.setName("xiaofei");
        employee.setPassword("111");
        employeeMapper.updateById(employee);
    }

    @Test
    public void testDelete() {
        employeeMapper.deleteById(1327139013313564673L);
    }

    @Test
    public void testGet() {
        System.out.println(employeeMapper.selectById(1327139013313564673L));
    }

    @Test
    public void testList() {
        System.out.println(employeeMapper.selectList(null));
    }

}
