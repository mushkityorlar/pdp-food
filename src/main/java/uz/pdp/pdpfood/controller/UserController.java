package uz.pdp.pdpfood.controller;

import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.service.user.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User Controller Api",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = "user controller")

@ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 405, message = "Method not allowed"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController<UserServiceImpl> {

    public UserController(UserServiceImpl service) {
        super(service);
    }

    @ApiOperation(value = "Create User", response = Long.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody UserCreateDto dto) {
        return service.create(dto);
    }

    @ApiOperation(value = "Get User By Id", response = UserDto.class)
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @ApiOperation(value = "Get All Users", response = Iterable.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Update User", response = UserDto.class)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public UserDto update(@PathVariable Long id, UserUpdateDto dto) {
        return service.update(id, dto);
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ApiOperation(value = "Activate User")
    @RequestMapping(value = "/activate/{id}", method = RequestMethod.PATCH)
    public void activate(@PathVariable Long id) {
        service.activate(id);
    }

    @ApiOperation(value = "Block User")
    @RequestMapping(value = "/block/{id}", method = RequestMethod.PATCH)
    public void block(@PathVariable Long id) {
        service.block(id);
    }

    @ApiOperation(value = "Unblock User")
    @RequestMapping(value = "/unblock/{id}", method = RequestMethod.PATCH)
    public void unblock(@PathVariable Long id) {
        service.unblock(id);
    }

}
