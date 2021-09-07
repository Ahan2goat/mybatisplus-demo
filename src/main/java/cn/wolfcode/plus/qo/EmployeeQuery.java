package cn.wolfcode.plus.qo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/7
 * @description
 **/
@Getter
@Setter
public class EmployeeQuery {
    private Integer currentPage;
    private Integer pageSize;
}
