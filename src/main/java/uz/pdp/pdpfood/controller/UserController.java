package uz.pdp.pdpfood.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.service.user.UserServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController<UserServiceImpl> {

    public UserController(UserServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody UserCreateDto dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public UserDto update(@PathVariable Long id, UserUpdateDto dto) {
        return service.update(id, dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/activate/{id}", method = RequestMethod.PATCH)
    public void activate(@PathVariable Long id) {
        service.activate(id);
    }

    @RequestMapping(value = "/block/{id}", method = RequestMethod.PATCH)
    public void block(@PathVariable Long id) {
        service.block(id);
    }

    @RequestMapping(value = "/unblock/{id}", method = RequestMethod.PATCH)
    public void unblock(@PathVariable Long id) {
        service.unblock(id);
    }
}
