package main.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = -2105278032110019051L;

    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Long teacher_id;

    @Column(name = "name")
    private String name;  //姓名

    @Column(name = "password")
    @JsonIgnore
    private String password; //密码

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="relate",referencedColumnName = "name")
    private Set<Teachinfo> teachinfos;


    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @JsonManagedReference
    @JsonIgnoreProperties(value = "roleId")
    private Role role;   //角色

    public Teacher() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Teachinfo> getTeachinfos() {
        return teachinfos;
    }

    public void setTeachinfos(Set<Teachinfo> teachinfos) {
        this.teachinfos = teachinfos;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
