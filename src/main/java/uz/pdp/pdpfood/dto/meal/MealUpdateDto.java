package uz.pdp.pdpfood.dto.meal;

import uz.pdp.pdpfood.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MealUpdateDto extends GenericDto {
    private String name;

    private String image;

    private String type;

    @Builder(builderMethodName = "childBuilder")
    public MealUpdateDto(String name, String image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }
}
