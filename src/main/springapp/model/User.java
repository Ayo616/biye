package main.springapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.Table;
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



    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "device_id",referencedColumnName = "id")
    @JsonManagedReference
    private Dfactor deviceID; //实验箱设备号

    @JsonIgnore
    @Column(name = "password")
    private String password; //密码

    @Column(name = "score")
    private String score;  //分数

    @Column(name = "clazz")
    private String clazz;  //班级


    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @JsonManagedReference
    @JsonIgnoreProperties(value = "roleId")
    private Role role;   //角色

    public User() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Dfactor getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Dfactor deviceID) {
        this.deviceID = deviceID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
