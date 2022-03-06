package uz.pdp.pdpfood.dto.department;

import uz.pdp.pdpfood.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DepartmentCreateDto implements Dto {
    private String name;
    private String code;
    private Long chatId;
}
