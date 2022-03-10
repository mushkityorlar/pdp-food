package uz.pdp.pdpfood.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import uz.pdp.pdpfood.service.meal.MealServiceImpl;

import java.util.List;


@RequestMapping("/api/meal")
@RestController
public class MealController extends AbstractController<MealServiceImpl> {

    public MealController(MealServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody MealCreateDto dto) {
        return service.create(dto);
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MealDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<MealDto> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public MealDto update(@PathVariable Long id, MealUpdateDto dto) {
        return service.update(id, dto);
    }


}

