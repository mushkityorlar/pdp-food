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
    ComplainDto toDto(Complaint complaint);

    @Override
    List<ComplainDto> toDto(List<Complaint> e);

    @Override
    Complaint fromCreateDto(ComplainCreateDto complainCreateDto);

    @Override
    Complaint fromUpdateDto(ComplainUpdateDto d);
}
