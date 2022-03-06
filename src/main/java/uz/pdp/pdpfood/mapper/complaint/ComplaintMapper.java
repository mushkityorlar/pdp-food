package uz.pdp.pdpfood.mapper.complaint;

import uz.pdp.pdpfood.dto.complain.ComplainCreateDto;
import uz.pdp.pdpfood.dto.complain.ComplainDto;
import uz.pdp.pdpfood.dto.complain.ComplainUpdateDto;
import uz.pdp.pdpfood.entity.complaint.Complaint;
import uz.pdp.pdpfood.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ComplaintMapper extends BaseMapper<
        Complaint,
        ComplainDto,
        ComplainCreateDto,
        ComplainUpdateDto> {
    @Override
    default ComplainDto toDto(Complaint complaint) {
        return null;
    }

    @Override
    default List<ComplainDto> toDto(List<Complaint> e) {
        return null;
    }

    @Override
    default Complaint fromCreateDto(ComplainCreateDto complainCreateDto) {
        return null;
    }

    @Override
    default Complaint fromUpdateDto(ComplainUpdateDto d) {
        return null;
    }
}
