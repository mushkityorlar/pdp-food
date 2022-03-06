package uz.pdp.pdpfood.service.user;

import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.entity.user.AuthUser;
import uz.pdp.pdpfood.entity.user.Role;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService extends GenericCrudService<
        AuthUser,
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        Long >, BaseService , UserDetailsService {
    Role saveRole(Role role);

    void attachRoleToUser(String username, String roleCode);

    UserDto getUserByUsername(String username);

    void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
