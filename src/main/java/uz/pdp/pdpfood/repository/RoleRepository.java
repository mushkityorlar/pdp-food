package uz.pdp.pdpfood.repository;

import uz.pdp.pdpfood.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> ,AbstractRepository {

    Role findByCode(String roleCode);
}
