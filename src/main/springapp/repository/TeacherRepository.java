package main.springapp.repository;

import main.springapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
