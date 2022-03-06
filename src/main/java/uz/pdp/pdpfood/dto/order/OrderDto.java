package uz.pdp.pdpfood.dto.order;

import uz.pdp.pdpfood.dto.GenericDto;

import java.time.LocalDate;


public class OrderDto extends GenericDto {
    private Long userId;
    private Long mealID;
    private LocalDate date;
    private boolean receive;
}
