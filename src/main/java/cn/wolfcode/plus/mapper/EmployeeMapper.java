package cn.wolfcode.plus.mapper;

import cn.wolfcode.plus.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/5
 * @description
 **/
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> listByXmlSingle();

    List<Employee> listByXmlJoin();
}
