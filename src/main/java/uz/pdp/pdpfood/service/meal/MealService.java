package uz.pdp.pdpfood.service.meal;

import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import uz.pdp.pdpfood.entity.meal.Meal;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;

public interface MealService extends GenericCrudService<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto,
        Long>,
        BaseService {
}
