package cn.wolfcode.plus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/5
 * @description
 **/
@Getter
@Setter
@TableName("t_employee")
public class Employee {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "ename", exist = true)
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Integer admin;
    private Long deptId;

    @TableField(exist = false)
    private Integer count;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", admin=" + admin +
                ", deptId=" + deptId +
                '}' + "\n";
    }
}
