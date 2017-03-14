package main.springapp.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14 0014.
 */

@Entity
public class TestModel implements Serializable{
    private static final long serialVersionUID = -6269511317609141129L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="test_id")
    private long id;

    @Column(name = "test_str",nullable = false)
    private String testString;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public TestModel() {
    }
}
