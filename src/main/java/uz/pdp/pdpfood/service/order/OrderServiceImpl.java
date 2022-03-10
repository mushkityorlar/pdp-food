package uz.pdp.pdpfood.service.order;

import uz.pdp.pdpfood.dto.order.OrderCreateDto;
import uz.pdp.pdpfood.dto.order.OrderDto;
import uz.pdp.pdpfood.dto.order.OrderUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.pdpfood.entity.meal.Order;
import uz.pdp.pdpfood.mapper.order.OrderMapper;
import uz.pdp.pdpfood.repository.OrderRepository;
import uz.pdp.pdpfood.service.AbstractService;

import java.util.List;

@Service("orderService")
@Slf4j
//@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl extends AbstractService<OrderRepository, OrderMapper> implements OrderService {

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(OrderCreateDto createDto) {
        log.info("saving order {} {}", createDto.getMealId(), createDto.getUserId());
        Order order = mapper.fromCreateDto(createDto);
        repository.save(order);
        return order.getId();
    }

    @Override
    public OrderDto update(Long id, OrderUpdateDto updateDto) {
        Order order = mapper.fromUpdateDto(updateDto);
        return mapper.toDto(repository.save(order));
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<OrderDto> getAll() {
        log.info("fetching all order");
        List<Order> orders = repository.findAll();
        return mapper.toDto(orders);
    }

    @Override
    public OrderDto get(Long id) {
        return null;
    }
}
