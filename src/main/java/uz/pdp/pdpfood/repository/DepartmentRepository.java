package uz.pdp.pdpfood.repository;

import uz.pdp.pdpfood.entity.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long>, AbstractRepository {
}
