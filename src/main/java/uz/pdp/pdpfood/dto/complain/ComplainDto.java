package uz.pdp.pdpfood.dto.complain;

import lombok.NoArgsConstructor;
import uz.pdp.pdpfood.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplainDto extends GenericDto {
    private String text;
    private Long userId;
}
