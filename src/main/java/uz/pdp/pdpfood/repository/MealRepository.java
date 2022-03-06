package uz.pdp.pdpfood.repository;

import uz.pdp.pdpfood.entity.meal.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long>,AbstractRepository{
}
