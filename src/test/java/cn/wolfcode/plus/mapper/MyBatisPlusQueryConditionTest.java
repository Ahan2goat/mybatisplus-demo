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
public class MyBatisPlusQueryConditionTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 列投影
     * 需求： 需求：查询所有员工， 返回员工name， age列
     */
    @Test
    public void test01() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select("ename", "age");
        employeeMapper.selectMaps(wrapper).forEach(System.out::println);

    }

    /**
     * 需求：查询所有员工， 返回员工以a字母开头的列
     */
    @Test
    public void test02() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select(Employee.class, tableFieldInfo -> tableFieldInfo.getProperty().startsWith("a"));
        employeeMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    /**
     * 需求：查询所有员工信息按age正序排， 如果age一样， 按id倒序排
     */
    @Test
    public void test03() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        // wrapper.orderByAsc(Employee::getAge).orderByDesc(Employee::getId);
        wrapper.orderBy(true, true, Employee::getAge)
                .orderBy(true, false, Employee::getId);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 需求： 以部门id进行分组查询，查每个部门员工个数
     */
    @Test
    public void test04() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.groupBy("dept_id");
        wrapper.select("dept_id", "count(*)");
        employeeMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    /**
     * 需求： 以部门id进行分组查询，查每个部门员工个数， 将大于3人的部门过滤出来
     */
    @Test
    public void test05() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();

        wrapper.select("dept_id", "count(*)")
                .groupBy("dept_id")
                .having("count(*) > {0}", 3);
        //.having("count(*) > 3");
        employeeMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test06() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("admin", "0");
        wrapper.ne("age", 25);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * like
     * 需求： 查询name中含有fei字样的员工
     */
    @Test
    public void test07() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        // wrapper.like("ename", "fei");
        // wrapper.likeLeft("ename", "fei");
        wrapper.likeRight("ename", "fei");
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 需求：查询name含有fei字样的并且 年龄在小于18或者大于30的用户
     */
    @Test
    public void test08() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("ename", "fei")
                .and(wp -> wp.lt("age", 18)
                             .or()
                             .gt("age", 30));
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }
}
