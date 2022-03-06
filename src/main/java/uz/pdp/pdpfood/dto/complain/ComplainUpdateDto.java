package uz.pdp.pdpfood.dto.complain;

import uz.pdp.pdpfood.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComplainUpdateDto extends GenericDto {
    private String text;
    private Long userId;
}
