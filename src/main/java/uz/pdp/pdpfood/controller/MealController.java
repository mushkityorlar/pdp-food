package uz.pdp.pdpfood.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.meal.MealCreateDto;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.dto.meal.MealUpdateDto;
import uz.pdp.pdpfood.service.meal.MealServiceImpl;

import java.util.List;


@Api(value = "Mael Rest Controller")
@RequestMapping("/api/meal")
@RestController
public class MealController extends AbstractController<MealServiceImpl> {

    public MealController(MealServiceImpl service) {
        super(service);
    }

    @ApiOperation(value = "Create Meal", response = Long.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody MealCreateDto dto) {
        return service.create(dto);
    }


    @ApiOperation(value = "Get Meal By Id", response = MealDto.class)
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MealDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @ApiOperation(value = "Get All Meals", response = Iterable.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<MealDto> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Update Meal", response = MealDto.class)
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public MealDto update(@PathVariable Long id, MealUpdateDto dto) {
        return service.update(id, dto);
    }


}

