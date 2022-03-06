package uz.pdp.pdpfood.service.complaint;

import uz.pdp.pdpfood.dto.complain.ComplainCreateDto;
import uz.pdp.pdpfood.dto.complain.ComplainDto;
import uz.pdp.pdpfood.dto.complain.ComplainUpdateDto;
import uz.pdp.pdpfood.entity.complaint.Complaint;
import uz.pdp.pdpfood.service.BaseService;
import uz.pdp.pdpfood.service.GenericCrudService;

public interface ComplaintService extends GenericCrudService<
        Complaint,
        ComplainDto,
        ComplainCreateDto,
        ComplainUpdateDto,
        Long>,
        BaseService {
}
