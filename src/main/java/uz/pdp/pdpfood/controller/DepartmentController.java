package uz.pdp.pdpfood.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.department.DepartmentCreateDto;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.dto.department.DepartmentUpdateDto;
import uz.pdp.pdpfood.service.department.DepartmentServiceImpl;

import java.util.List;

@Api(value = "Department Rest Controller")
@RestController
@RequestMapping("/api/department")
public class DepartmentController extends AbstractController<DepartmentServiceImpl> {

    public DepartmentController(DepartmentServiceImpl service) {
        super(service);
    }

    @ApiOperation(value = "Create Department", response = Long.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody DepartmentCreateDto dto) {
        return service.create(dto);
    }

    @ApiOperation(value = "Get Department By Id", response = DepartmentDto.class)
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public DepartmentDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @ApiOperation(value = "Get All Departments", response = Iterable.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DepartmentDto> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Update Department", response = DepartmentDto.class)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public DepartmentDto update(@PathVariable Long id, DepartmentUpdateDto dto) {
        return service.update(id, dto);
    }
}
