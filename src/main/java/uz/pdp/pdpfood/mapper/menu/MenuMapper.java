package uz.pdp.pdpfood.mapper.menu;

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
    MenuDto toDto(Menu menu);

    @Override
    List<MenuDto> toDto(List<Menu> e);

    @Override
    Menu fromCreateDto(MenuCreateDto menuCreateDto);

    @Override
    Menu fromUpdateDto(MenuUpdateDto d);
}
