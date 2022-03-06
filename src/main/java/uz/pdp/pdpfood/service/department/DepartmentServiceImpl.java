package uz.pdp.pdpfood.service.department;

import uz.pdp.pdpfood.dto.department.DepartmentCreateDto;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.dto.department.DepartmentUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("departmentService")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Long create(DepartmentCreateDto createDto) {
        return null;
    }

    @Override
    public DepartmentDto update(Long id, DepartmentUpdateDto updateDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return null;
    }

    @Override
    public DepartmentDto get(Long id) {
        return null;
    }
}
