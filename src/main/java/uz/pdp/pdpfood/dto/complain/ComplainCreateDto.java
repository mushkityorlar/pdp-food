package uz.pdp.pdpfood.dto.complain;

import lombok.NoArgsConstructor;
import uz.pdp.pdpfood.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplainCreateDto implements Dto {
    private String text;
    private Long userId;
}
