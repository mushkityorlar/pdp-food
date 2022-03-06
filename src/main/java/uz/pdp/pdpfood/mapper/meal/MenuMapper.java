package uz.pdp.pdpfood.mapper.meal;

import uz.pdp.pdpfood.dto.menu.MenuCreateDto;
import uz.pdp.pdpfood.dto.menu.MenuDto;
import uz.pdp.pdpfood.dto.menu.MenuUpdateDto;
import uz.pdp.pdpfood.entity.meal.Menu;
import uz.pdp.pdpfood.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MenuMapper  extends BaseMapper<
        Menu,
        MenuDto,
        MenuCreateDto,
        MenuUpdateDto> {
    @Override
    default MenuDto toDto(Menu menu) {
        return null;
    }

    @Override
    default List<MenuDto> toDto(List<Menu> e) {
        return null;
    }

    @Override
    default Menu fromCreateDto(MenuCreateDto menuCreateDto) {
        return null;
    }

    @Override
    default Menu fromUpdateDto(MenuUpdateDto d) {
        return null;
    }
}
