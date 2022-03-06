package uz.pdp.pdpfood.service.department;

import uz.pdp.pdpfood.dto.department.DepartmentCreateDto;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.dto.department.DepartmentUpdateDto;
import uz.pdp.pdpfood.entity.department.Department;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;

public interface DepartmentService extends GenericCrudService<
        Department,
        DepartmentDto,
        DepartmentCreateDto,
        DepartmentUpdateDto,
        Long>,
        BaseService {
}
