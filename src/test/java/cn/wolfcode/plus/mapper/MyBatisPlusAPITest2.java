package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/6
 * @description
 **/
@SpringBootTest
public class MyBatisPlusAPITest2 {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 根据id查询
     */
    @Test
    public void testQuery01() {
        // 需求：查询id=1的员工信息
        // System.out.println(employeeMapper.selectById(1L));
        // 需求：查询id=1，id=2的员工信息
        employeeMapper.selectBatchIds(Arrays.asList(1L, 2L)).forEach(System.out::println);
    }

    /**
     * 需求： 查询name=dafei， age=18的员工信息
     */
    @Test
    public void testQuery02() {
        Map<String, Object> map = new HashMap<>();
        map.put("ename", "dafei");
        map.put("age", 19);
        employeeMapper.selectByMap(map);
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     * 需求： 查询满足条件的所有的员工个数
     */
    @Test
    public void testQuery03() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        // 如果wrapper没有指定条件，或传入一个null,等同于查询所有
        wrapper.eq("ename", "dafei");
        employeeMapper.selectCount(wrapper);
    }

    /**
     * 根据 entity 条件，查询全部记录
     * 需求： 查询满足条件的所有的员工信息， 返回List<Employee>
     */
    @Test
    public void testQuery04() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("admin", 0).eq("dept_id", 2);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 需求： 查询满足条件的所有的员工信息，
     * 返回List<Map<String, Object>>  底层将每条数据封装成HashMap
     */
    @Test
    public void testQuery05() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("admin", 0)
                .eq("dept_id", 2);
        List<Map<String, Object>> list = employeeMapper.selectMaps(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     * 需求：查询第二页员工数据， 每页显示3条， （分页返回的数据是实体对象）
     */
    @Test
    public void testQuery06() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id", 2);
        /*Page<Employee> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);*/
        IPage<Employee> page = new Page<>(1, 2);
        employeeMapper.selectPage(page, wrapper);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总页数：" + page.getPages());
        System.out.println("总数：" + page.getTotal());
        System.out.println("当前页数据：" + page.getRecords());
    }

}
