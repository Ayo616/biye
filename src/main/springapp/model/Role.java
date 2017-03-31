package main.springapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable{
    private static final long serialVersionUID = -2105278032110019051L;

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", unique = true)
    private String roleName;

    public Role() {
    }

}
