package main.springapp.repository;

import main.springapp.model.Teachinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public interface TeachinfoRepository extends JpaRepository<Teachinfo,Long> {


}
