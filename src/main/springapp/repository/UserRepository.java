package main.springapp.repository;

import main.springapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Page findAllByClazz(String clazz, Pageable pageable);

    List<User> findAllByNumberIn(List<Long> numbers);

}
