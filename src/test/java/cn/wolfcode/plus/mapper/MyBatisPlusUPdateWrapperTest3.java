package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/6
 * @description
 **/
@SpringBootTest
public class MyBatisPlusUPdateWrapperTest3 {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 需求：将id=1的员工age改为18，
     * 如果传入uname变量值不等于null或者“”，
     * 修改为员工name为uname变量值
     */
    @Test
    public void test01() {
        String uname = "xiaofei";
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 1)
                .set("age", 18);
        // 第一个参数为是否拼接参数的开关，true表示拼接，false表示不拼接
        wrapper.set(StringUtils.hasLength(uname), "ename", uname);
        employeeMapper.update(null, wrapper);
    }


    /**
     * 需求：将id=1的用户name改为dafei
     * setSql
     */
    @Test
    public void test02() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 1L);
        wrapper.setSql("ename = 'dafei'");
        employeeMapper.update(null, wrapper);
    }

    /**
     * 推荐使用LambdaUpdateWrapper
     * 需求：将id=1的用户name改为dafei
     * 使用LambdaUpdateWrapper
     */
    @Test
    public void test03() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Employee::getId, 1L)
                .set(Employee::getName, "dafei");
        employeeMapper.update(null, wrapper);
    }

}
