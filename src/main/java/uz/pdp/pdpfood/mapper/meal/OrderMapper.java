package uz.pdp.pdpfood.mapper.meal;

import uz.pdp.pdpfood.dto.order.OrderCreateDto;
import uz.pdp.pdpfood.dto.order.OrderDto;
import uz.pdp.pdpfood.dto.order.OrderUpdateDto;
import uz.pdp.pdpfood.entity.meal.Order;
import uz.pdp.pdpfood.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<
        Order,
        OrderDto,
        OrderCreateDto,
        OrderUpdateDto> {
    @Override
    default OrderDto toDto(Order order) {
        return null;
    }

    @Override
    default List<OrderDto> toDto(List<Order> e) {
        return null;
    }

    @Override
    default Order fromCreateDto(OrderCreateDto orderCreateDto) {
        return null;
    }

    @Override
    default Order fromUpdateDto(OrderUpdateDto d) {
        return null;
    }
}
