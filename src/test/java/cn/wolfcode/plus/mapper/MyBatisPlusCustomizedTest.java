package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class MyBatisPlusCustomizedTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() {
        employeeMapper.listByXmlSingle().forEach(System.out::println);
    }

    @Test
    public void test02() {
        employeeMapper.listByXmlJoin().forEach(System.out::println);
    }
}
