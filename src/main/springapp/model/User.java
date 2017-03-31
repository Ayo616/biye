package main.springapp.model;



import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表
 */

@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final long serialVersionUID = -3670565057179448740L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;  //姓名

    @Column(name = "number")
    private Long number; //学号

    @Column(name = "deviceID")
    private Long deviceID; //实验箱设备号

    @Column(name = "password")
    private String password; //密码

    @Column(name = "score")
    private String score;  //分数

    @Column(name = "clazz")
    private String clazz;  //班级

    @Column(name = "role")
    private Long role;   //角色

    public User() {
    }


}
