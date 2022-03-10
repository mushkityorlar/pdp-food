package uz.pdp.pdpfood.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.pdpfood.dto.complain.ComplainCreateDto;
import uz.pdp.pdpfood.dto.complain.ComplainDto;
import uz.pdp.pdpfood.dto.complain.ComplainUpdateDto;
import uz.pdp.pdpfood.service.complaint.ComplaintServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/complaint")
public class ComplaintController extends AbstractController<ComplaintServiceImpl> {

    public ComplaintController(ComplaintServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody ComplainCreateDto dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ComplainDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ComplainDto> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ComplainDto update(@PathVariable Long id, ComplainUpdateDto dto) {
        return service.update(id, dto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
