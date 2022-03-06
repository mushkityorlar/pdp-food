package uz.pdp.pdpfood.dto.menu;

import uz.pdp.pdpfood.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateDto  implements Dto {
    private LocalDate date = LocalDate.now();
    private Long mealId;

}
