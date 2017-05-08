package main.springapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
@Entity
@Table(name = "teachinfo")
public class Teachinfo implements Serializable {
    private static final long serialVersionUID = -2105278032110019051L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "clazz")
    private String teachclass;

    @Column(name = "realte")
    private String  relate;


    public Teachinfo() {
    }


    public String getRelate() {
        return relate;
    }

    public void setRelate(String relate) {
        this.relate = relate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTeachclass() {
        return teachclass;
    }

    public void setTeachclass(String teachclass) {
        this.teachclass = teachclass;
    }

}
