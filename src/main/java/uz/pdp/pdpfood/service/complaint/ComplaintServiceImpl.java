package uz.pdp.pdpfood.service.complaint;

import uz.pdp.pdpfood.dto.complain.ComplainCreateDto;
import uz.pdp.pdpfood.dto.complain.ComplainDto;
import uz.pdp.pdpfood.dto.complain.ComplainUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.pdpfood.entity.complaint.Complaint;
import uz.pdp.pdpfood.mapper.complaint.ComplaintMapper;
import uz.pdp.pdpfood.repository.ComplaintRepository;
import uz.pdp.pdpfood.service.AbstractService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("complaintService")
@Slf4j
@Transactional
public class ComplaintServiceImpl extends AbstractService<ComplaintRepository, ComplaintMapper> implements ComplaintService {

    public ComplaintServiceImpl(ComplaintRepository repository, ComplaintMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(ComplainCreateDto createDto) {
        log.info("saving complain {}", createDto.getText());
        Complaint complaint = mapper.fromCreateDto(createDto);
        repository.save(complaint);
        return complaint.getId();
    }

    @Override
    public ComplainDto update(Long id, ComplainUpdateDto updateDto) {
        Complaint complaint = mapper.fromUpdateDto(updateDto);
        repository.save(complaint);
        return mapper.toDto(complaint);
    }

    @Override
    public Void delete(Long id) {
        repository.delete(id);
        return null;
    }

    @Override
    public List<ComplainDto> getAll() {
        log.info("fetching all complains");
        List<Complaint> complaints = repository.findAll();
        return mapper.toDto(complaints);
    }

    @Override
    public ComplainDto get(Long id) {
        Optional<Complaint> complaint = repository.findById(id);
        return mapper.toDto(complaint.get());
    }
}
