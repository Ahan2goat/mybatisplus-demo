package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/6
 * @description
 **/
@SpringBootTest
public class MyBatisPlusAPITest3 {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     *  需求：将id=1的员工age改为18，
     *  如果传入uname变量值不等于null或者“”，
     *  修改为员工name为uname变量值
     */
    @Test
    public void test01() {

    }


}
