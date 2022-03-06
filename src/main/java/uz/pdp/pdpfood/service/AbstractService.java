package uz.pdp.pdpfood.service;

import uz.pdp.pdpfood.mapper.Mapper;
import uz.pdp.pdpfood.repository.AbstractRepository;

public abstract class AbstractService <R extends AbstractRepository,M extends Mapper> {
    protected final   R repository;
    protected final   M mapper;

    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
