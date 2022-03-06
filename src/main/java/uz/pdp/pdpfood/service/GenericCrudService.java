package uz.pdp.pdpfood.service;

import uz.pdp.pdpfood.dto.Dto;
import uz.pdp.pdpfood.dto.GenericDto;
import uz.pdp.pdpfood.entity.BaseEntity;

import java.io.Serializable;


public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto,
        K extends Serializable> extends GenericService<D, K> {

    K create(CD createDto);

    D update(K id, UD updateDto);

    Void delete(K id);
}
