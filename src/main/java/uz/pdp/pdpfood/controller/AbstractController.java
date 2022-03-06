package uz.pdp.pdpfood.controller;


import uz.pdp.pdpfood.service.BaseService;


public abstract class AbstractController<S extends BaseService> {
    public final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
