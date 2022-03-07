package uz.pdp.pdpfood.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.complain.ComplainCreateDto;
import uz.pdp.pdpfood.dto.complain.ComplainDto;
import uz.pdp.pdpfood.dto.complain.ComplainUpdateDto;
import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.service.complaint.ComplaintServiceImpl;

import java.util.List;


@Api(value = "Complaint Rest Controller")
@RestController
@RequestMapping("/api/complaint")
public class ComplaintController extends AbstractController<ComplaintServiceImpl> {

    public ComplaintController(ComplaintServiceImpl service) {
        super(service);
    }

    @ApiOperation(value = "Create Complain", response = Long.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody ComplainCreateDto dto) {
        return service.create(dto);
    }

    @ApiOperation(value = "Get Complain By Id", response = ComplainDto.class)
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ComplainDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @ApiOperation(value = "Get All Complains", response = Iterable.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ComplainDto> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Update Complain", response = ComplainDto.class)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ComplainDto update(@PathVariable Long id, ComplainUpdateDto dto) {
        return service.update(id, dto);
    }

    @ApiOperation(value = "Delete Complain")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
