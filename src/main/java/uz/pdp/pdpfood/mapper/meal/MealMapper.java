package uz.pdp.pdpfood.mapper.meal;

import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import uz.pdp.pdpfood.entity.meal.Meal;
import uz.pdp.pdpfood.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MealMapper extends BaseMapper<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto> {

    @Override
    MealDto toDto(Meal meal);

    @Override
    List<MealDto> toDto(List<Meal> e);

    @Override
    Meal fromCreateDto(MealCreateDto mealCreateDto);

    @Override
    Meal fromUpdateDto(MealUpdateDto d);
}
