package cn.wolfcode.plus.domain;

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
public class Employee {
    private Long id;
    private String name;
    private String password;
    private String email;
    private int age;
    private int admin;
    private Long deptId;

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
