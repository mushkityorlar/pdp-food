package uz.pdp.pdpfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.order.OrderCreateDto;
import uz.pdp.pdpfood.dto.order.OrderDto;
import uz.pdp.pdpfood.dto.order.OrderUpdateDto;
import uz.pdp.pdpfood.service.order.OrderServiceImpl;

import java.util.List;


@RequestMapping("/api/order")
@RestController
public class OrderController extends AbstractController<OrderServiceImpl>{

    @Autowired
    public OrderController(OrderServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create/")
    public Long create(@RequestBody OrderCreateDto dto){
        return service.create(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public OrderDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<OrderDto> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public OrderDto update(@PathVariable Long id, OrderUpdateDto dto) {
        return service.update(id, dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
