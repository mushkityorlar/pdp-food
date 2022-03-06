package uz.pdp.pdpfood.service.order;

import uz.pdp.pdpfood.dto.order.OrderCreateDto;
import uz.pdp.pdpfood.dto.order.OrderDto;
import uz.pdp.pdpfood.dto.order.OrderUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public Long create(OrderCreateDto createDto) {
        return null;
    }

    @Override
    public OrderDto update(Long id, OrderUpdateDto updateDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public List<OrderDto> getAll() {
        return null;
    }

    @Override
    public OrderDto get(Long id) {
        return null;
    }
}
