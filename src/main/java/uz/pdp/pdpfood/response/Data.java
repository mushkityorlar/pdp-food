package uz.pdp.pdpfood.response;

import lombok.Getter;

@Getter
public class Data<T> {

    private Integer totalCount;
    private final T body;

    public Data(T body) {
        this.body = body;
    }

    public Data(Integer totalCount, T body) {
        this.totalCount = totalCount;
        this.body = body;
    }
}
