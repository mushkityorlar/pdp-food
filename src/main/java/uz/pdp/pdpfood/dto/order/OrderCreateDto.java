package uz.pdp.pdpfood.dto.order;

import uz.pdp.pdpfood.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class OrderCreateDto implements Dto {
    private Long userId;
    private Long mealID;
    private LocalDate date;
    private boolean receive;
}
