package pl.myblog.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myblog.springblog.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {


}
