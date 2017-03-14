package main.springapp.repository;

import main.springapp.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public interface TestModelRepository extends JpaRepository<TestModel, Long> {
}
