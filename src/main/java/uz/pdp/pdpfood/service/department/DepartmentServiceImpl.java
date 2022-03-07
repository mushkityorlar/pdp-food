package uz.pdp.pdpfood.service.department;

import uz.pdp.pdpfood.dto.department.DepartmentCreateDto;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.dto.department.DepartmentUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.pdpfood.entity.department.Department;
import uz.pdp.pdpfood.mapper.department.DepartmentMapper;
import uz.pdp.pdpfood.repository.DepartmentRepository;
import uz.pdp.pdpfood.service.AbstractService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("departmentService")
@Slf4j
@Transactional
public class DepartmentServiceImpl extends AbstractService<DepartmentRepository, DepartmentMapper> implements DepartmentService {
    public DepartmentServiceImpl(DepartmentRepository repository, DepartmentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(DepartmentCreateDto createDto) {
        log.info("saving Department {}", createDto.getName());
        Department department = mapper.fromCreateDto(createDto);
        repository.save(department);
        return department.getId();
    }

    @Override
    public DepartmentDto update(Long id, DepartmentUpdateDto updateDto) {
        Department department = mapper.fromUpdateDto(updateDto);
        repository.save(department);
        return mapper.toDto(department);
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        log.info("fetching all departments");
        List<Department> departments = repository.findAll();
        return mapper.toDto(departments);
    }

    @Override
    public DepartmentDto get(Long id) {
        Optional<Department> department = repository.findById(id);
        return mapper.toDto(department.get());
    }
}
