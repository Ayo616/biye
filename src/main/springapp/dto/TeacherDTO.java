package main.springapp.dto;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/3 0003.
 */
public class TeacherDTO {
    private Long teacher_id;
    private String name;
    private ArrayList<String> teachclazz;


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

    public ArrayList<String> getTeachclazz() {
        return teachclazz;
    }

    public void setTeachclazz(ArrayList<String> teachclazz) {
        this.teachclazz = teachclazz;
    }
}
