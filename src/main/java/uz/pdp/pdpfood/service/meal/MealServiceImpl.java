package uz.pdp.pdpfood.service.meal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import uz.pdp.pdpfood.entity.meal.Meal;
import uz.pdp.pdpfood.mapper.meal.MealMapper;
import uz.pdp.pdpfood.repository.MealRepository;
import uz.pdp.pdpfood.service.AbstractService;

import java.util.List;
import java.util.Optional;


@Service("mealService")
@Slf4j
@Transactional
public class MealServiceImpl extends AbstractService<MealRepository, MealMapper> implements MealService {

    public MealServiceImpl(MealRepository repository, MealMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(MealCreateDto createDto) {
        log.info("saving Meal {}", createDto.getName());
        Meal meal = mapper.fromCreateDto(createDto);
        repository.save(meal);
        return meal.getId();
    }

    @Override
    public MealDto update(Long id, MealUpdateDto updateDto) {
        Meal meal = mapper.fromUpdateDto(updateDto);
        repository.save(meal);
        return mapper.toDto(meal);
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<MealDto> getAll() {
        log.info("fetching all meals");
        List<Meal> meals = repository.findAll();
        return mapper.toDto(meals);

    }

    @Override
    public MealDto get(Long id) {
        Optional<Meal> meal = repository.findById(id);
        return mapper.toDto(meal.get());
    }
}
