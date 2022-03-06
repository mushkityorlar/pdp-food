package uz.pdp.pdpfood.service.menu;

import uz.pdp.pdpfood.dto.menu.MenuCreateDto;
import uz.pdp.pdpfood.dto.menu.MenuDto;
import uz.pdp.pdpfood.dto.menu.MenuUpdateDto;
import uz.pdp.pdpfood.entity.meal.Menu;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;

public interface MenuService extends GenericCrudService<
        Menu,
        MenuDto,
        MenuCreateDto,
        MenuUpdateDto,
        Long>,
        BaseService {
}
