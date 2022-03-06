package uz.pdp.pdpfood.service.meal;

import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("mealService")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MealServiceImpl implements MealService {
    @Override
    public Long create(MealCreateDto createDto) {
        return null;
    }

    @Override
    public MealDto update(Long id, MealUpdateDto updateDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public List<MealDto> getAll() {
        return null;
    }

    @Override
    public MealDto get(Long id) {
        return null;
    }
}
