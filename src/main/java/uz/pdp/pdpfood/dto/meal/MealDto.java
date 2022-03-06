package uz.pdp.pdpfood.dto.meal;

import uz.pdp.pdpfood.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MealDto extends GenericDto {
    private String name;
    private String image;
    private String type;
    private LocalDateTime createdAt;
    private Long createdBy;


    @Builder(builderMethodName = "childBuilder")
    public MealDto(Long id, String name, String image, String type, LocalDateTime createdAt, Long createdBy) {
        super(id);
        this.name = name;
        this.image = image;
        this.type = type;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}
