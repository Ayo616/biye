package main.springapp.repository;

import main.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
