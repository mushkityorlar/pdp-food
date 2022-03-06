package uz.pdp.pdpfood.service.order;

import uz.pdp.pdpfood.dto.order.OrderCreateDto;
import uz.pdp.pdpfood.dto.order.OrderDto;
import uz.pdp.pdpfood.dto.order.OrderUpdateDto;
import uz.pdp.pdpfood.entity.meal.Order;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;

public interface OrderService extends GenericCrudService<
        Order,
        OrderDto,
        OrderCreateDto,
        OrderUpdateDto,
        Long>,
        BaseService {
}
