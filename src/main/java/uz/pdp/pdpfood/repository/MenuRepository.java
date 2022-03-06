package uz.pdp.pdpfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdpfood.entity.meal.Menu;


public interface MenuRepository extends JpaRepository<Menu, Long>, AbstractRepository {
}
