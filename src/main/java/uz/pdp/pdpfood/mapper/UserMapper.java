package uz.pdp.pdpfood.mapper;

import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.entity.user.AuthUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<
        AuthUser,
        UserDto,
        UserCreateDto,
        UserUpdateDto > {
}
