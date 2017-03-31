package main.springapp.repository;

import main.springapp.model.Dfactor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
public interface FactorRepository extends JpaRepository<Dfactor,Long>{
}
