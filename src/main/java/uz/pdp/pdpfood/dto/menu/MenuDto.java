package uz.pdp.pdpfood.dto.menu;

import uz.pdp.pdpfood.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto extends GenericDto {
    private LocalDate date = LocalDate.now();
    private Long mealId;
}
