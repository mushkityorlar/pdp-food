package uz.pdp.pdpfood.repository;

import uz.pdp.pdpfood.entity.meal.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>, AbstractRepository {
}
