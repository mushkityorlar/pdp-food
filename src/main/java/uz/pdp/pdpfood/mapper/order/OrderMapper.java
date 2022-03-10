package uz.pdp.pdpfood.mapper.order;

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
    OrderDto toDto(Order order);

    @Override
    List<OrderDto> toDto(List<Order> e);

    @Override
    Order fromCreateDto(OrderCreateDto orderCreateDto);

    @Override
    Order fromUpdateDto(OrderUpdateDto d);
}
