package main.springapp.repository;

import main.springapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
}
