package uz.pdp.pdpfood.dto.department;

import uz.pdp.pdpfood.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DepartmentUpdateDto extends GenericDto {
    private String name;
    private String code;
}
