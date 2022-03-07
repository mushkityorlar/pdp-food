package uz.pdp.pdpfood.mapper.department;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdpfood.dto.department.DepartmentCreateDto;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.dto.department.DepartmentUpdateDto;
import uz.pdp.pdpfood.entity.department.Department;
import uz.pdp.pdpfood.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseMapper<
        Department,
        DepartmentDto,
        DepartmentCreateDto,
        DepartmentUpdateDto> {
    @Override
    default DepartmentDto toDto(Department department) {
        return null;
    }

    @Override
    default List<DepartmentDto> toDto(List<Department> e) {
        return null;
    }

    @Override
    default Department fromCreateDto(DepartmentCreateDto departmentCreateDto) {
        return null;
    }

    @Override
    default Department fromUpdateDto(DepartmentUpdateDto d) {
        return null;
    }
}
