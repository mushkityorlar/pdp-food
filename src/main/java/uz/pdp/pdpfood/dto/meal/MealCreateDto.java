package uz.pdp.pdpfood.dto.meal;

import uz.pdp.pdpfood.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealCreateDto implements Dto {
    private String name;
    private String image;
    private String type;
}
